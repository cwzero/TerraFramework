package com.liquidforte.terra.pipeline.main;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.google.inject.Module;
import com.liquidforte.terra.api.pipeline.Pipeline;
import com.liquidforte.terra.bytecode.inject.BytecodeModule;
import com.liquidforte.terra.decompile.inject.DecompileModule;
import com.liquidforte.terra.deobfuscate.inject.DeobfuscateModule;
import com.liquidforte.terra.download.inject.DownloadModule;
import com.liquidforte.terra.modularize.inject.ModularizeModule;
import com.liquidforte.terra.patch.inject.PatchModule;
import com.liquidforte.terra.pipeline.inject.PipelineModule;
import com.liquidforte.terra.recompile.inject.RecompileModule;
import com.liquidforte.terra.source.inject.SourceModule;
import com.liquidforte.terra.transform.inject.TransformModule;

public class Main {
	public static void main(String[] args) {
		Module[] modules = new Module[] {
			new TransformModule(),
			new BytecodeModule(),
			new SourceModule(),
			new DecompileModule(),
			new DeobfuscateModule(),
			new DownloadModule(),
			new ModularizeModule(),
			new PatchModule(),
			new RecompileModule(),
			new PipelineModule()
		};
		
		Injector injector = Guice.createInjector(modules);
		
		Pipeline pipeline = injector.getInstance(Pipeline.class);
		pipeline.run();
	}
}
