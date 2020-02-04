package com.liquidforte.terra.decompile.inject;

import com.google.inject.AbstractModule;
import com.liquidforte.terra.api.stage.DecompileStage;
import com.liquidforte.terra.decompile.DecompileStageImpl;

public class DecompileModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(DecompileStage.class).to(DecompileStageImpl.class);
	}
}
