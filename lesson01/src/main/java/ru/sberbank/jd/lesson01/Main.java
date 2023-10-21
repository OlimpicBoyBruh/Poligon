package ru.sberbank.jd.lesson01;


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
        GreetingImpl greetingImpl = new GreetingImpl();
        return "Имя: " + greetingImpl.getFirstName() + " \nФамилия: " + greetingImpl.getLastName() + "\nГод рождения: "
                + greetingImpl.getBirthYear() + "\nХобби: " + greetingImpl.getHobbies() + "\nИмя репозитория: "
                + greetingImpl.getBitbucketUrl() + "\nНомер телефона: " + greetingImpl.getPhone() + "\nОжидания: "
                + greetingImpl.getCourseExpectations();
    }
}
