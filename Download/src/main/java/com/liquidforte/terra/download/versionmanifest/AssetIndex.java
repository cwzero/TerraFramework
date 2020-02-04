package com.liquidforte.terra.download.versionmanifest;

import java.net.URL;

public class AssetIndex {
	private String id;
	private String sha1;
	private long size;
	private long totalSize;
	private URL url;

	public AssetIndex() {

	}

	public AssetIndex(String id, String sha1, long size, long totalSize, URL url) {
		this.id = id;
		this.sha1 = sha1;
		this.size = size;
		this.totalSize = totalSize;
		this.url = url;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public long getTotalSize() {
		return totalSize;
	}

	public void setTotalSize(long totalSize) {
		this.totalSize = totalSize;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}
}
