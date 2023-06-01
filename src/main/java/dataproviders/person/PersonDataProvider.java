package dataproviders.person;

import org.testng.annotations.DataProvider;
import persons.Man;
import persons.Woman;

public class PersonDataProvider {

    @DataProvider
    public Object[][] firstName() {
        Man man = new Man();
        man.setFirstName("Ivan");

        Woman woman = new Woman();
        woman.setFirstName("Ira");
        return new Object [][] {
                {man.getFirstName()},
                {woman.getFirstName()}
        };
    }

}
