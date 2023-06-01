package persontests;

import dataproviders.person.PersonDataProvider;
import org.testng.Assert;
import org.testng.annotations.Test;
import persons.Person;

import static messages.person.MessagePerson.*;

public class PersonTests {

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "firstName")
    public void testCheckSetFirstName(String name, String nameExpected){
        Person person = new Person();
        person.setFirstName(name);
        Assert.assertEquals(person.getFirstName(), nameExpected, firstNameMessage(person.getFirstName(), nameExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "lastName")
    public void testCheckSetLastName(String lastName, String lastNameExpected){
        Person person = new Person();
        person.setLastName(lastName);
        Assert.assertEquals(person.getLastName(), lastNameExpected, lastNameMessage(person.getLastName(), lastNameExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "age")
    public void testCheckSetAge(int age, int ageExpected){
        Person person = new Person();
        person.setAge(age);
        Assert.assertEquals(person.getAge(), ageExpected, ageMessage(person.getAge(), ageExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "partner")
    public void testCheckPartner(String partner, String partnerExpected){
        Person person = new Person();
        person.setPartner(partner);
        Assert.assertEquals(person.getPartner(), partnerExpected, partnerMessage(person.getPartner(), partnerExpected));
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
    public void testCheckRegisterPartnership(Person personOne, Person personTwo, String lastNameExpected){
        personOne.registerPartnership(personTwo.getLastName());
        Assert.assertEquals(personOne.getLastName(), lastNameExpected, registerPartnershipMessage(personOne.getLastName(), lastNameExpected));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "deregisterPartnershipTrue")
    public void testCheckDeregisterPartnershipTrue(Person personOne, Person personTwo){
        personOne.registerPartnership(personTwo.getLastName());
        personOne.deregisterPartnership(true);
        Assert.assertEquals(personOne.getLastName(), personOne.getPreviousLastName(), deregisterPartnershipMessage(personOne.getLastName(), personOne.getPreviousLastName()));
    }

    @Test(dataProviderClass = PersonDataProvider.class, dataProvider = "deregisterPartnershipFalse")
    public void testCheckDeregisterPartnershipFalse(Person personOne, Person personTwo, String lastNameExpected){
        personOne.registerPartnership(personTwo.getLastName());
        personOne.deregisterPartnership(false);
        Assert.assertEquals(personOne.getLastName(), lastNameExpected, deregisterPartnershipMessage(personOne.getLastName(), lastNameExpected));
    }
}