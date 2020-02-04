package com.liquidforte.terra.download.versionmanifest;

import java.net.URL;

public class Asset {
	private String sha1;
	private long size;
	private URL url;

	public Asset() {
		
	}

	public Asset(String sha1, long size, URL url) {
		
		this.sha1 = sha1;
		this.size = size;
		this.url = url;
	}

	public String getSha1() {
		return sha1;
	}

	public void setSha1(String sha1) {
		this.sha1 = sha1;
	}

	public long getSize() {
		return size;
	}

	public void setSize(long size) {
		this.size = size;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
}
