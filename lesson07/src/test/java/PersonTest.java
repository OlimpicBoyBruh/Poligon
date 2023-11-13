import org.junit.Assert;
import org.junit.Test;
import ru.sberbank.jd.lesson07.Person;


public class PersonTest {
    @Test
    public void gettersTest() {
        Person person1 = new Person("Boris", "Moscow", 18);

        Assert.assertEquals(18, person1.getAge());
        Assert.assertEquals("Moscow", person1.getCity());
        Assert.assertEquals("Boris", person1.getName());
    }

    @Test
    public void settersTest() {
        Person person1 = new Person("Boris", "Moscow", 18);

        person1.setAge(15);
        person1.setCity("Voronezh");
        person1.setName("Staz");

        Assert.assertEquals(15, person1.getAge());
        Assert.assertEquals("Voronezh", person1.getCity());
        Assert.assertEquals("Staz", person1.getName());
    }


    @Test
    public void compareToTest() {
        Person person1 = new Person("Boris", "Moscow", 18);
        Person person2 = new Person("Artem", "Voronezh", 23);
        Person person3 = new Person("Stanislav", "Arkhangelsk", 23);
        Person person4 = new Person("Arkady", "Arkhangelsk", 23);
        Person person5 = new Person("Denis", "Samara", 23);
        Person person6 = new Person("Arkady", "Arkhangelsk", 23);

        Assert.assertFalse(person4.compareTo(person3) > 0);
        Assert.assertEquals(0, person4.compareTo(person6));
        Assert.assertFalse(person1.compareTo(person2) > 0);
        Assert.assertFalse(person2.compareTo(person3) < 0);
        Assert.assertFalse(person2.compareTo(person4) < 0);
        Assert.assertFalse(person3.compareTo(person5) > 0);


    }

    @Test(expected = IllegalArgumentException.class)
    public void cityExceptionTest() {
        Person person1 = new Person("Artem", null, 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void nameExceptionTest() {
        Person person1 = new Person(null, "Voronezh", 5);
    }

    @Test(expected = IllegalArgumentException.class)
    public void ageExceptionTest() {
        Person person1 = new Person("Artem", "Voronezh", -1);
    }

    @Test
    public void equalsAndHashCodeTest() {
        Person person1 = new Person("artEm", "Voronezh", 23);
        Person person2 = new Person("Roman", "Moscow", 18);
        Person person3 = new Person("Artem", "Voronezh", 23);
        Person person4 = new Person("lERA", "OREL", 23);
        Person person5 = new Person("Lera", "Orel", 22);

        Assert.assertEquals(person1, person3);
        Assert.assertNotEquals(person2, person3);
        Assert.assertNotEquals(person4, person5);
        Assert.assertNotEquals(person3, person5);

        Assert.assertEquals(person1.hashCode(), person3.hashCode());
        Assert.assertNotEquals(person2.hashCode(), person3.hashCode());

        person1 = person2;

        Assert.assertEquals(person1, person2);
        Assert.assertEquals(person1.hashCode(), person2.hashCode());
        Assert.assertNotEquals(person4.hashCode(), person5.hashCode());
        Assert.assertNotEquals(person3.hashCode(), person5.hashCode());


    }


}
