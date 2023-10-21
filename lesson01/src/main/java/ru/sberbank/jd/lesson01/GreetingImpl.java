package ru.sberbank.jd.lesson01;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Получение инфомарции о студенте.
 */
public class GreetingImpl {
    private ArrayList<String> hobbies;

    /**
     * Получение имени.
     */
    public String getFirstName() {
        return "Артём";
    }

    /**
     * Получение фамилии.
     */
    public String getLastName() {
        return "Мещеряков";
    }

    /**
     * Получение года рождения.
     */
    public int getBirthYear() {
        return 2000;
    }

    /**
     * Получение набора хобби.
     */
    public Collection<String> getHobbies() {
        hobbies = new ArrayList<>();
        hobbies.add("компьютерные игры");
        hobbies.add("просмотр сериалов");
        return hobbies;
    }

    /**
     * Получение имени репозитория gutHub.
     */
    public String getBitbucketUrl() {
        return "Poligon";
    }

    /**
     * Получение телефона.
     */
    public String getPhone() {
        return "+7-919-186-63-10";
    }

    /**
     * Получение набора ожиданий от курса.
     */
    public Collection<String> getCourseExpectations() {
        Collection<String> getCourseExpectation = new ArrayList<>();
        getCourseExpectation.add("получения достаточной компетенции для работы");
        getCourseExpectation.add("возможность в дальнейшем стать junior-разработчиком в СберБанке");
        getCourseExpectation.add("расширение кругозора");
        return getCourseExpectation;
    }
}
