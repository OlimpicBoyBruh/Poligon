package ru.sberbank.jd.lesson01;

import org.junit.Assert;
import org.junit.Test;
import ru.sberbank.jd.lesson01.GreetingImpl;

import java.util.ArrayList;

public class GreetingImplTest {

    GreetingImpl greetingImpl = new GreetingImpl();

    @Test
    public void getFirstNameTest() {
        Assert.assertEquals("Артём", greetingImpl.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        Assert.assertEquals("Мещеряков", greetingImpl.getLastName());
    }

    @Test
    public void getBirthYearTest() {
        Assert.assertEquals(2000, greetingImpl.getBirthYear());
    }

    @Test
    public void getHobbies() {
        ArrayList<String> list = (ArrayList<String>) greetingImpl.getHobbies();
        Assert.assertEquals("компьютерные игры", list.get(0));
        Assert.assertEquals("просмотр сериалов", list.get(1));
    }

    @Test
    public void getBitbucketUrlTest() {
        Assert.assertEquals("Poligon", greetingImpl.getBitbucketUrl());
    }

    @Test
    public void getPhoneTest() {
        Assert.assertEquals("+7-919-186-63-10", greetingImpl.getPhone());
    }

    @Test
    public void getCourseExpectationsTest() {
        ArrayList<String> list = (ArrayList<String>) greetingImpl.getCourseExpectations();
        Assert.assertEquals("получения достаточной компетенции для работы", list.get(0));
        Assert.assertEquals("возможность в дальнейшем стать junior-разработчиком в СберБанке", list.get(1));
        Assert.assertEquals("расширение кругозора", list.get(2));
    }
}
