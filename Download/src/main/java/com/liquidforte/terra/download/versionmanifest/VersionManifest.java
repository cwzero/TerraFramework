package com.liquidforte.terra.download.versionmanifest;

import java.util.HashMap;
import java.util.Map;

public class VersionManifest {
	private AssetIndex assetIndex;
	private Map<String, Asset> downloads = new HashMap<>();

	public VersionManifest() {

	}

	public VersionManifest(AssetIndex assetIndex, Map<String, Asset> downloads) {
		this.assetIndex = assetIndex;
		this.downloads = downloads;
	}

	public AssetIndex getAssetIndex() {
		return assetIndex;
	}

	public void setAssetIndex(AssetIndex assetIndex) {
		this.assetIndex = assetIndex;
	}

	public Map<String, Asset> getDownloads() {
		return downloads;
	}

	public void setDownloads(Map<String, Asset> downloads) {
		this.downloads = downloads;
	}
}
