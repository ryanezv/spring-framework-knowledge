package com.apixcloud.courses.persistence.setup;

import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import com.apixcloud.courses.persistence.models.Privilege;
import com.apixcloud.courses.persistence.models.Role;
import com.apixcloud.courses.persistence.models.User;
import com.apixcloud.courses.services.IPrivilegeService;
import com.apixcloud.courses.services.IRoleService;
import com.apixcloud.courses.services.IUserService;
import com.apixcloud.courses.utils.UsersUtil.Privileges;
import com.apixcloud.courses.utils.UsersUtil.Roles;
import com.apixcloud.courses.utils.UsersUtil.Users;
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
        createRoleIfNotExisting(Roles.ROLE_MEMBER, Sets.<Privilege> newHashSet(canUserRead, canRoleRead, canPrivilegeRead));
        //createRoleIfNotExisting(Roles.ROLE_EDITOR, Sets.<Privilege> newHashSet(canUserRead, canRoleRead, canPrivilegeRead, canRoleWrite, canPrivilegeWrite));
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
        final Role roleMember = roleService.findByName(Roles.ROLE_MEMBER);        
        
        createUserIfNotExisting(Users.ADMIN_USERNAME, Users.ADMIN_EMAIL, Users.ADMIN_NAME, Users.ADMIN_PASS, Sets.<Role> newHashSet(roleAdmin));
        createUserIfNotExisting(Users.MEMBER_USERNAME, Users.MEMBER_EMAIL, Users.MEMBER_NAME, Users.MEMBER_PASS, Sets.<Role> newHashSet(roleMember));

        createUserIfNotExisting("a-member01", "member01@dummy.com.mx", "Member 01", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("b-member02", "member02@dummy.com.mx", "Member 02", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("c-member03", "member03@dummy.com.mx", "Member 03", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("d-member04", "member04@dummy.com.mx", "Member 04", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("e-member05", "member05@dummy.com.mx", "Member 05", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("f-member06", "member06@dummy.com.mx", "Member 06", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("g-member07", "member07@dummy.com.mx", "Member 07", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("member08", "member08@dummy.com.mx", "Member 08", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("member09", "member09@dummy.com.mx", "Member 09", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("member10", "member10@dummy.com.mx", "Member 10", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("member11", "member11@dummy.com.mx", "Member 11", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("member12", "member12@dummy.com.mx", "Member 12", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("member13", "member13@dummy.com.mx", "Member 13", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("x-member14", "member14@dummy.com.mx", "Member 14", "member123", Sets.<Role> newHashSet(roleMember));
        createUserIfNotExisting("z-member15", "member15@dummy.com.mx", "Member 15", "member123", Sets.<Role> newHashSet(roleMember));
    }

    final void createUserIfNotExisting(final String username, final String email, final String name, final String pass, final Set<Role> roles) {
        final User entityByName = userService.findByName(username);
        if (entityByName == null) {
            final User entity = new User(username, email, name, pass, roles);
            userService.create(entity);
        }
    }

}
