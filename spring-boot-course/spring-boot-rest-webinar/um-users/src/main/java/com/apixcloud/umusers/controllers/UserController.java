package com.apixcloud.umusers.controllers;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.RestController;

import com.apixcloud.umusers.persistence.daos.UserRepository;
import com.apixcloud.umusers.persistence.models.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping("/users")
public class UserController {
    
    @Autowired
    private UserRepository repository;

    @GetMapping
    public CollectionModel<User> findAll() {

        List<User> users = repository.findAll();

        users.stream()
                    .map(user -> user.add(linkTo(UserController.class).slash(user.getId()).withSelfRel()))
                    .collect(Collectors.toList());

        return CollectionModel.of(users, linkTo(methodOn(UserController.class).findAll()).withRel("findAll"));
    }

    @GetMapping("/{id}")
    public Optional<User> findById(
        @PathVariable Long id
    ){
        return repository.findById(id);
    }

    @PostMapping
    public User create(@RequestBody User user) {        
        return repository.save(user);
    }
    
    @PutMapping("/{id}")
    public User update(@PathVariable Long id, @RequestBody User newUser) {
        return repository.findById(id)
                .map(user -> {
                    user.setUsername(newUser.getUsername());
                    user.setEmail(newUser.getEmail());
                    user.setEnabled(newUser.getEnabled());
                    return repository.save(user);
                }
        )
        .orElseGet(() -> {
            newUser.setId(id);
            return repository.save(newUser);
        });
    }    

    @RequestMapping(path = "/search", method=RequestMethod.GET)
    public List<User> requestMethodName(@RequestParam String username) {
        return repository.findByUsername(username);
    }

}
