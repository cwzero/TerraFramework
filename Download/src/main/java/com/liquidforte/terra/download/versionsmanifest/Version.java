package com.liquidforte.terra.download.versionsmanifest;

import java.net.URL;
import java.util.Date;

public class Version {
	private String id;
	private String type;
	private URL url;
	private Date time;
	private Date releaseTime;

	public Version() {

	}

	public Version(String id, String type, URL url, Date time, Date releaseTime) {
		this.id = id;
		this.type = type;
		this.url = url;
		this.time = time;
		this.releaseTime = releaseTime;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public URL getUrl() {
		return url;
	}

	public void setUrl(URL url) {
		this.url = url;
	}

	public Date getTime() {
		return time;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public Date getReleaseTime() {
		return releaseTime;
	}

	public void setReleaseTime(Date releaseTime) {
		this.releaseTime = releaseTime;
	}
}
