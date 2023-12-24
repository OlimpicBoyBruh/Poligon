package ru.sberbank.jd.lesson06;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CustomArrayImplTest {
    CustomArray<String> list;

    @Before
    public void init() {
        list = new CustomArrayImpl<>();
    }

    @Test
    public void constructorTest() {
        Assert.assertEquals(10, list.getCapacity());
        list = new CustomArrayImpl<>(25);
        Assert.assertEquals(25, list.getCapacity());
        List<String> list1 = new ArrayList<>();
        list1.add("Test");
        list = new CustomArrayImpl<>(list1);
        Assert.assertEquals("Test", list.get(0));

    }

    @Test
    public void sizeTest() {
        Assert.assertEquals(0, list.size());
        list.add("Artem");
        Assert.assertEquals(1, list.size());

        List<String> list1 = new ArrayList<>();
        list1.add("Test");
        list1.add("Hello");
        list1.add("World");

        list = new CustomArrayImpl<>(list1);
        Assert.assertEquals(3, list.size());
        list.addAll(list1);
        Assert.assertEquals(6, list.size());

        String[] str = {"I", "love", "sberbank"};
        list.addAll(str);

        Assert.assertEquals(9, list.size());
        list.addAll(9, str);
        Assert.assertEquals(12, list.size());
        list.remove(5);
        Assert.assertEquals(11, list.size());
        list.remove("Test");
        Assert.assertEquals(10, list.size());
    }

    @Test
    public void isEmptyTest() {
        Assert.assertTrue(list.isEmpty());
        list.add("Test");
        Assert.assertFalse(list.isEmpty());
    }

    @Test
    public void addAndGetTest() {
        list.add("Test");
        list.add("Sberbank");
        Assert.assertEquals("Test", list.get(0));
        Assert.assertEquals("Sberbank", list.get(1));
    }

    @Test
    public void addAllTest() {
        String[] str = {"I", "love", "sberbank"};
        list.addAll(str);
        Assert.assertEquals("I", list.get(0));
        Assert.assertEquals("love", list.get(1));
        Assert.assertEquals("sberbank", list.get(2));

        List<String> test = new ArrayList<>();
        test.add("Test");
        test.add("Hello");
        test.add("World");

        list.addAll(test);
        Assert.assertEquals("Test", list.get(3));
        Assert.assertEquals("Hello", list.get(4));
        Assert.assertEquals("World", list.get(5));

        list.addAll(5, str);
        Assert.assertEquals("I", list.get(5));
        Assert.assertEquals("love", list.get(6));
        Assert.assertEquals("sberbank", list.get(7));
    }

    @Test
    public void setTest() {
        list.add("Test");
        list.add("Hello");
        list.add("World");
        Assert.assertEquals("Hello", list.set(1, "Sberbank"));
    }

    @Test
    public void removeTest() {
        list.add("Test");
        list.add("Hello");
        list.add("World");
        Assert.assertTrue(list.contains("Test"));
        list.remove("Test");
        Assert.assertFalse(list.contains("Test"));
        Assert.assertTrue(list.contains("Hello"));
        list.remove(0);
        Assert.assertFalse(list.contains("Hello"));
    }

    @Test
    public void containsTest() {
        list.add("Test");
        list.add("Hello");
        list.add("World");
        Assert.assertTrue(list.contains("Test"));
        Assert.assertFalse(list.contains("test"));
        Assert.assertTrue(list.contains("Hello"));

    }

    @Test
    public void indexOfTest() {
        list.add("Test");
        list.add("Hello");
        list.add("World");
        Assert.assertEquals(0, list.indexOf("Test"));
        Assert.assertEquals(1, list.indexOf("Hello"));
        Assert.assertEquals(2, list.indexOf("World"));
        Assert.assertEquals(-1, list.indexOf("world"));
    }

    @Test
    public void ensureCapacityTest() {
        list = new CustomArrayImpl<>(2);
        list.add("Test");
        list.add("Hello");
        list.add("World");
        Assert.assertEquals(4, list.getCapacity());
        list.add("Test1");
        list.add("Hello1");
        list.add("World1");
        Assert.assertEquals(8, list.getCapacity());
    }

    @Test
    public void getCapacityTest() {
        Assert.assertEquals(10, list.getCapacity());
        list = new CustomArrayImpl<>(100);
        Assert.assertEquals(100, list.getCapacity());
        list.ensureCapacity(list.getCapacity() * 2);
        Assert.assertEquals(200, list.getCapacity());
    }

    @Test
    public void reverseTest() {
        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");
        list.add("F");
        list.reverse();
        Assert.assertEquals("A", list.get(4));
        Assert.assertEquals("B", list.get(3));
        Assert.assertEquals("C", list.get(2));
        Assert.assertEquals("D", list.get(1));
        Assert.assertEquals("F", list.get(0));
    }

    @Test
    public void toArrayTest() {
        list.add("Test");
        list.add("Hello");
        list.add("World");
        Object[] str = list.toArray();
        Assert.assertEquals("Test", str[0]);
        Assert.assertEquals("Hello", str[1]);
        Assert.assertEquals("World", str[2]);
    }
}

