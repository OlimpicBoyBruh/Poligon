package ru.sberbank.jd.lesson04;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class ResultPrinterTest {
    ResultPrinter resultPrinter;
    OutputResult result;

    @Before
    public void init() {
        resultPrinter = new ResultPrinter();
        result = new OutputResult();
    }

    @Test
    public void helpTest() {
        Assert.assertEquals("\n"
                + "Программа частично дублирующая функционал Linux-программы `wc`\n"
                + "  -l           количество строк.\n"
                + "  -w           количество слов.\n"
                + "  --help       Справка по использованию программы.\n"
                + "  --version    Версия программы, фамилия разработчика.\n", resultPrinter.help());
    }

    @Test
    public void versionTest() {
        Assert.assertEquals("WordCount version 2.0, by Meschcheryakov", resultPrinter.version());
    }
}
