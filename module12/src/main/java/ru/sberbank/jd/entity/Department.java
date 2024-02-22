package ru.sberbank.jd.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * Класс описывает сущность в БД.
 */
@Entity
@Getter
@Setter
public class Department {
    /**
     * Id отдела, не генерирует автоматически, необходимо задать самому.
     */
    @Id
    private String id;
    /**
     * Название отдела.
     */
    private String departmentName;
    /**
     * Директор отдела.
     */
    @OneToOne(fetch = FetchType.EAGER)
    private Employee director;
    /**
     * Список сотрудников, относящихся к этому отделу.
     */
    @OneToMany(mappedBy = "department")
    private List<Employee> employees;

}