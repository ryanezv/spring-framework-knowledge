package com.apixcloud.umusers.persistence.models;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.hateoas.RepresentationModel;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "USERS")
@ToString
@EntityListeners(AuditingEntityListener.class)
public class User extends RepresentationModel<User>{

    @Id 
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String username;

    @Column(nullable = false)
    private String email;

    private String firstname;
    private String lastname;
    private Boolean enabled;

    // gets the String from our AuditorAware (config)
    @CreatedDate
    private LocalDateTime createdDateTime;
    @LastModifiedDate
    private LocalDateTime lastModifiedDateTime;

    // gets the String from our AuditorAware (config) with Spring Security Context
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String lastModifyBy;

    
    public User(String username, String email){
        this.username = username;
        this.email = email;
    }
}
