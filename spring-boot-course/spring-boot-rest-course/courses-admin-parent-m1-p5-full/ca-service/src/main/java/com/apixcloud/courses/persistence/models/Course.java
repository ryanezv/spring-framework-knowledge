package com.apixcloud.courses.persistence.models;

import java.time.LocalDateTime;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "courses")
@EntityListeners(AuditingEntityListener.class)
public class Course {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "COURSE_ID")
    private Integer id;

    @Column(nullable = false)
    private String name;
        
    private String description;

    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDateTime;
    
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDateTime;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
        name = "COURSE_USER",
        joinColumns = @JoinColumn(name = "COURSE_ID"),
        inverseJoinColumns = @JoinColumn(name = "USER_ID")
    )
    private Set<User> users;

}
