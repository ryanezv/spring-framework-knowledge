package com.apixcloud.controllers;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.apixcloud.models.User;
import com.apixcloud.utils.MappingsUtil;

@RestController
@RequestMapping(MappingsUtil.basePath)
public class UserController {
    
    @GetMapping(
        value = MappingsUtil.helloPath,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User hello(
        @RequestParam(value = "firstname", defaultValue = "SN") String firstName,
        @RequestParam(value = "lastname", defaultValue = "SA") String lastName
    ) {
        System.out.println("Hola "+ firstName +" "+ lastName);
        return new User(firstName, lastName);
    }
}
