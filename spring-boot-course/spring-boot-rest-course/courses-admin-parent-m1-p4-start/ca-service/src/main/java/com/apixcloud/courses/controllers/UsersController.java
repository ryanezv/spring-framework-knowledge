package com.apixcloud.courses.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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

import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.persistence.models.UserEntity;
import com.apixcloud.courses.services.IUserService;

@RestController
@RequestMapping("/users")
public class UsersController {

    @Autowired
    IUserService userService;

    Map<Integer, User> users = new HashMap<>();
    
    public UsersController(){
        users.put(1, new User(1, "Juan", "Juan123"));
        users.put(2, new User(2, "Pedro", "Pedro123"));
        users.put(3, new User(3, "Jose", "Jose123"));
    }

    @GetMapping(
        value = "/hello",
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public User hello(
        @RequestParam(value = "firstname", defaultValue = "SN") String firstName,
        @RequestParam(value = "lastname", defaultValue = "SA") String lastName
    ) {
        System.out.println("Hola "+ firstName +" "+ lastName);
        return new User(1, firstName, lastName);
    }

    // C - create
    
    @RequestMapping(
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody UserEntity user){
        userService.create(user);
        //users.put(users.size()+1, user);        
    }

    // R - read

    @RequestMapping(
        method = RequestMethod.GET,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<UserEntity> findAll(){
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
    public void update(@PathVariable("id") int id, @RequestBody UserEntity user){
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
