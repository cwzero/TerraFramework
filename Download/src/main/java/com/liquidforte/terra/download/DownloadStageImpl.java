package com.liquidforte.terra.download;

import java.io.IOException;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.liquidforte.terra.api.pipeline.AbstractStage;
import com.liquidforte.terra.api.stage.DownloadStage;
import com.liquidforte.terra.download.versionmanifest.VersionManifest;
import com.liquidforte.terra.download.versionsmanifest.VersionsManifest;

public class DownloadStageImpl extends AbstractStage implements DownloadStage {
	private static final String VERSIONS_JSON_URL_STRING = "https://launchermeta.mojang.com/mc/game/version_manifest.json";

	private ObjectMapper objectMapper;
	private Provider<CloseableHttpClient> httpClientProvider;

	@Inject
	public DownloadStageImpl(Provider<CloseableHttpClient> httpClientProvider, ObjectMapper objectMapper) {
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
	
	private VersionManifest loadLatestVersionManifest(VersionsManifest versions) {
		VersionManifest version = null;
		
		try (CloseableHttpClient httpClient = httpClientProvider.get()) {
			HttpGet req = new HttpGet(versions.getLatestRelease().get().getUrl().toString());
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

	@Override
	public void run() {
		VersionsManifest versions = loadVersions();
		VersionManifest latest = loadLatestVersionManifest(versions);
		
		try {
			System.out.println(objectMapper.writeValueAsString(latest));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
	}
}
