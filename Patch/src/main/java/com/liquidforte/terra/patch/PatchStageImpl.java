package com.liquidforte.terra.patch;

import com.google.inject.Inject;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.api.stage.AbstractStage;
import com.liquidforte.terra.api.stage.PatchStage;

public class PatchStageImpl extends AbstractStage implements PatchStage {
	@Inject
	public PatchStageImpl(PipelineConfiguration pipelineConfig) {
		super(pipelineConfig);
	}
	@Override
	public void run() {
		
	}
}
