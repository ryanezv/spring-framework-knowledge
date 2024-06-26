package com.apixcloud.courses.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apixcloud.commons.utils.CaMappings;
import com.apixcloud.courses.persistence.models.Role;
import com.apixcloud.courses.services.IRoleService;

@RestController
@RequestMapping(value = CaMappings.ROLES)
public class RoleController {
    
    @Autowired
    private IRoleService service;


    @RequestMapping(
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE        
    )
    @ResponseStatus(HttpStatus.CREATED) 
    public void create(@RequestBody Role role){
        service.create(role);
    }

    @RequestMapping(
        method = RequestMethod.GET, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<Role> findAll(){
        return service.findAll();        
    }
}
