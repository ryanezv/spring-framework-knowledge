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
@Table(name="\"role\"")
public class Role implements INameableEntity, INameableDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ROLE_ID")
    private Long id;

    @Column(unique = true, nullable = false)
    private String name;

    // @formatter:off
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(joinColumns = { @JoinColumn(name = "ROLE_ID", referencedColumnName = "ROLE_ID") }, inverseJoinColumns = { @JoinColumn(name = "PRIVILEGE_ID", referencedColumnName = "PRIVILEGE_ID") })
    private Set<Privilege> privileges;
    // @formatter:on

    public Role(final String name) {
        super();
        this.name = name;
    }

    public Role(final String name, final Set<Privilege> privileges) {
        super();
        this.name = name;
        this.privileges = privileges;
    }

    /* TBD */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }  
}
