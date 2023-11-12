package com.aniket.graalvm.interoperability.bridge;

import com.aniket.graalvm.interoperability.service.LanguageBridgeAdviceService;
import org.graalvm.polyglot.Context;
import org.graalvm.polyglot.Source;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ResourceLoader;

import java.io.IOException;

import static com.aniket.graalvm.interoperability.constant.PythonConstants.*;

@Configuration
public class LanguageBridge {

    ResourceLoader resourceLoader;
    public LanguageBridge(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    @Bean
    public LanguageBridgeAdviceService getRecommendationService() throws IOException {
        Context context = Context
                .newBuilder(PYTHON_ENGINE_NAME)
                .allowAllAccess(true)
                .option(PYTHON_OPTION_FORCE_IMPORT_SITE, "true")
                .option(PYTHON_OPTION_PYTHON_PATH,
                        resourceLoader
                                .getResource(PY_PATH)
                                .getFile()
                                .toPath()
                                .toString()).build();

        Source source = Source.newBuilder(
                    "python", resourceLoader.getResource(PY_PATH + PORTFOLIO_ADVISOR_PY).getFile()).build();

        context.eval(source);

        return context.getBindings("python").getMember(PORTFOLIO_ADVISOR).as(LanguageBridgeAdviceService.class);
    }

}
