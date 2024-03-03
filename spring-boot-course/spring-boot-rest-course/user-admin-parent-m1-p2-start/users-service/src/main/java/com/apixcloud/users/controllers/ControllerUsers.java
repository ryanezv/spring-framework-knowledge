package com.apixcloud.users.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;

import com.apixcloud.commos.utils.RestPreconditions;
import com.apixcloud.users.persistence.models.User;
import com.apixcloud.users.persistence.models.UserEntity;
import com.apixcloud.users.services.IUserService;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
@RequestMapping("/users")
public class ControllerUsers {

    @Autowired
    private IUserService service;

    Map<Integer, User> mapUsers = new HashMap<>();

    public ControllerUsers(){
        this.mapUsers.put(1, new User(1, "Ricardo1", "admin123"));        
        this.mapUsers.put(2, new User(2, "Ricardo2", "admin123"));
        this.mapUsers.put(3, new User(3, "Ricardo3", "admin123"));
        this.mapUsers.put(4, new User(4, "Ricardo4", "admin123"));
        this.mapUsers.put(5, new User(5, "Ricardo5", "admin123"));
        this.mapUsers.put(6, new User(6, "Ricardo6", "admin123"));
        this.mapUsers.put(7, new User(7, "Ricardo7", "admin123"));
        this.mapUsers.put(8, new User(8, "Ricardo8", "admin123"));
        this.mapUsers.put(9, new User(9, "Ricardo9", "admin123"));
        this.mapUsers.put(10, new User(10, "Ricardo10", "admin123"));
        this.mapUsers.put(11, new User(11, "Ricardo11", "admin123"));
        this.mapUsers.put(12, new User(12, "Ricardo12", "admin123"));
        this.mapUsers.put(13, new User(13, "Ricardo13", "admin123"));
        this.mapUsers.put(14, new User(14, "Ricardo14", "admin123"));
        this.mapUsers.put(15, new User(15, "Ricardo15", "admin123"));
        this.mapUsers.put(16, new User(16, "Ricardo16", "admin123"));
        this.mapUsers.put(17, new User(17, "Ricardo17", "admin123"));
        this.mapUsers.put(18, new User(18, "Ricardo18", "admin123"));
        this.mapUsers.put(19, new User(19, "Ricardo19", "admin123"));
        this.mapUsers.put(20, new User(20, "Ricardo20", "admin123"));
    }
    /* find all users */

    @RequestMapping(method=RequestMethod.GET)
    @ResponseBody
    public List<UserEntity> findAll() {
        //return new ArrayList<>(mapUsers.values());
        return service.findAll();
    }

    /* find one user */

    @RequestMapping(value="/{id}", method=RequestMethod.GET)
    @ResponseBody
    public UserEntity findOne(@PathVariable("id") final int id) {
        return service.findOne(id);
        //return mapUsers.get(id);
    }
    
    // create

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody final UserEntity user) {
        //mapUsers.put(mapUsers.size()+1, user);
        RestPreconditions.checkRequestElementNotNull(user);
        //RestPreconditions.checkRequestState(user.getId() == null);        
        service.create(user);
    }

    // update

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable("id") final int id, @RequestBody final UserEntity user) {
        //mapUsers.put(id, user);
        service.update(user);
    }

    // delete

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") final int id) {
        //mapUsers.remove(id);
        service.delete(id);
    }
}
