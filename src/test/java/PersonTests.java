import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class PersonTests {
    @DataProvider(name = "ageData")
    public static Object[][] ageData() {
        return new Object[][] {
                { 30, false },
                { 28, false },
                {78, true},
                {66, true}
        };
    }


    @Test(dataProvider = "ageData")
    public void testIsRetiredForMan(int age, boolean expected) {
        Person man = new Man("Nick", "Pruchkovskyi", age);
        Assert.assertEquals(man.isRetired(), expected);
    }

    @Test(dataProvider = "ageData")
    public void testIsRetiredForWoman(int age, boolean expected) {
        Person woman = new Woman("Mila", "Kalkutina", age);
        Assert.assertEquals(woman.isRetired(), expected);
    }

    @Test
    public void testRegisterPartnership() {
        Person man = new Man("Nick", "Pruchkovskyi", 30);
        Person woman = new Woman("Mila", "Kalkutina", 28);

        man.registerPartnership(woman);
        woman.registerPartnership(man);

        Assert.assertEquals(man.getPartner(), woman);
        Assert.assertEquals(woman.getPartner(), man);
        Assert.assertEquals(man.getLastName(), woman.getLastName());
    }

    @Test
    public void testDeregisterPartnership() {
        Person man = new Man("Nick", "Pruchkovskyi", 30);
        Person woman = new Woman("Mila", "Kalkutina", 28);

        man.registerPartnership(woman);
        man.deregisterPartnership(true);

        Assert.assertNull(man.getPartner());
        Assert.assertNull(woman.getPartner());
        Assert.assertEquals(man.getLastName(), "Pruchkovskyi");
        Assert.assertEquals(woman.getLastName(), "Kalkutina");
    }
}