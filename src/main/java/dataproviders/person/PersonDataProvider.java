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
        return new Object [][] {
                {"Oleksandr", FirstNames.Oleksandr},
                {"Ira", FirstNames.Ira}
        };
    }

    @DataProvider
    public Object[][] lastName() {
        return new Object [][] {
                {"Levko", LastNames.Levko},
                {"Vynyuk", LastNames.Vynyuk}
        };
    }

    @DataProvider
    public Object[][] age() {
        return new Object [][] {
                {25, Ages.twenty_five},
                {28, Ages.twenty_eight}
        };
    }

    @DataProvider
    public Object[][] partner() {
        return new Object [][] {
                {"Ira", FirstNames.Ira},
                {"Oleksandr", FirstNames.Oleksandr}
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
                {man.isRetired(), man.getFirstName()},
                {woman.isRetired(), woman.getFirstName()}
        };
    }

    @DataProvider
    public Object[][] registerPartnership() {
        Woman ira = new Woman("Ira", "Vynyuk", 28);
        Man oleksandr = new Man("Oleksandr", "Levko", 27);

        Woman olga = new Woman("Olga", "Vynyuk", 28);
        Man ivan = new Man("Ivan", "Levko", 27);

        return new Object [][] {
                {oleksandr, ira, LastNames.Vynyuk},
                {olga, ivan, LastNames.Levko}
        };
    }

    @DataProvider
    public Object[][] deregisterPartnershipTrue() {
        Woman ira = new Woman("Ira", "Vynyuk", 28);
        Man oleksandr = new Man("Oleksandr", "Levko", 27);

        return new Object [][] {
                {oleksandr, ira},
                {ira, oleksandr}
        };
    }

    @DataProvider
    public Object[][] deregisterPartnershipFalse() {
        Woman ira = new Woman("Ira", "Vynyuk", 28);
        Man oleksandr = new Man("Oleksandr", "Levko", 27);

        Woman olga = new Woman("Olga", "Vynyuk", 28);
        Man ivan = new Man("Ivan", "Levko", 27);

        return new Object [][] {
                {oleksandr, ira, LastNames.Vynyuk},
                {olga, ivan, LastNames.Levko}
        };
    }
}