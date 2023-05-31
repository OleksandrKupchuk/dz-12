package persons;

public class Man extends Person {
    public Man(){
        super.retirementAge = 65;
    }

    public Man(String firstName, String lastName, int age) {
        super(firstName, lastName, age);
        super.retirementAge = 65;
    }

    public Man(String firstName, String lastName, int age, String partner) {
        super(firstName, lastName, age, partner);
        super.retirementAge = 65;
    }
}