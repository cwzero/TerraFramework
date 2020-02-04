package com.liquidforte.terra.modularize;

import com.google.inject.Inject;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.api.stage.AbstractStage;
import com.liquidforte.terra.api.stage.ModularizeStage;

public class ModularizeStageImpl extends AbstractStage implements ModularizeStage {
	@Inject
	public ModularizeStageImpl(PipelineConfiguration pipelineConfig) {
		super(pipelineConfig);
	}
	@Override
	public void run() {
		
	}
}
