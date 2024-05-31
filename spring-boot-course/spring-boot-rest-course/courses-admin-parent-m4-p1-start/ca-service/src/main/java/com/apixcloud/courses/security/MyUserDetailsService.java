package com.apixcloud.courses.security;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.apixcloud.courses.persistence.models.Privilege;
import com.apixcloud.courses.persistence.models.Role;
import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.services.IUserService;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Preconditions;
import com.google.common.collect.Collections2;
import com.google.common.collect.Sets;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private IUserService userService;

    @Override
    public UserDetails loadUserByUsername(String username){

        log.info("username: {}", username);
        Preconditions.checkNotNull(username);

        //final User myUser = userService.findByName(username);        
        final User myUser = userService.findByUsername(username);
        if(Objects.isNull(myUser)){
            throw new UsernameNotFoundException("Usuario no encontrado: "+ username);        
        }
        
        final Set<Role> rolesOfUser = myUser.getRoles();
        final Set<Privilege> privileges = Sets.newHashSet();
        for (final Role roleOfUser : rolesOfUser) {
            privileges.addAll(roleOfUser.getPrivileges());
        }
        final Function<Object, String> toStringFunction = Functions.toStringFunction();
        final Collection<String> rolesToString = Collections2.transform(privileges, toStringFunction);
        final String[] roleStringsAsArray = rolesToString.toArray(new String[rolesToString.size()]);
        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(roleStringsAsArray);
        
        log.info("myUser: {}", myUser.toString());
        org.springframework.security.core.userdetails.User user = new org.springframework.security.core.userdetails.User(username, myUser.getPassword(), auths);

        log.info("The: {}", user.toString());

        return user;

    }

}
