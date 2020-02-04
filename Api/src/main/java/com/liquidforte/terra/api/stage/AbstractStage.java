package com.liquidforte.terra.api.stage;

import com.liquidforte.terra.api.pipeline.PipelineConfiguration;

public abstract class AbstractStage implements Stage {
	private PipelineConfiguration pipelineConfig;

	public AbstractStage(PipelineConfiguration pipelineConfig) {
		this.pipelineConfig = pipelineConfig;
	}

	public PipelineConfiguration getPipelineConfig() {
		return pipelineConfig;
	}

	public void setPipelineConfig(PipelineConfiguration pipelineConfig) {
		this.pipelineConfig = pipelineConfig;
	}
}
