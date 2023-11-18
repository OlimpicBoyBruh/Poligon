package ru.sberbank.jd.lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class OutputResultTest {
    OutputResult result;

    @Before
    public void init() {
        result = new OutputResult();
    }

    @Test
    public void getLinesAndWordsTest() {
        Assert.assertEquals(1, result.getLines());
        Assert.assertEquals(0, result.getWords());
    }

    @Test
    public void UpdateLinesAndWordsTest() {
        result.updateLine();
        result.updateWords();
        Assert.assertEquals(2, result.getLines());
        Assert.assertEquals(1, result.getWords());
    }

    @Test
    public void reloadTest() {
        result.updateLine();
        result.updateWords();
        result.reload();
        Assert.assertEquals(1, result.getLines());
        Assert.assertEquals(0, result.getWords());
    }


    @Test
    public void readExceptionTest() {

        try {
            result.read("");
            Assert.fail();
        } catch (RuntimeException e) {
            System.out.println("Work");
        }

    }

    @Test
    public void searchKeyTest() {
        Assert.assertFalse(result.searchArguments());
        result.setFilePatch("-d");
        Assert.assertTrue(result.searchArguments());
    }
}
