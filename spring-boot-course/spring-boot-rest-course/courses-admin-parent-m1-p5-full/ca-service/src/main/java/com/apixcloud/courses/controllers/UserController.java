package com.apixcloud.courses.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apixcloud.courses.config.JwtPropertiesConfig;
import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.services.IUserService;

@RestController
@RequestMapping("/users")
public class UserController { 

    @Value("${spring.profiles.active}")
    private String environmentActive;

    @Value("${apixcloud.courses.security.jwt.signing-key}")
    private String jwtKey;

    @Autowired
    private Environment environment;

    @Autowired
    private JwtPropertiesConfig jwtProperties;

    @Autowired
    IUserService userService;

    Map<Integer, User> users = new HashMap<>();
    
    @GetMapping(
        value = "/hello",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User hello(
        @RequestParam(value = "firstname", defaultValue = "SN") String firstName,
        @RequestParam(value = "lastname", defaultValue = "SA") String lastName
    ) {
        System.out.println("Env="+ environmentActive);
        System.out.println("JWT type="+ environment.getProperty("apixcloud.courses.security.jwt.type"));        
        System.out.println("JWT data:"+ jwtProperties.toString());
        System.out.println("Mi propiedad="+ environment.getProperty("apixcloud.courses.config.property-test"));        
        System.out.println("Hola "+ firstName +" "+ lastName);

        return new User(); //new User(Long.valueOf(1), firstName, lastName, true);
    }

    // C - create
    
    @RequestMapping(
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody User user){
        userService.create(user);
        //users.put(users.size()+1, user);        
    }

    // R - read

    @RequestMapping(
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<User> findAll(){
        return userService.findAll();
        //return new ArrayList<>(users.values());
    }

    // U - update

    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.PUT,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") int id, @RequestBody User user){
        userService.update(user);
        //users.put(id, user);
    }

    // D - delete

    @RequestMapping(
        value = "/{id}",
        method = RequestMethod.DELETE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id){
        userService.delete(id);
        //users.remove(id);
    }

}
