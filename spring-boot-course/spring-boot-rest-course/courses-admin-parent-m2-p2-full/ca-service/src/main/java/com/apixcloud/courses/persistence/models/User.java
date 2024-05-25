package com.apixcloud.courses.persistence.models;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PastOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.apixcloud.commons.interfaces.INameableDto;
import com.apixcloud.commons.persistence.model.INameableEntity;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="\"users\"")
@EntityListeners(AuditingEntityListener.class)
public class User implements INameableEntity, INameableDto {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;
    
    @NotNull(message = "El atributo {name} no puede ser nulo")
    private String name;

    @Column(unique = true, nullable = false)
    @Size(min = 3, max = 99, message = "Debe tener entre 2 y 99 caracteres")
    private String username;

    //@Min(value = 18, message = "Debe ser mayor a 18 años")
    @Max(value = 99, message = "Debe ser menor a 100 años")
    //@PositiveOrZero(message = "La edad es invalida")
    @Positive(message = "Edad invalida")
    private int age;

    @Column(nullable = false)    
    //@Email(message = "Email debe ser un formato valido")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "{email} formato invalido")
    private String email;

    @Column
    @ElementCollection
    private Set<@Email(message = "Email con formato invalido") String> alternativesEmail;

    @Column
    @Temporal(value = TemporalType.DATE)
    @PastOrPresent(message = "Fecha de cumpleaños invalida")
    private Date dateOfBirth;

    @Column(nullable = false)
    private String password;

    @Column()
    @AssertTrue(message = "Invalid value {locked}")    
    private Boolean locked = true;

    // gets the String from our AuditorAware (config)
    @CreatedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    @Column(name = "CREATED_DATE")
    private LocalDateTime createdDateTime;
    
    @LastModifiedDate
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd@HH:mm")
    @Column(name = "LAST_MODIFIED_DATE")
    private LocalDateTime lastModifiedDateTime;

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
        this.age = 18;
        this.locked = true;
    }
}
