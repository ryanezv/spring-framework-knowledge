package com.apixcloud.users.persistence.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import com.apixcloud.commons.interfaces.INameableDto;
import com.apixcloud.commons.persistence.model.INameableEntity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="\"user\"")
public class User implements INameableEntity, INameableDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(unique = true, nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column()
    private Boolean locked = false;

    // @formatter:off
    @ManyToMany( /* cascade = { CascadeType.REMOVE }, */fetch = FetchType.EAGER)
    @JoinTable(joinColumns = { @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID") }, inverseJoinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") })
    private Set<Role> roles;

    /* constructor custom without "id" parameter */
    public User(String username, final String email, final String name, final String password, final Set<Role> roles) {
        super();
        this.name = name;
        this.username = username;
        this.email = email;
        this.password = password;
        this.roles = roles;
        this.locked = false;
    }
}
