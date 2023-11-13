
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import ru.sberbank.jd.lesson07.CustomDigitComparator;

import java.util.List;
import java.util.ArrayList;

public class CustomDigitComparatorTest {
    private CustomDigitComparator comparator;

    @Before
    public void init() {
        comparator = new CustomDigitComparator();
    }

    @Test
    public void compareTest() {
        Assert.assertEquals(0, comparator.compare(4, -6));
        Assert.assertEquals(-1, comparator.compare(-6, -3));
        Assert.assertEquals(1, comparator.compare(-3, -2));
        Assert.assertEquals(0, comparator.compare(-1, 1));
        Assert.assertEquals(0, comparator.compare(-3, 3));
        Assert.assertEquals(1, comparator.compare(-5, 6));
    }

    @Test(expected = IllegalArgumentException.class)
    public void ComparatorExceptionTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(null);
        list.sort(comparator);
    }
}

