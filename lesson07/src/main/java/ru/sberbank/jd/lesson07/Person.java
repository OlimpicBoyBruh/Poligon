package ru.sberbank.jd.lesson07;

import java.util.Objects;

/**
 * Класс для хранения данных о человеке.
 */
public class Person implements Comparable<Person> {
    private String name;
    private String city;
    private int age;

    /**
     * Конструктор установки значения полям объекта.
     *
     * @param name - Имя.
     * @param city - Город.
     * @param age  - Возраст.
     * @throws IllegalArgumentException - если name, city равны null или age <0.
     */

    public Person(String name, String city, int age) {
        if (name == null || city == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.name = name;
        this.city = city;
        this.age = age;
    }

    /**
     * Возвращает имя.
     *
     * @return name.
     */

    public String getName() {
        return name;
    }

    /**
     * Присваивает новое имя.
     *
     * @param name - новое значение.
     */

    public void setName(String name) {
        if (name == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        this.name = name;
    }

    /**
     * Возвращает название города.
     *
     * @return city.
     */

    public String getCity() {
        return city;
    }

    /**
     * Присваивает новое имя.
     *
     * @param city - новое значение.
     */

    public void setCity(String city) {
        if (city == null) {
            throw new IllegalArgumentException("Arguments cannot be null.");
        }
        this.city = city;
    }

    /**
     * Возвращает значение имени.
     *
     * @return age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Присваивает возраст.
     *
     * @param age - новое значение.
     */
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative.");
        }
        this.age = age;
    }

    /**
     * Метод возвращает положительное число, отрицательное число или 0.
     *
     * @return int - результат сравнения.
     */
    @Override
    public int compareTo(Person obj) {
        int resultCity = city.compareTo(obj.city);
        if (resultCity != 0) {
            return resultCity;
        }
        return name.compareTo(obj.name);
    }

    /**
     * Метод для сравнения объектов на равенство.
     *
     * @param obj - объект сравнения.
     * @return boolean - результат сравнения.
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!this.getClass().equals(obj.getClass())) {
            return false;
        }
        Person other = (Person) obj;
        return name.equalsIgnoreCase(other.name) && city.equalsIgnoreCase(other.city) && age == other.age;
    }

    /**
     * Метод для сравнения hashcode объектов.
     * Используется метод hash класса Objects.
     *
     * @return int - hashcode.
     */
    @Override
    public int hashCode() {
        return Objects.hash(name.toLowerCase(), city.toLowerCase(), age);
    }

    @Override
    public String toString() {
        return "(city: " + city + ","
                + "name: " + name + ","
                + "age: " + age + ")\n";
    }

}
