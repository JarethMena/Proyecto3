package com.cenfotec.jareth.mena.tarea1.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "category")
@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private long id;
    @Column(nullable = false, unique = true)
    private String name;
    private String description;
}
