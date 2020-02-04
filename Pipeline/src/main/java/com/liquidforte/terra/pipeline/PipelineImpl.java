package com.liquidforte.terra.pipeline;

import com.google.inject.Inject;
import com.liquidforte.terra.api.pipeline.AbstractPipeline;
import com.liquidforte.terra.api.pipeline.PipelineConfiguration;
import com.liquidforte.terra.api.stage.DecompileStage;
import com.liquidforte.terra.api.stage.DeobfuscateStage;
import com.liquidforte.terra.api.stage.DownloadStage;
import com.liquidforte.terra.api.stage.ModularizeStage;
import com.liquidforte.terra.api.stage.PatchStage;
import com.liquidforte.terra.api.stage.RecompileStage;

public class PipelineImpl extends AbstractPipeline {
	@Inject
	public PipelineImpl(PipelineConfiguration config, DownloadStage downloadStage, DeobfuscateStage deobfuscateStage,
			DecompileStage decompileStage, PatchStage patchStage, ModularizeStage modularizeStage,
			RecompileStage recompileStage) {
		super(config, downloadStage, deobfuscateStage, decompileStage, patchStage, modularizeStage, recompileStage);
	}

	@Override
	public void run() {
		getDownloadStage().run();
		getDeobfuscateStage().run();
		getDecompileStage().run();
		getPatchStage().run();
		getModularizeStage().run();
		getRecompileStage().run();
	}
}
