package ru.sberbank.jd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Project {
    /**
     * Id проекта, генерируется автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String projectId;
    /**
     * Название проекта.
     */
    private String projectName;
    /**
     * Сотрудник, который работает над проектом, можно сделать List.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private Employee employee;
    /**
     * Роль сотрудника в проекте.
     */
    private String role;

}