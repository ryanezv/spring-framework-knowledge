package com.apixcloud.umusers.persistence.setup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.apixcloud.umusers.persistence.daos.UserRepository;
import com.apixcloud.umusers.persistence.models.User;

@Configuration
class SetupDatabase {
    
    private static final Logger log = LoggerFactory.getLogger(SetupDatabase.class);

    @Bean
    CommandLineRunner initDatabase(UserRepository repository){
        return args -> {
            log.info("Load new user {}", repository.save(new User("ryanezv", "ryanezv@gmail.com")));
            log.info("Load new user {}",repository.save(new User("lopez", "lopez@gmail.com")));
            log.info("Load new user {}",repository.save(new User("juan", "juan@gmail.com")));
        };
    }
}
