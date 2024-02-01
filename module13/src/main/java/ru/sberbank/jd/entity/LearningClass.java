package ru.sberbank.jd.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Setter;

import java.util.List;

/**
 * Entity учебного класса.
 */
@Entity
@Setter
public class LearningClass {
    /**
     * Наименование класса.
     */
    @Id
    private String classNumber;
    /**
     * Кол-во студентов в классе.
     */
    private int studentsCount;
    /**
     * Cписок студентов в классе
     */
    @OneToMany(mappedBy = "learningClass")
    private List<Student> students;

    /**
     * Возвращает наименование класса.
     *
     * @return String
     */
    public String getClassNumber() {
        return classNumber;
    }

    /**
     * Устанавливает новое наименование класса.
     *
     * @param classNumber новое название.
     */
    public void setClassNumber(String classNumber) {
        this.classNumber = classNumber;
    }

    /**
     * Возвращает кол-во студентов.
     *
     * @return int.
     */
    public int getStudentsCount() {
        return studentsCount;
    }

    /**
     * Новое кол-во студентов в классе.
     *
     * @param studentsCount int кол-во учеников.
     */
    public void setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
    }

    /**
     * Возвращает список учеников.
     *
     * @return список всех учеников в классе.
     */
    public List<Student> getStudents() {
        return students;
    }

    /**
     * Добавляет список учеников.
     *
     * @param students список новых учеников в классе.
     */
    public void setStudents(List<Student> students) {
        this.students = students;
    }

    /**
     * Представление класса в текстовом виде.
     *
     * @return String
     */
    @Override
    public String toString() {
        return "Класс " + classNumber + ", кол-во учеников: " + studentsCount;
    }
}
