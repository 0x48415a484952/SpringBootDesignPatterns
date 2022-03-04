package ir.sleepycat.springdesignpatterns.designpatterns.builder;


public class ContactBuilder {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Integer age;

    public ContactBuilder setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactBuilder setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public ContactBuilder setAge(Integer age) {
        this.age = age;
        return this;
    }

    public Contact build() {
        return new Contact(this.firstName, this.lastName, this.phoneNumber, this.age);
    }

}
