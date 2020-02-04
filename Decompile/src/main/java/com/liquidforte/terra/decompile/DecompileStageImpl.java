package com.liquidforte.terra.decompile;

import com.google.inject.Inject;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.api.stage.AbstractStage;
import com.liquidforte.terra.api.stage.DecompileStage;

public class DecompileStageImpl extends AbstractStage implements DecompileStage {
	@Inject
	public DecompileStageImpl(PipelineConfiguration pipelineConfig) {
		super(pipelineConfig);
	}
	
	@Override
	public void run() {
		
	}
}
