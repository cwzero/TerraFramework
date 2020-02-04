package com.liquidforte.terra.recompile.inject;

import com.google.inject.AbstractModule;
import com.liquidforte.terra.api.stage.RecompileStage;
import com.liquidforte.terra.recompile.RecompileStageImpl;

public class RecompileModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(RecompileStage.class).to(RecompileStageImpl.class);
	}
}
