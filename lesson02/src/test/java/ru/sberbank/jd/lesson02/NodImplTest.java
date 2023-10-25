package ru.sberbank.jd.lesson02;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class NodImplTest {
    private Nod nod;
    @Before
    public void setUp(){
        nod = new NodImpl();
    }
    @Test
    public void CalculateTest() {
        Assert.assertEquals(1, nod.calculate(1, 1));
        Assert.assertEquals(6, nod.calculate(12, 18));
        Assert.assertEquals(Integer.MAX_VALUE, nod.calculate(0, 0));
    }
    @Test
    public void CalculateThrowTest(){
        try {
            nod.calculate(-1, 0);
            Assert.fail();
        }catch (ArithmeticException ex){

        }
    }
}