package com.cenfotec.jareth.mena.tarea1.model;

import com.cenfotec.jareth.mena.tarea1.model.enums.RoleEnum;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collections;
import java.util.Collection;

@Data
@Table(name = "role")
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    @Enumerated(EnumType.STRING)
    private RoleEnum name;

    private String description;

    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthority() {
        return Collections.singletonList((GrantedAuthority) () -> name.name());
    }
}