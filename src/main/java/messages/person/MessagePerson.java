package messages.person;

public class MessagePerson {
    public static String firstNameMessage(String nameExpected, String nameActual){
        return String.format("Expected first name '%s' not equal '%s'", nameExpected, nameActual);
    }

    public static String lastNameMessage(String lastNameExpected, String lastNameActual){
        return String.format("Expected last name '%s' not equal '%s'", lastNameExpected, lastNameActual);
    }

    public static String ageMessage(int ageExpected, int ageActual){
        return String.format("Expected age '%s' not equal actual '%s'", ageExpected, ageActual);
    }

    public static String partnerMessage(String partnerExpected, String partnerActual){
        return String.format("Expected partner '%s' not equal actual '%s'", partnerExpected, partnerActual);
    }

    public static String shouldNotBeRetiredMessage(String namePerson){
        return String.format("'%s' should not be retired", namePerson);
    }

    public static String shouldBeRetiredMessage(String namePerson){
        return String.format("'%s' should be retired", namePerson);
    }

    public static String registerPartnershipMessage(String lastNamePerson, String lastNamePartnerPerson){
        return String.format("Person '%s' not married to '%s'", lastNamePerson, lastNamePartnerPerson);
    }

    public static String deregisterPartnershipMessage(String previousLastNamePerson, String currentLastnamePerson){
        return String.format("Person '%s' still not divorced, his/her last name '%s'", previousLastNamePerson, currentLastnamePerson);
    }
}