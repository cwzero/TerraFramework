package com.liquidforte.terra.api.pipeline;

import com.liquidforte.terra.api.stage.DecompileStage;
import com.liquidforte.terra.api.stage.DeobfuscateStage;
import com.liquidforte.terra.api.stage.DownloadStage;
import com.liquidforte.terra.api.stage.ModularizeStage;
import com.liquidforte.terra.api.stage.PatchStage;
import com.liquidforte.terra.api.stage.RecompileStage;

public abstract class AbstractPipeline implements Pipeline {
	private PipelineConfiguration config;
	private DownloadStage downloadStage;
	private DeobfuscateStage deobfuscateStage;
	private DecompileStage decompileStage;
	private PatchStage patchStage;
	private ModularizeStage modularizeStage;
	private RecompileStage recompileStage;

	public AbstractPipeline(PipelineConfiguration config, DownloadStage downloadStage, DeobfuscateStage deobfuscateStage,
			DecompileStage decompileStage, PatchStage patchStage, ModularizeStage modularizeStage,
			RecompileStage recompileStage) {
		this.config = config;
		this.downloadStage = downloadStage;
		this.deobfuscateStage = deobfuscateStage;
		this.decompileStage = decompileStage;
		this.patchStage = patchStage;
		this.modularizeStage = modularizeStage;
		this.recompileStage = recompileStage;
	}
	
	public PipelineConfiguration getConfig() {
		return config;
	}

	public DownloadStage getDownloadStage() {
		return downloadStage;
	}
	
	public DeobfuscateStage getDeobfuscateStage() {
		return deobfuscateStage;
	}
	
	public DecompileStage getDecompileStage() {
		return decompileStage;
	}

	public PatchStage getPatchStage() {
		return patchStage;
	}

	public ModularizeStage getModularizeStage() {
		return modularizeStage;
	}
	
	public RecompileStage getRecompileStage() {
		return recompileStage;
	}
}
