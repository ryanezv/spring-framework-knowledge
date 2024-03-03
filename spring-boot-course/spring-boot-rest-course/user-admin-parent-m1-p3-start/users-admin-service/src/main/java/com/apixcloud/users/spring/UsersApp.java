package com.apixcloud.users.spring;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.Import;
import com.apixcloud.users.persistence.setup.MyApplicationContextInitializer;

@SpringBootApplication
@Import({ // @formatter:off
    UsersContextConfig.class,
    UsersPersistenceJpaConfig.class,
    UsersServiceConfig.class,
    UsersWebConfig.class
}) // @formatter:on
public class UsersApp {

    public static void main(final String... args) {
        new SpringApplicationBuilder(UsersApp.class).initializers(new MyApplicationContextInitializer())
            .listeners()
            .run(args);
    }

}
