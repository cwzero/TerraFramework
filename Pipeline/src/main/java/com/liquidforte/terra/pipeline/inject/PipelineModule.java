package com.liquidforte.terra.pipeline.inject;

import com.google.inject.AbstractModule;
import com.liquidforte.terra.api.pipeline.Pipeline;
import com.liquidforte.terra.pipeline.PipelineImpl;

public class PipelineModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(Pipeline.class).to(PipelineImpl.class);
	}
}
