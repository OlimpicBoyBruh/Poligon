package ru.sberbank.jd.lesson01;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class GreetingImplTest {
    @Test
    public void getFirstNameTest() {
        GreetingImpl GreetingImpl = new GreetingImpl();
        Assert.assertEquals("Артём", GreetingImpl.getFirstName());
    }

    @Test
    public void getLastNameTest() {
        GreetingImpl GreetingImpl = new GreetingImpl();
        Assert.assertEquals("Мещеряков", GreetingImpl.getLastName());
    }

    @Test
    public void getBirthYearTest() {
        GreetingImpl GreetingImpl = new GreetingImpl();
        Assert.assertEquals(2000, GreetingImpl.getBirthYear());

    }

    @Test
    public void getHobbies() {
        GreetingImpl GreetingImpl = new GreetingImpl();
        ArrayList<String> list = (ArrayList<String>) GreetingImpl.getHobbies();
        Assert.assertEquals("компьютерные игры", list.get(0));
        Assert.assertEquals("просмотр сериалов", list.get(1));
    }

    @Test
    public void getBitbucketUrlTest() {
        GreetingImpl GreetingImpl = new GreetingImpl();
        Assert.assertEquals("Poligon", GreetingImpl.getBitbucketUrl());

    }

    @Test
    public void getPhoneTest() {
        GreetingImpl GreetingImpl = new GreetingImpl();
        Assert.assertEquals("+7-919-186-63-10", GreetingImpl.getPhone());

    }

    @Test
    public void getCourseExpectationsTest() {
        GreetingImpl GreetingImpl = new GreetingImpl();
        ArrayList<String> list = (ArrayList<String>) GreetingImpl.getCourseExpectations();
        Assert.assertEquals("получения достаточной компетенции для работы", list.get(0));
        Assert.assertEquals("возможность в дальнейшем стать junior-разработчиком в СберБанке", list.get(1));
        Assert.assertEquals("расширение кругозора", list.get(2));
    }
}
