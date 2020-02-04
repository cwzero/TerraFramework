package com.liquidforte.terra.api.pipeline;

import com.liquidforte.terra.api.stage.DecompileStage;
import com.liquidforte.terra.api.stage.DeobfuscateStage;
import com.liquidforte.terra.api.stage.DownloadStage;
import com.liquidforte.terra.api.stage.ModularizeStage;
import com.liquidforte.terra.api.stage.PatchStage;
import com.liquidforte.terra.api.stage.RecompileStage;

public abstract class AbstractPipeline implements Pipeline {
	private DownloadStage downloadStage;
	private DeobfuscateStage deobfuscateStage;
	private DecompileStage decompileStage;
	private PatchStage patchStage;
	private ModularizeStage modularizeStage;
	private RecompileStage recompileStage;

	public AbstractPipeline(DownloadStage downloadStage, DeobfuscateStage deobfuscateStage,
			DecompileStage decompileStage, PatchStage patchStage, ModularizeStage modularizeStage,
			RecompileStage recompileStage) {
		this.downloadStage = downloadStage;
		this.deobfuscateStage = deobfuscateStage;
		this.decompileStage = decompileStage;
		this.patchStage = patchStage;
		this.modularizeStage = modularizeStage;
		this.recompileStage = recompileStage;
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
