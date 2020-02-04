package com.liquidforte.terra.pipeline;

import com.google.inject.Inject;
import com.liquidforte.terra.api.pipeline.AbstractPipeline;
import com.liquidforte.terra.api.stage.DecompileStage;
import com.liquidforte.terra.api.stage.DeobfuscateStage;
import com.liquidforte.terra.api.stage.DownloadStage;
import com.liquidforte.terra.api.stage.ModularizeStage;
import com.liquidforte.terra.api.stage.PatchStage;
import com.liquidforte.terra.api.stage.RecompileStage;

public class PipelineImpl extends AbstractPipeline {
	@Inject
	public PipelineImpl(DownloadStage downloadStage, DeobfuscateStage deobfuscateStage, DecompileStage decompileStage,
			PatchStage patchStage, ModularizeStage modularizeStage, RecompileStage recompileStage) {
		super(downloadStage, deobfuscateStage, decompileStage, patchStage, modularizeStage, recompileStage);
	}
}
