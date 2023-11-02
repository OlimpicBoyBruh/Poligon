package ru.sberbank.jd.lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgumentsTest {
    private Arguments arguments;

    @Before
    public void init() {
        arguments = new Arguments();
    }

    @Test
    public void falseResultTest() {
        Assert.assertFalse(arguments.isCountLines());
        Assert.assertFalse(arguments.isCountWords());
        Assert.assertFalse(arguments.isVersion());
        Assert.assertFalse(arguments.isHelp());
    }

    @Test
    public void trueResultTest() {
        arguments.version();
        arguments.help();
        arguments.word();
        arguments.line();

        Assert.assertTrue(arguments.isCountLines());
        Assert.assertTrue(arguments.isCountWords());
        Assert.assertTrue(arguments.isVersion());
        Assert.assertTrue(arguments.isHelp());
    }

    @Test
    public void addFileNameTest() {
        arguments.setFilePatch("test.txt");
        Assert.assertEquals("test.txt", Arguments.getFilePatch().get(0));

    }


}
