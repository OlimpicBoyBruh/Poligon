package ru.sberbank.jd.lesson01;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Получение инфомарции о студенте.
 */
public class GreetingImpl {
    public static void main(String[] args) {
        GreetingImpl greeting = new GreetingImpl();
        System.out.println(greeting.toString());
    }

    /**
     * Получение имени.
     *
     * @return "Артём".
     */
    public String getFirstName() {
        return "Артём";
    }

    /**
     * Получение фамилии.
     *
     * @return "Мещеряков".
     */
    public String getLastName() {
        return "Мещеряков";
    }

    /**
     * Получение года рождения.
     *
     * @return 2000.
     */
    public int getBirthYear() {
        return 2000;
    }

    /**
     * Получение набора хобби.
     *
     * @return hobbies.
     */
    public Collection<String> getHobbies() {
        ArrayList<String> hobbies;
        hobbies = new ArrayList<>();
        hobbies.add("компьютерные игры");
        hobbies.add("просмотр сериалов");
        return hobbies;
    }

    /**
     * Получение имени репозитория gutHub.
     *
     * @return "Poligon".
     */
    public String getBitbucketUrl() {
        return "Poligon";
    }

    /**
     * Получение телефона.
     *
     * @return "+7-919-186-63-10".
     */
    public String getPhone() {
        return "+7-919-186-63-10";
    }

    /**
     * Получение набора ожиданий от курса.
     *
     * @return getCourseExpectation.
     */
    public Collection<String> getCourseExpectations() {
        Collection<String> getCourseExpectation = new ArrayList<>();
        getCourseExpectation.add("получения достаточной компетенции для работы");
        getCourseExpectation.add("возможность в дальнейшем стать junior-разработчиком в СберБанке");
        getCourseExpectation.add("расширение кругозора");
        return getCourseExpectation;
    }

    /**
     * Переопределение метода toString.
     */

    @Override
    public String toString() {
        GreetingImpl greetingImpl = new GreetingImpl();
        return "Имя: " + greetingImpl.getFirstName() + " \nФамилия: " + greetingImpl.getLastName() + "\nГод рождения: "
                + greetingImpl.getBirthYear() + "\nХобби: " + greetingImpl.getHobbies() + "\nИмя репозитория: "
                + greetingImpl.getBitbucketUrl() + "\nНомер телефона: " + greetingImpl.getPhone() + "\nОжидания: "
                + greetingImpl.getCourseExpectations();
    }
}
