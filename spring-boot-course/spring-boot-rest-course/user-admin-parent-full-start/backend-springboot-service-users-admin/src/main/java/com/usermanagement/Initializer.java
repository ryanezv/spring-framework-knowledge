package com.usermanagement;

import com.usermanagement.model.Privilege;
import com.usermanagement.model.Role;
import com.usermanagement.model.User;
import com.usermanagement.model.enums.Privileges;
import com.usermanagement.model.enums.Roles;
import com.usermanagement.repository.PrivilegeRepository;
import com.usermanagement.repository.RoleRepository;
import com.usermanagement.model.requests.CreateTeamRequest;
import com.usermanagement.model.requests.CreateUserRequest;
import com.usermanagement.service.TeamService;
import com.usermanagement.service.UserService;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Component
public class Initializer implements CommandLineRunner {

    private final UserService userService;
    private final TeamService teamService;

    private final PrivilegeRepository privilegeRepository;
    private final RoleRepository roleRepository;

    @Override
    public void run(String... args) throws Exception {

        // Init User
        User richard = createUser("ryanezv", "Ricardo", "Yanez", "admin123", "yanezv.ricardo@gmail.com");
        User jovani = createUser("jovaniarz", "Jovani", "Arzate", "admin123", "jovani@apixcloud.com");

        // Create Roles and Privileges
        Privilege teamMemberPrivilege = createPrivilege(Privileges.MEMBER);
        Privilege teamAdminPrivilege = createPrivilege(Privileges.ADMIN);

        List<Privilege> adminPrivileges = Arrays.asList(teamMemberPrivilege, teamAdminPrivilege);

        // Admin has the Admin and the Member Privilege
        Role adminRole = createRole(Roles.ADMIN, adminPrivileges);

        // Member only has the MemberPrivilege
        Role memberRole = createRole(Roles.MEMBER, List.of(teamMemberPrivilege));

        // Init Team
        CreateTeamRequest courseApiRestSpringBoot = CreateTeamRequest.builder()
                .name("Desarrollo de APIs REST con Spring Boot")
                .build();

        teamService.create(courseApiRestSpringBoot, richard);

        CreateTeamRequest courseApigeeX = CreateTeamRequest.builder()
                .name("Arquitecto de APIs con Apigee X")
                .build();

        teamService.create(courseApigeeX, jovani);

        // Create more teams
        teamService.create(CreateTeamRequest.builder().name("Cloud Architect AWS").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Desarrollo de Microservicios y AWS").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Cloud Architect en AWS").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Arquitectura de Microservicios y GCP").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Cloud Engineer en GCP").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Cloud Architect en GCP").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Desarrollo de aplicaciones con Kafka").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Desarrollo de APls REST con Apigee X").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("POO con Java + Plus Inteligencia").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Desarollo Web con REACTJS Y TYPESCRIPT").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("Cloud Architect en AWS for Girls").build(), jovani);
        teamService.create(CreateTeamRequest.builder().name("AWS Lambda / Apps serverless").build(), jovani);

    }

    private User createUser(String username, String firstname, String lastname, String password, String email) {
        CreateUserRequest createUserRequest = CreateUserRequest.builder()
                .username(username)
                .firstname(firstname)
                .lastname(lastname)
                .password(password)
                .email(email)
                .build();
        return this.userService.create(createUserRequest);
    }

    private @NotNull Privilege createPrivilege(Privileges privilege) {
        Privilege p = new Privilege();
        p.setPrivilege(privilege);
        return privilegeRepository.save(p);
    }

    private Role createRole(Roles role, List<Privilege> privilegesList) {
        Role r = new Role();
        r.setRole(role);
        r.setPrivileges(privilegesList);
        return roleRepository.save(r);
    }
}