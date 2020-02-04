package com.liquidforte.terra.api.configuration;

public abstract class AbstractConfiguration implements Configuration {
	private String minecraftVersion;

	@Override
	public String getMinecraftVersion() {
		return minecraftVersion;
	}

	public void setMinecraftVersion(String minecraftVersion) {
		this.minecraftVersion = minecraftVersion;
	}
}
