package ru.sberbank.jd.lesson04;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ArgumentParserTest {
    ArgumentParser parser;
    Arguments arguments;

    @Before
    public void init() {
        parser = new ArgumentParser();
        arguments = new Arguments();
    }

    @Test
    public void parseNoFilePathTest() {
        String[] str = new String[0];
        arguments = parser.parse(str);
        Assert.assertTrue(arguments.isCountLines());
        Assert.assertTrue(arguments.isCountWords());
        Assert.assertFalse(arguments.isHelp());
        Assert.assertFalse(arguments.isVersion());
    }

    @Test
    public void parseHelpTest() {
        String[] str = {"--help"};
        arguments = parser.parse(str);
        Assert.assertFalse(arguments.isCountLines());
        Assert.assertFalse(arguments.isCountWords());
        Assert.assertTrue(arguments.isHelp());
        Assert.assertFalse(arguments.isVersion());
    }

    @Test
    public void parseVersionTest() {
        String[] str = {"--version"};
        arguments = parser.parse(str);
        Assert.assertFalse(arguments.isCountLines());
        Assert.assertFalse(arguments.isCountWords());
        Assert.assertFalse(arguments.isHelp());
        Assert.assertTrue(arguments.isVersion());
    }

    @Test
    public void parseLinesAndWordsTest() {
        String[] str = {"-l", "-w"};
        arguments = parser.parse(str);
        Assert.assertTrue(arguments.isCountLines());
        Assert.assertTrue(arguments.isCountWords());
        Assert.assertFalse(arguments.isHelp());
        Assert.assertFalse(arguments.isVersion());
    }

    @Test
    public void parseLWTest() {
        String[] str = {"-lw"};
        arguments = parser.parse(str);
        Assert.assertTrue(arguments.isCountLines());
        Assert.assertTrue(arguments.isCountWords());
        Assert.assertFalse(arguments.isHelp());
        Assert.assertFalse(arguments.isVersion());

    }

    @Test
    public void parseWLTest() {
        String[] str = {"-wl"};
        arguments = parser.parse(str);
        Assert.assertTrue(arguments.isCountLines());
        Assert.assertTrue(arguments.isCountWords());
        Assert.assertFalse(arguments.isHelp());
        Assert.assertFalse(arguments.isVersion());

    }

    @Test
    public void parseFileNameTest() {
        String[] str = {"test.txt"};
        arguments = parser.parse(str);
        Assert.assertEquals("test.txt", Arguments.getFilePatch().get(0));

    }
}
