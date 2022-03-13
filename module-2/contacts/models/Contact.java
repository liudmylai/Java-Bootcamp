package models;

import java.util.Date;
import java.util.concurrent.TimeUnit;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Contact {
    private String name;
    private int age;
    private String birthDate;
    private String phoneNumber;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
    }

    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        setAge(calculateAge(birthDate));
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number cannot be null/blank/less than 5 characters");
        }    
        this.phoneNumber = phoneNumber;
    }
    /**
     * Name: calculateAge
     * @param birthDate
     * @return age (int)
     * @throws ParseException
     * 
     * Inside the function:
     * 1. Parses a date from the birthDate String
     * 2. Gets the current date
     * 3. Subtracts the difference and returns the age.
     * 
     */
    private int calculateAge(String birthDate) throws ParseException {
        // Research how to create an object of the SimpleDateFormat class.
        SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");

        // A method that can specify whether date parsing should be lenient.
        formatter.setLenient(false);

        // Use the SimpleDateFormat object to parse() a Date from the birthDate String.
        // Assume the birthDate follows the MM/dd/yyyy format.
        Date bDate = formatter.parse(birthDate);

        // Get the current time as a Date object.
        // Find a method from the Date class that returns milliseconds since 1970 from
        // each date.
        Date today = new Date();

        // Get the difference between both time units. This difference is the person's
        // age in milliseconds.
        long diff = today.getTime() - bDate.getTime();

        // Research how to use the TimeUnit class to convert from milliseconds to days.
        long days = TimeUnit.MILLISECONDS.toDays(diff);

        // Then, divide by 365 to get the years.
        // Typecast the result to int and update the age field.
        return (int) days / 365;
    }

    public Contact(String name, String phoneNumber, String birthDate) throws ParseException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("name cannot be null/blank");
        }
        this.name = name;
        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() < 5) {
            throw new IllegalArgumentException("phone number cannot be null/blank/less than 5 characters");
        }
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = calculateAge(birthDate);
    }

    public Contact(Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

    @Override
    public String toString() {
        return String.format("Name: %s\nPhone: %s\nBirth Date: %s\nAge: %d years old", this.name, this.phoneNumber, this.birthDate,
                this.age);
    }

}