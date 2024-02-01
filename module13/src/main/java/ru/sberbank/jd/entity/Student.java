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
 * Entity ученика.
 */
@Entity
@Setter
@Getter
public class Student {
    /**
     * Id ученика, генерируется автоматически.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * Имя ученика.
     */
    private String firstName;
    /**
     * Фамилия ученика.
     */
    private String lastName;
    /**
     * Класс, в котором учиться.
     */
    @ManyToOne(fetch = FetchType.EAGER)
    private LearningClass learningClass;

    /**
     * Представление класса в текстовом виде.
     *
     * @return String
     */
    @Override
    public String toString() {
        return
                "Имя: " + firstName +
                        ", Фамилия: " + lastName;
    }
}
