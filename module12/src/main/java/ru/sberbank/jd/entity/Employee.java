package ru.sberbank.jd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

/**
 * Класс описывает сущность в БД.
 */
@Getter
@Setter
@Entity
public class Employee {
    /**
     * Личный номер сотрудника.
     */
    @Id
    private String personalId;
    /**
     * Имя сотрудника.
     */
    private String firstName;
    /**
     * Фамилия сотрудника.
     */
    private String lastName;
    /**
     * Отдел, к которому прикреплен сотрудник.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Department department;
    /**
     * Проект, в котором принимает участие сотрудник.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Project project;

}