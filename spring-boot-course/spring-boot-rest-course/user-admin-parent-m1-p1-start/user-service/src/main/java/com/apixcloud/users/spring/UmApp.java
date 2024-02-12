package com.apixcloud.users.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import com.apixcloud.users.persistence.setup.MyApplicationContextInitializer;

@SpringBootApplication
@Import({ // @formatter:off
    UmContextConfig.class,
    UmPersistenceJpaConfig.class,
    UmServiceConfig.class,
    UmWebConfig.class
}) // @formatter:on
public class UmApp {

    public static void main(final String... args) {
        new SpringApplicationBuilder(UmApp.class).initializers(new MyApplicationContextInitializer())
            .listeners()
            .run(args);
    }

}
