public class Person {
    private String firstName;
    private String lastName;

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setPartner(Person partner) {
        this.partner = partner;
    }

    protected int age;
    private Person partner;

    public String getLastName() {
        return lastName;
    }

    public int getAge() {
        return age;
    }

    public Person getPartner() {
        return partner;
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.partner = null;
    }

    public String getFirstName() {
        return firstName;
    }

    public void registerPartnership(Person partner) {
        this.partner = partner;
        if (this.partner == null && partner.getPartner() == null) {
            this.partner = partner;
            if (this instanceof Woman) {
                this.lastName = partner.getLastName();
            }
            partner.registerPartnership(this); // Зареєструвати партнерство іншого об'єкта тут
        }
    }

    public void deregisterPartnership(boolean revertLastName) {
        if (this.partner != null) {
            this.partner = null;
            if (revertLastName && this instanceof Woman) {
                this.lastName = revertLastName();
            }
        }
    }
    protected String revertLastName() {
        return lastName;
    }

    protected boolean isRetired() {
        return false;
    }
}
