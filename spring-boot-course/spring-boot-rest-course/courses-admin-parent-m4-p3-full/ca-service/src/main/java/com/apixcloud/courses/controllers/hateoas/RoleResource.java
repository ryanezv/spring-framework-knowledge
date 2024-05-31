package com.apixcloud.courses.controllers.hateoas;

import org.springframework.hateoas.RepresentationModel;

import com.apixcloud.courses.persistence.models.Role;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

public class RoleResource extends RepresentationModel<RoleResource> {

    private final Role role;

    public RoleResource(final Role role) {
        this.role = role;

        this.add(linkTo(RoleHateoasControllerSimple.class).withRel("roles"));
        this.add(linkTo(methodOn(RoleHateoasControllerSimple.class, role).findOne(role.getId())).withSelfRel());
    }

    public Role getRole() {
        return role;
    }

}
