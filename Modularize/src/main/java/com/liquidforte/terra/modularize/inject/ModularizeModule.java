package com.liquidforte.terra.modularize.inject;

import com.google.inject.AbstractModule;
import com.liquidforte.terra.api.stage.ModularizeStage;
import com.liquidforte.terra.modularize.ModularizeStageImpl;

public class ModularizeModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(ModularizeStage.class).to(ModularizeStageImpl.class);
	}
}
