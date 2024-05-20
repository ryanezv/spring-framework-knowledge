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
import com.apixcloud.courses.persistence.models.Privilege;
import com.apixcloud.courses.services.IPrivilegeService;

@RestController
@RequestMapping(value = CaMappings.PRIVILEGES)
public class PrivilegeController {
    
    @Autowired
    private IPrivilegeService service;

    @RequestMapping(
        method = RequestMethod.POST,
        produces = MediaType.APPLICATION_JSON_VALUE        
    )
    @ResponseStatus(HttpStatus.CREATED) 
    public void create(@RequestBody Privilege privilege){
        service.create(privilege);
    }

    @RequestMapping(
        method = RequestMethod.GET, 
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    @ResponseStatus(HttpStatus.OK)
    public List<Privilege> findAll(){
        return service.findAll();        
    }
}
