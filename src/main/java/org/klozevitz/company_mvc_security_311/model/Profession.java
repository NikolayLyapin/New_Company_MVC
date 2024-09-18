package org.klozevitz.company_mvc_security_311.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Table(name = "professions_t")
@AllArgsConstructor
@NoArgsConstructor
public class Profession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "note")
    private String note;
    @OneToMany
    private Set<Employee> employees;

    public Profession(String name, String note) {
        this.name = name;
        this.note = note;
        this.employees = new HashSet<>();
    }
}
