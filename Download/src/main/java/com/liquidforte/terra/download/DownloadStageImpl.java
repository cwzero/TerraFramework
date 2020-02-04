package com.liquidforte.terra.download;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.api.stage.AbstractStage;
import com.liquidforte.terra.api.stage.DownloadStage;
import com.liquidforte.terra.download.versionmanifest.VersionManifest;
import com.liquidforte.terra.download.versionsmanifest.VersionsManifest;

public class DownloadStageImpl extends AbstractStage implements DownloadStage {
	private static final String VERSIONS_JSON_URL_STRING = "https://launchermeta.mojang.com/mc/game/version_manifest.json";

	private ObjectMapper objectMapper;
	private Provider<CloseableHttpClient> httpClientProvider;

	@Inject
	public DownloadStageImpl(PipelineConfiguration pipelineConfig, Provider<CloseableHttpClient> httpClientProvider,
			ObjectMapper objectMapper) {
		super(pipelineConfig);
		this.httpClientProvider = httpClientProvider;
		this.objectMapper = objectMapper;
	}

	private VersionsManifest loadVersions() {
		VersionsManifest versions = null;

		try (CloseableHttpClient httpClient = httpClientProvider.get()) {
			HttpGet req = new HttpGet(VERSIONS_JSON_URL_STRING);
			CloseableHttpResponse resp = httpClient.execute(req);
			try {
				versions = objectMapper.readValue(resp.getEntity().getContent(), VersionsManifest.class);
			} finally {
				resp.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return versions;
	}

	private VersionManifest loadTargetVersionManifest(VersionsManifest versions) {
		VersionManifest version = null;

		try (CloseableHttpClient httpClient = httpClientProvider.get()) {
			String targetVersion = getPipelineConfig().getMinecraftVersion();
			String targetUrl = versions.getVersion(targetVersion).get().getUrl().toString();
			HttpGet req = new HttpGet(targetUrl);
			CloseableHttpResponse resp = httpClient.execute(req);
			try {
				version = objectMapper.readValue(resp.getEntity().getContent(), VersionManifest.class);
			} finally {
				resp.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return version;
	}
	
	private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = HEX_ARRAY[v >>> 4];
	        hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
	    }
	    return new String(hexChars);
	}

	private boolean checkSha1(File file, String sha1) {
		sha1 = sha1.trim().toUpperCase();
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-1");
			InputStream fis = new FileInputStream(file);
			int n = 0;
			byte[] buffer = new byte[8192];
			while (n != -1) {
				n = fis.read(buffer);
				if (n > 0) {
					digest.update(buffer, 0, n);
				}
			}
			fis.close();
			String s = bytesToHex(digest.digest()).trim().toUpperCase();
			boolean result = s.contentEquals(sha1);
			
			if (!result) {
				System.out.println("No match.  File: " + file.getAbsolutePath());
				System.out.println("File SHA1: " + s);
				System.out.println("Expected: " + sha1);
			}
			
			return result;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public void run() {
		VersionsManifest versions = loadVersions();
		VersionManifest target = loadTargetVersionManifest(versions);

		for (String fileName : target.getDownloads().keySet()) {
			String url = target.getDownloads().get(fileName).getUrl().toString();
			String ext = url.substring(url.lastIndexOf('.') + 1);
			String file = "minecraft_" + fileName + "_" + getPipelineConfig().getMinecraftVersion() + "." + ext;

			File f = new File(file);
			String sha1 = target.getDownloads().get(fileName).getSha1();
			if (!f.exists() || !checkSha1(f, sha1)) {
				System.out.println("Downloading " + f.getAbsolutePath());
				try (CloseableHttpClient httpClient = httpClientProvider.get()) {
					HttpGet req = new HttpGet(url);
					CloseableHttpResponse resp = httpClient.execute(req);
					resp.getEntity().writeTo(new FileOutputStream(file));
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
