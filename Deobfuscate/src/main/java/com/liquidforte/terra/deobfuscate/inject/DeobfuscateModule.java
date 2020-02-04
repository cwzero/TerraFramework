package com.liquidforte.terra.deobfuscate.inject;

import com.google.inject.AbstractModule;
import com.liquidforte.terra.api.stage.DeobfuscateStage;
import com.liquidforte.terra.deobfuscate.DeobfuscateStageImpl;

public class DeobfuscateModule extends AbstractModule {
	@Override
	protected void configure() {
		bind(DeobfuscateStage.class).to(DeobfuscateStageImpl.class);
	}
}
