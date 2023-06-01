package persontests;

import dataproviders.person.PersonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import persons.Man;

public class PersonTests {
    @Test(groups = {"properties"},
    dataProviderClass = PersonDataProvider.class, dataProvider = "firstName")
    public void testCheckSetFirstName(String firstName){
//        Assert.assertEquals(firstName, firstName, firstNameMessage(man.getFirstName(), firstName));
    }

}
