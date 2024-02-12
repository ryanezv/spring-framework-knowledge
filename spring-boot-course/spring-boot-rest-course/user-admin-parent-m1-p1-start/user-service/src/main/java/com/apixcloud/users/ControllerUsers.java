package com.apixcloud.users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.apixcloud.commons.utils.MappingsUtil;

@SpringBootApplication(scanBasePackages = "com.apixcloud.users")
@RequestMapping(MappingsUtil.basePath)
@RestController
public class ControllerUsers {


    @GetMapping(MappingsUtil.health)
    public ResponseEntity<String> health() {
        System.out.println("/health - OK");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    public static void main(String[] args) {
        SpringApplication.run(ControllerUsers.class, args);
    }
}
