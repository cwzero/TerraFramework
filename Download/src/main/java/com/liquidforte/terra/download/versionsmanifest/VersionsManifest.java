package com.liquidforte.terra.download.versionsmanifest;

import java.util.Arrays;
import java.util.Optional;

public class VersionsManifest {
	private Latest latest;
	private Version[] versions;

	public VersionsManifest() {

	}

	public VersionsManifest(Latest latest, Version[] versions) {
		this.latest = latest;
		this.versions = versions;
	}

	public Latest getLatest() {
		return latest;
	}

	public void setLatest(Latest latest) {
		this.latest = latest;
	}

	public Version[] getVersions() {
		return versions;
	}

	public void setVersions(Version[] versions) {
		this.versions = versions;
	}
	
	public Optional<Version> getVersion(String id) {
		return Arrays.asList(versions).stream().filter(v -> v.getId().contentEquals(id)).findFirst();
	}
	
	public Optional<Version> getLatestRelease() {
		return getVersion(latest.getRelease());
	}
	
	public Optional<Version> getLatestSnapshot() {
		return getVersion(latest.getSnapshot());
	}
}
