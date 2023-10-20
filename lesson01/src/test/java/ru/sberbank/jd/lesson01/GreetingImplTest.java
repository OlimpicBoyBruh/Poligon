package ru.sberbank.jd.lesson01;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GreetingImplTest {
    @Test
    public void getFirstNameTest() {
        GreetingImpl greetingImpl = new GreetingImpl();
        Assert.assertEquals("Артём", greetingImpl.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        GreetingImpl greetingImpl = new GreetingImpl();
        Assert.assertEquals("Мещеряков", greetingImpl.getLastName());
    }

    @Test
    public void getBirthYearTest() {
        GreetingImpl greetingImpl = new GreetingImpl();
        Assert.assertEquals(2000, greetingImpl.getBirthYear());

    }

    @Test
    public void getHobbies() {
        GreetingImpl greetingImpl = new GreetingImpl();
        ArrayList<String> list = (ArrayList<String>) greetingImpl.getHobbies();
        Assert.assertEquals("компьютерные игры", list.get(0));
        Assert.assertEquals("просмотр сериалов", list.get(1));
    }

    @Test
    public void getBitbucketUrlTest() {
        GreetingImpl greetingImpl = new GreetingImpl();
        Assert.assertEquals("Poligon", greetingImpl.getBitbucketUrl());

    }

    @Test
    public void getPhoneTest() {
        GreetingImpl greetingImpl = new GreetingImpl();
        Assert.assertEquals("+7-919-186-63-10", greetingImpl.getPhone());

    }

    @Test
    public void getCourseExpectationsTest() {
        GreetingImpl greetingImpl = new GreetingImpl();
        ArrayList<String> list = (ArrayList<String>) greetingImpl.getCourseExpectations();
        Assert.assertEquals("получения достаточной компетенции для работы", list.get(0));
        Assert.assertEquals("возможность в дальнейшем стать junior-разработчиком в СберБанке", list.get(1));
        Assert.assertEquals("расширение кругозора", list.get(2));
    }
}
