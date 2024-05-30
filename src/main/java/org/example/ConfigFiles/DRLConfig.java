package org.example.ConfigFiles;

import org.kie.api.KieServices;
import org.kie.api.builder.KieBuilder;
import org.kie.api.builder.KieFileSystem;
import org.kie.api.builder.KieModule;
import org.kie.api.runtime.StatelessKieSession;
import org.kie.internal.io.ResourceFactory;

public class DRLConfig {
    public static StatelessKieSession kieSession;

    static {
        KieServices kieServices = KieServices.Factory.get();
        KieFileSystem kieFileSystem = kieServices.newKieFileSystem();
        kieFileSystem.write(ResourceFactory.newClassPathResource("breaker.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("bus.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("line.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("generate.drl"));
        kieFileSystem.write(ResourceFactory.newClassPathResource("transformer.drl"));
        KieBuilder kieBuilder = kieServices.newKieBuilder(kieFileSystem);
        kieBuilder.buildAll();
        KieModule kieModule = kieBuilder.getKieModule();
        kieSession = kieServices.newKieContainer(kieModule.getReleaseId()).newStatelessKieSession();
    }

    public DRLConfig() {
    }
}
