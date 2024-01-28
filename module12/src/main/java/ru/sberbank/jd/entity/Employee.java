package ru.sberbank.jd.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@Entity
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String personalId;
    private String firstName;
    private String lastName;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;
    private String project;
}
