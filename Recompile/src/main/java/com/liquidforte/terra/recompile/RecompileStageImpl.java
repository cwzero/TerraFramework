package com.liquidforte.terra.recompile;

import com.google.inject.Inject;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.api.stage.AbstractStage;
import com.liquidforte.terra.api.stage.RecompileStage;

public class RecompileStageImpl extends AbstractStage implements RecompileStage {
	@Inject
	public RecompileStageImpl(PipelineConfiguration pipelineConfig) {
		super(pipelineConfig);
	}
	@Override
	public void run() {
		
	}
}
