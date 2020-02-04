package com.liquidforte.terra.deobfuscate;

import com.google.inject.Inject;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.api.stage.AbstractStage;
import com.liquidforte.terra.api.stage.DeobfuscateStage;

public class DeobfuscateStageImpl extends AbstractStage implements DeobfuscateStage {
	@Inject
	public DeobfuscateStageImpl(PipelineConfiguration pipelineConfig) {
		super(pipelineConfig);
	}
	@Override
	public void run() {
		
	}
}
