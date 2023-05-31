package persons;

public abstract class Person {
    private String firstName;
    private String lastName;
    private String previousLastName;
    private int age;
    private String partner;
    protected int retirementAge;

    public Person(){

    }

    public Person(String firstName, String lastName, int age){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public Person(String firstName, String lastName, int age, String partner){
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = partner;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getPreviousLastName(){return previousLastName;}

    public int getAge(){
        return age;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getPartner(){return partner;}

    public void setPartner(String partner){
        this.partner = partner;
    }

    public boolean isRetired() {
        if (getAge() > retirementAge){
            return true;
        }
        return false;
    }

    public void registerPartnership(String lastName){
        previousLastName = this.lastName;
        this.lastName = lastName;
    }

    public void deregisterPartnership(boolean needDeregister){
        if (needDeregister){
            this.lastName = previousLastName;
        }
    }
}