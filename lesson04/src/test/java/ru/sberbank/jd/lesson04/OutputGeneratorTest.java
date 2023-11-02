package ru.sberbank.jd.lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class OutputGeneratorTest {
    private OutputGenerator generator;
    private OutputResult result;
    private Arguments arguments;

    @Before
    public void init() {
        generator = new OutputGenerator();
    }


    @Test
    public void generateDefaultTest() {
        generator = Mockito.mock(OutputGenerator.class);
        Mockito.when(generator.write()).thenReturn(true);
        result = generator.generate(new Arguments());
        Assert.assertNull(generator.generate(new Arguments()));
    }

    @Test
    public void argumentVersionTest() {
        ArgumentParser parser = new ArgumentParser();
        String[] str = {"--version", "-l", "-w", "-wl", "-lw", "test.txt"};
        arguments = parser.parse(str);
        result = generator.generate(arguments);
        Assert.assertEquals(true, result.isVersion());
        Assert.assertEquals(false, result.isHelp());
        Assert.assertEquals(false, result.isCountWords());
        Assert.assertEquals(false, result.isCountLines());
    }

    @Test
    public void argumentsHelpTest() {
        ArgumentParser parser = new ArgumentParser();
        String[] str = {"--help", "-l", "-w", "-wl", "-lw", "test.txt"};
        arguments = parser.parse(str);
        result = generator.generate(arguments);
        Assert.assertEquals(false, result.isVersion());
        Assert.assertEquals(true, result.isHelp());
        Assert.assertEquals(false, result.isCountWords());
        Assert.assertEquals(false, result.isCountLines());
    }

    @Test
    public void argumentWLTest() {
        ArgumentParser parser = new ArgumentParser();
        String[] str = {"-l", "-w", "-wl", "-lw", "test.txt"};
        arguments = parser.parse(str);
        result = generator.generate(arguments);
        Assert.assertEquals(false, result.isVersion());
        Assert.assertEquals(false, result.isHelp());
        Assert.assertEquals(true, result.isCountWords());
        Assert.assertEquals(true, result.isCountLines());
    }
}