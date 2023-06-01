package dataproviders.person;

import data.ages.Ages;
import data.firstnames.FirstNames;
import data.lastnames.LastNames;
import org.testng.annotations.DataProvider;
import persons.Man;
import persons.Woman;

public class PersonDataProvider {

    @DataProvider
    public Object[][] firstName() {
        Man man = new Man();
        man.setFirstName("Oleksandr");

        Woman woman = new Woman();
        woman.setFirstName("Ira");
        return new Object [][] {
                {man.getFirstName(), FirstNames.Oleksandr},
                {woman.getFirstName(), FirstNames.Ira}
        };
    }

    @DataProvider
    public Object[][] lastName() {
        Man man = new Man();
        man.setLastName("Levko");

        Woman woman = new Woman();
        woman.setLastName("Vynyuk");
        return new Object [][] {
                {man.getLastName(), LastNames.Levko},
                {woman.getLastName(), LastNames.Vynyuk}
        };
    }

    @DataProvider
    public Object[][] age() {
        Man man = new Man();
        man.setAge(25);

        Woman woman = new Woman();
        woman.setAge(28);
        return new Object [][] {
                {Ages.twenty_five, man.getAge()},
                {Ages.twenty_eight, woman.getAge()}
        };
    }

    @DataProvider
    public Object[][] partner() {
        Man man = new Man();
        man.setPartner("Ira");

        Woman woman = new Woman();
        woman.setPartner("Oleksandr");
        return new Object [][] {
                {man.getPartner(), FirstNames.Ira},
                {woman.getPartner(), FirstNames.Oleksandr}
        };
    }

    @DataProvider
    public Object[][] notRetired() {
        Man man = new Man("Oleksandr", "Levko", 65);
        Woman woman = new Woman("Ira", "Vynyuk", 60);

        return new Object [][] {
                {man.isRetired(), man.getFirstName()},
                {woman.isRetired(), woman.getFirstName()}
        };
    }

    @DataProvider
    public Object[][] retired() {
        Man man = new Man("Oleksandr", "Levko", 66);
        Woman woman = new Woman("Ira", "Vynyuk", 61);

        return new Object [][] {
                {man.isRetired()},
                {woman.isRetired()}
        };
    }

    @DataProvider
    public Object[][] registerPartnership() {
        Woman ira = new Woman("Ira", "Vynyuk", 28);
        Man oleksandr = new Man("Oleksandr", "Levko", 27);
        oleksandr.registerPartnership(ira.getLastName());

        Man ivan = new Man("Ivan", "Levko", 22);
        Woman olga = new Woman("Olga", "Vynyuk", 21);
        olga.registerPartnership(ivan.getLastName());

        return new Object [][] {
                {oleksandr.getPartner(), LastNames.Vynyuk},
                {olga.getPartner(), LastNames.Levko}
        };
    }

    @DataProvider
    public Object[][] deregisterPartnershipTrue() {
        Woman ira = new Woman("Ira", "Vynyuk", 28);
        Man oleksandr = new Man("Oleksandr", "Levko", 27);
        oleksandr.registerPartnership(ira.getLastName());
        oleksandr.deregisterPartnership(true);

        Man ivan = new Man("Ivan", "Levko", 27);
        Woman olga = new Woman("Olga", "Vynyuk", 28);
        olga.registerPartnership(ivan.getLastName());
        olga.deregisterPartnership(true);

        return new Object [][] {
                {oleksandr.getLastName(), LastNames.Levko},
                {olga.getPartner(), LastNames.Vynyuk}
        };
    }
}