package com.liquidforte.terra.pipeline.inject;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.liquidforte.terra.api.pipeline.Pipeline;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.pipeline.PipelineConfigurationImpl;
import com.liquidforte.terra.pipeline.PipelineImpl;

public class PipelineModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Pipeline.class).to(PipelineImpl.class);
	}

	@Provides
	public PipelineConfiguration getConfiguration(ObjectMapper mapper) {
		PipelineConfiguration result = null;
		try {
			result = mapper.readValue(new File("config/pipeline.json"), PipelineConfigurationImpl.class);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}
}
