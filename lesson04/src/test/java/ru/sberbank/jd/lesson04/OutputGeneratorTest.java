package ru.sberbank.jd.lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Mockito.when;

public class OutputGeneratorTest {
    private OutputGenerator generator;
    private OutputResult result;
    private Arguments arguments;

    @Before
    public void init() {
        generator = new OutputGenerator();
        result = Mockito.mock(OutputResult.class);
        arguments = Mockito.mock(Arguments.class);
    }

   /* @Test
    public void emptyArgumentsTest() {
        when(arguments.isVersion()).thenReturn(true);

        OutputResult actualResult = OutputGenerator.generate(arguments);

        Mockito.verify(result).version();
        Assert.assertEquals(result, actualResult);

    }*/
}
