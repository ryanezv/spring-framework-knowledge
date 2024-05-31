package com.apixcloud.courses.controllers.hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.apixcloud.courses.persistence.models.Role;
import com.apixcloud.courses.services.IRoleService;
import com.apixcloud.courses.utils.UmMappings;

import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping(value = UmMappings.Hateoas.ROLES)
public class RoleHateoasControllerSimple {

    @Autowired
    private IRoleService service;

    // API - find - one

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public EntityModel<Role> findOne(@PathVariable("id") final Long id) {
        final Role entity = service.findOne(id);
        return EntityModel.of(entity,
        linkTo(methodOn(RoleHateoasControllerSimple.class).findOne(id)).withSelfRel(),
        linkTo(methodOn(RoleHateoasControllerSimple.class).findAll()).withRel("roles"));
        //return new RoleResource(entity);
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Role> findAll(){ 
        List<Role> roles = service.findAll();

        return roles;
    }
}
