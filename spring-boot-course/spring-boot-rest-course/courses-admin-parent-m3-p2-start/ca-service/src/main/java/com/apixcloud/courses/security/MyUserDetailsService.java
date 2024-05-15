package com.apixcloud.courses.security;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.services.IUserService;
import com.google.common.base.Preconditions;
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
        /* 
        final Set<Role> rolesOfUser = user.getRoles();
        final Set<Privilege> privileges = Sets.newHashSet();
        for (final Role roleOfUser : rolesOfUser) {
            privileges.addAll(roleOfUser.getPrivileges());
        }
        final Function<Object, String> toStringFunction = Functions.toStringFunction();
        final Collection<String> rolesToString = Collections2.transform(privileges, toStringFunction);
        final String[] roleStringsAsArray = rolesToString.toArray(new String[rolesToString.size()]);
        final List<GrantedAuthority> auths = AuthorityUtils.createAuthorityList(roleStringsAsArray);
        */
        //log.info("username details: {}", myUser.toString());
        return new org.springframework.security.core.userdetails.User(username, myUser.getPassword(), AuthorityUtils.NO_AUTHORITIES);

    }

}
