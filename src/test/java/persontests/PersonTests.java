package persontests;

import dataproviders.person.PersonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import persons.Man;
import persons.Person;
import persons.Woman;

import static messages.person.MessagePerson.*;

public class PersonTests {
    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "firstName")
    public void testCheckSetFirstName(String firstNameActual, String firstNameExpected){
//        Person person = new Person();
//        person.setFirstName("Oleksandr");
        Assert.assertEquals(firstNameActual, firstNameExpected, firstNameMessage(firstNameActual, firstNameExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "lastName")
    public void testCheckSetLastName(String lastNameActual, String lastNameExpected){
        Assert.assertEquals(lastNameActual, lastNameExpected, lastNameMessage(lastNameActual, lastNameExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "age")
    public void testCheckSetAge(int ageActual, int ageExpected){
        Assert.assertEquals(ageActual, ageExpected, ageMessage(ageActual, ageExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "partner")
    public void testCheckPartner(String partnerActual, String partnerExpected){
        Assert.assertEquals(partnerActual, partnerExpected, partnerMessage(partnerActual, partnerExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "notRetired")
    public void testCheckNotRetired(boolean isRetired, String firstName){
        Assert.assertEquals(isRetired, false, shouldNotBeRetiredMessage(firstName));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "retired")
    public void testCheckIsRetired(boolean isRetired, String firstName){
        Assert.assertEquals(isRetired, true, shouldBeRetiredMessage(firstName));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "registerPartnership")
    public void testCheckRegisterPartnership(String partnerActual, String partnerExpected){
        Assert.assertEquals(partnerActual, partnerExpected, registerPartnershipMessage(partnerActual, partnerExpected));
    }

    @Test(groups = {"properties"})
    public void testCheckDeregisterPartnership(){
        Woman woman = new Woman("Ira", "Vynyuk", 28);
        Man man = new Man("Oleksandr", "Levko", 27);
        man.registerPartnership(woman.getLastName());
        man.deregisterPartnership(true);
        Assert.assertEquals(man.getPreviousLastName(), man.getLastName(), deregisterPartnershipMessage(man.getPreviousLastName(), man.getLastName()));
    }
}