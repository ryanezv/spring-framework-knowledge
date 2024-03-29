package com.apixcloud.users.persistence.setup;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.apixcloud.users.persistence.models.Privilege;
import com.apixcloud.users.persistence.models.Role;
import com.apixcloud.users.persistence.models.User;
import com.apixcloud.users.services.IPrivilegeService;
import com.apixcloud.users.services.IRoleService;
import com.apixcloud.users.services.IUserService;
import com.apixcloud.users.utils.UsersUtil.Privileges;
import com.apixcloud.users.utils.UsersUtil.Roles;
import com.apixcloud.users.utils.UsersUtil.Users;
import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;

/**
 * This simple setup class will run during the bootstrap process of Spring and will create some setup data <br>
 * The main focus here is creating some privileges, then roles and finally some default users
 */
@Component
public class SecuritySetup implements ApplicationListener<ContextRefreshedEvent> {
    private final Logger logger = LoggerFactory.getLogger(SecuritySetup.class);

    private boolean setupDone;

    @Autowired
    private IUserService userService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IPrivilegeService privilegeService;

    public SecuritySetup() {
        super();
    }

    // [WIP] 
    @Override
    public final void onApplicationEvent(final ContextRefreshedEvent event) {
        if (!setupDone) {
            logger.info("Setup - Load privileges, roles and users");

            createPrivileges();
            createRoles();
            createUsers();

            setupDone = true;
            logger.info("Setup - Done");
        }
    }

    // create privileges

    private void createPrivileges() {
        createPrivilegeIfNotExisting(Privileges.CAN_PRIVILEGE_READ);
        createPrivilegeIfNotExisting(Privileges.CAN_PRIVILEGE_WRITE);

        createPrivilegeIfNotExisting(Privileges.CAN_ROLE_READ);
        createPrivilegeIfNotExisting(Privileges.CAN_ROLE_WRITE);

        createPrivilegeIfNotExisting(Privileges.CAN_USER_READ);
        createPrivilegeIfNotExisting(Privileges.CAN_USER_WRITE);
    }

    final void createPrivilegeIfNotExisting(final String name) {
        final Privilege entityByName = privilegeService.findByName(name);
        if (entityByName == null) {
            final Privilege entity = new Privilege(name, Privileges.DESCRIPTION);
            privilegeService.create(entity);
        }
    }

    // create roles

    private void createRoles() {
        final Privilege canPrivilegeRead = privilegeService.findByName(Privileges.CAN_PRIVILEGE_READ);
        final Privilege canPrivilegeWrite = privilegeService.findByName(Privileges.CAN_PRIVILEGE_WRITE);
        final Privilege canRoleRead = privilegeService.findByName(Privileges.CAN_ROLE_READ);
        final Privilege canRoleWrite = privilegeService.findByName(Privileges.CAN_ROLE_WRITE);
        final Privilege canUserRead = privilegeService.findByName(Privileges.CAN_USER_READ);
        final Privilege canUserWrite = privilegeService.findByName(Privileges.CAN_USER_WRITE);

        Preconditions.checkNotNull(canPrivilegeRead);
        Preconditions.checkNotNull(canPrivilegeWrite);
        Preconditions.checkNotNull(canRoleRead);
        Preconditions.checkNotNull(canRoleWrite);
        Preconditions.checkNotNull(canUserRead);
        Preconditions.checkNotNull(canUserWrite);

        createRoleIfNotExisting(Roles.ROLE_ADMIN, Sets.<Privilege> newHashSet(canUserRead, canUserWrite, canRoleRead, canRoleWrite, canPrivilegeRead, canPrivilegeWrite));
        createRoleIfNotExisting(Roles.ROLE_VIEWER, Sets.<Privilege> newHashSet(canUserRead, canRoleRead, canPrivilegeRead));
        createRoleIfNotExisting(Roles.ROLE_EDITOR, Sets.<Privilege> newHashSet(canUserRead, canRoleRead, canPrivilegeRead, canRoleWrite, canPrivilegeWrite));
    }

    final void createRoleIfNotExisting(final String name, final Set<Privilege> privileges) {
        final Role entityByName = roleService.findByName(name);
        if (entityByName == null) {
            final Role entity = new Role(name);
            entity.setPrivileges(privileges);
            roleService.create(entity);
        }
    }

    // create users

    final void createUsers() {
        final Role roleAdmin = roleService.findByName(Roles.ROLE_ADMIN);
        final Role roleViewer = roleService.findByName(Roles.ROLE_VIEWER);
        final Role roleEditor = roleService.findByName(Roles.ROLE_EDITOR);
        
        createUserIfNotExisting(Users.ADMIN_USERNAME, Users.ADMIN_EMAIL, Users.ADMIN_NAME, Users.ADMIN_PASS, Sets.<Role> newHashSet(roleAdmin));
        createUserIfNotExisting(Users.VIEWER_USERNAME, Users.VIEWER_EMAIL, Users.VIEWER_NAME, Users.VIEWER_PASS, Sets.<Role> newHashSet(roleViewer));
        createUserIfNotExisting(Users.EDITOR_USERNAME, Users.EDITOR_EMAIL, Users.EDITOR_NAME, Users.EDITOR_PASS, Sets.<Role> newHashSet(roleEditor));
    }

    final void createUserIfNotExisting(final String username, final String email, final String name, final String pass, final Set<Role> roles) {
        final User entityByName = userService.findByName(username);
        if (entityByName == null) {
            final User entity = new User(username, email, name, pass, roles);
            userService.create(entity);
        }
    }

}
