package com.example.oauthlegacysecurity.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Collection;

@Entity
@Data
@Table(name = "users", uniqueConstraints = {@UniqueConstraint(columnNames = {"email"})})
public class User {
    @Id
    @GeneratedValue
    private Long id;
    @NotEmpty
    @Email
    @Size(min = 4, max = 50)
    private String email;
    @JsonIgnore
    @ToString.Exclude
    private String password;

    @NotEmpty
    @Size(min = 4, max = 20)
    private String username;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = { @JoinColumn(name = "role_id")})
    private Collection<Role> role;
//    private Double minGleePerDay;
}
