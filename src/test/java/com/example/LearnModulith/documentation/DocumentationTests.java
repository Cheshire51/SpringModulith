package com.example.LearnModulith.documentation;

import com.example.LearnModulith.LearnModulithApplication;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class DocumentationTests {
    ApplicationModules applicationModule = ApplicationModules.of(LearnModulithApplication.class);
    @Test
    void writeDocumentationSnippet()
    {
        new Documenter(applicationModule)
                .writeModulesAsPlantUml()
                .writeIndividualModulesAsPlantUml()
                .writeModuleCanvases();

        Documenter.DiagramOptions.defaults()
                .withStyle(Documenter.DiagramOptions.DiagramStyle.UML);
    }
}
