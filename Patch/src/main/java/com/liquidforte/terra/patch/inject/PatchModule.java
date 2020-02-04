package com.liquidforte.terra.patch.inject;

import com.google.inject.AbstractModule;
import com.liquidforte.terra.api.stage.PatchStage;
import com.liquidforte.terra.patch.PatchStageImpl;

public class PatchModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(PatchStage.class).to(PatchStageImpl.class);
	}
}
