package com.liquidforte.terra.download.inject;

import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.liquidforte.terra.api.stage.DownloadStage;
import com.liquidforte.terra.download.DownloadStageImpl;

public class DownloadModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(DownloadStage.class).to(DownloadStageImpl.class);
	}
	
	@Provides
	protected ObjectMapper getObjectMapper() {
		return new ObjectMapper()
				 .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
				.enable(SerializationFeature.INDENT_OUTPUT);
	}
	
	@Provides
	protected CloseableHttpClient getHttpClient() {
		return HttpClients.createDefault();
	}
}
