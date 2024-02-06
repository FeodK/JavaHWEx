package model;

import java.time.LocalDate;

public class Person {
    private String lastName;
    private String firstName;
    private String middleName;
    private LocalDate dob;
    private long phoneNumber;
    private char gender;

    public Person(String lastName, String firstName, String middleName, LocalDate dob, long phoneNumber, char gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.middleName = middleName;
        this.dob = dob;
        this.phoneNumber = phoneNumber;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public long getPhoneNumber() {
        return phoneNumber;
    }

    public char getGender() {
        return gender;
    }

    @Override
    public String toString() {
        return String.format("%s %s %s %s %d %c", lastName, firstName, middleName, dob, phoneNumber, gender);
    }
}