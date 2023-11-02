package ru.sberbank.jd.lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


import java.io.*;

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
        result.updateWords(" Hello ");
        Assert.assertEquals(2, result.getLines());
        Assert.assertEquals(5, result.getWords());
    }

    @Test
    public void reloadTest() {
        result.updateLine();
        result.updateWords(" Hello ");
        result.reload();
        Assert.assertEquals(0, result.getLines());
        Assert.assertEquals(0, result.getWords());
    }

    @Test
    public void readTest() {
        File tempFile = null;
        try {
            tempFile = File.createTempFile("test", ".txt");
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            writer.write("Hello");
            writer.newLine();
            writer.write(" World ");
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        result.read(tempFile.getAbsolutePath());
        Assert.assertEquals(3, result.getLines());
        Assert.assertEquals(10, result.getWords());

        tempFile.delete();
    }

    @Test
    public void readExceptionTest() {

        try {
            result.read("");
            Assert.fail();
        } catch (RuntimeException e) {
        }

    }
}
