package SystemEntity;

import SystemHelper.HelperUtils;
import SystemInterface.Displayable;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Displayable {
    private String id;
    private String firstName;
    private String lastName;
    private LocalDate dateOfBirth;
    private String gender;
    private String phoneNumber;
    private String email;
    private String address;

    public Person(String id, String firstName, String lastName, LocalDate dateOfBirth, String gender, String phoneNumber, String email, String address) {
        this.id = HelperUtils.isValidString(id) ? id : HelperUtils.generateId("PER");
        this.firstName = HelperUtils.isValidString(firstName) ? firstName : "Unknown";
        this.lastName = HelperUtils.isValidString(lastName) ? lastName : "Unknown";
        this.dateOfBirth = HelperUtils.isNotNull(dateOfBirth) ? dateOfBirth : LocalDate.now();
        this.gender = HelperUtils.isValidString(gender) ? gender : "Unspecified";
        this.phoneNumber = HelperUtils.isValidString(phoneNumber) ? phoneNumber : "N/A";
        this.email = HelperUtils.isValidString(email) ? email : "N/A";
        this.address = HelperUtils.isValidString(address) ? address : "Not Provided";


        System.out.println("Person constructor called.");
    }

    public Person() {

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        if (HelperUtils.isValidString(id)) {
            this.id = id;
        }
        else {
            System.out.println("Invalid ID format.");
        }
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        if (HelperUtils.isValidString(firstName)) {
            this.firstName = firstName;
        }
        else {
            System.out.println("Invalid First Name.");
        }
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        if (HelperUtils.isValidString(lastName)) {
            this.lastName = lastName;
        }
        else {
            System.out.println("Invalid Last Name.");
        }
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        if (HelperUtils.isNotNull(dateOfBirth)) {
            this.dateOfBirth = dateOfBirth;
        }
        else {
            System.out.println("Invalid Date of Birth.");
        }
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        if (HelperUtils.isValidString(gender)) {
            this.gender = gender;
        }
        else {
            System.out.println("Invalid Gender value.");
        }
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (HelperUtils.isValidString(phoneNumber)) {
            this.phoneNumber = phoneNumber;
        }
        else {
            System.out.println("Invalid Phone Number.");
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        if (HelperUtils.isValidString(email)){
            this.email = email;
        }
        else{
            System.out.println("Invalid Email Address.");
        }
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        if (HelperUtils.isValidString(address)) {
            this.address = address;
        }
        else {
            System.out.println(" Invalid Address.");
        }
    }

    public String displayInfo(String str) {
        String info = "ID: " + id + System.lineSeparator()
                + "Name: " + firstName + " " + lastName + System.lineSeparator()
                + "Date of Birth: " + dateOfBirth + System.lineSeparator()
                + "Gender: " + gender + System.lineSeparator()
                + "Phone: " + phoneNumber + System.lineSeparator()
                + "Email: " + email + System.lineSeparator()
                + "Address: " + address;
        return info;
    }

    @Override
    public String displaySummary(String str) {
        return id + " - " + firstName + " " + lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", gender='" + gender + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                '}';

    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Person person)) return false;
        return Objects.equals(id, person.id) && Objects.equals(firstName, person.firstName) && Objects.equals(lastName, person.lastName) && Objects.equals(dateOfBirth, person.dateOfBirth) && Objects.equals(gender, person.gender) && Objects.equals(phoneNumber, person.phoneNumber) && Objects.equals(email, person.email) && Objects.equals(address, person.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, dateOfBirth, gender, phoneNumber, email, address);
    }
}
