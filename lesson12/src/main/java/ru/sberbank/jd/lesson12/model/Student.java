package ru.sberbank.jd.lesson12.model;


import java.util.Date;
import java.util.UUID;

/**
 * Класс, отражающий структуру хранимых в таблице полей.
 */
public class Student {
    /**
     * Первичный ключ.
     * Рекомендуется генерировать его только внутри StudentsRepositoryCRUD.create(),
     * иными словами до момента пока объект не будет сохранен в БД, он не должен
     * иметь значение id.
     */
    private UUID id;
    /**
     * Имя студента.
     */
    private String firstName;
    /**
     * Фамилия студента.
     */
    private String lastName;
    /**
     * Дата рождения студента.
     */
    private final Date birthDate;
    /**
     * Закончил ли студент обучение.
     */
    private boolean isGraduated;

    /**
     * Конструктор для создания объекта без id.
     *
     * @param id          идентификатор
     * @param firstName   имя
     * @param lastName    фамилия
     * @param birthDate   дата рождения
     * @param isGraduated учиться/не учиться
     */
    public Student(UUID id, String firstName, String lastName, Date birthDate, boolean isGraduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isGraduated = isGraduated;
        this.id = id;
    }

    /**
     * Конструктор для создания объекта без id.
     *
     * @param firstName   имя
     * @param lastName    фамилия
     * @param birthDate   дата рождения
     * @param isGraduated учиться/не учиться
     */
    public Student(String firstName, String lastName, Date birthDate, boolean isGraduated) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
        this.isGraduated = isGraduated;
    }

    /**
     * Get-метод для идентификатора.
     *
     * @return уникальный id.
     */
    public UUID getId() {
        return id;
    }

    /**
     * Set-метод для установки идентификатора.
     *
     * @param id новый идентификатор.
     */
    public void setId(UUID id) {
        this.id = id;
    }

    /**
     * Get-метод для имени.
     *
     * @return имя.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Get-метод для фамилии.
     *
     * @return фамилия.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Get-метод для даты рождения.
     *
     * @return ДР.
     */
    public Date getBirthDate() {
        return birthDate;
    }

    /**
     * Get-метод возвращает учиться ли еще студент.
     *
     * @return isGraduated.
     */
    public boolean isGraduated() {
        return isGraduated;
    }

    /**
     * Set-метод меняет - учиться ли еще студент.
     *
     * @param graduated новое значение.
     */
    public void setGraduated(boolean graduated) {
        isGraduated = graduated;
    }

    /**
     * Возвращает текстовое описание объекта.
     *
     * @return строку String.
     */
    @Override
    public String toString() {
        return "Student{"
                + "id=" + id
                + ", firstName='" + firstName + '\''
                + ", lastName='" + lastName + '\''
                + ", birthDate=" + birthDate
                + ", isGraduated=" + isGraduated
                + '}';
    }
}
