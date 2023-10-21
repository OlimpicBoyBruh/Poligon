package ru.sberbank.jd.lesson01;

import java.util.Collection;

/**
 * Class.
 */
public class Main {
    /**
     * Возвращает скомпонованная, полученную из методов класса.
     */
    public static void main(String[] args) {

        System.out.println(getInfo());
        getInfo();
    }

    /**
     * Возвращает скомпонованная, полученную из методов класса.
     */
    public static String getInfo() {
        PersonalCard personalCard = new PersonalCard();
        return "Имя: " + personalCard.getFirstName() + " \nФамилия: " + personalCard.getLastName() + "\nГод рождения: "
                + personalCard.getBirthYear() + "\nХобби: " + personalCard.getHobbies() + "\nИмя репозитория: "
                + personalCard.getBitbucketUrl() + "\nНомер телефона: " + personalCard.getPhone() + "\nОжидания: "
                + personalCard.getCourseExpectations();
    }
}
