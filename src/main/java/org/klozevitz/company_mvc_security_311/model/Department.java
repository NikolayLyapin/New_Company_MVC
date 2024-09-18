package org.klozevitz.company_mvc_security_311.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Getter
@Setter
@Builder
@Entity
@Table(name = "departments_t")
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name = "note")
    private String note;
    @ManyToOne
    @JoinColumn(name = "parent_id")
//    @JsonIgnore  // сообщает в рантайме, что сериализовать это поле не нужно
    private Department parentDpt;
    @OneToMany
    private Set<Department> subDepartments;
    @OneToMany
    private Set<Employee> employees;
}
