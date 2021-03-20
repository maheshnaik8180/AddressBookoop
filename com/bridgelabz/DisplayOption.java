package com.bridgelabz;

public class DisplayOption {
    private String firstName, lastName, address, city, state, pin, phoneNumber;
    public DisplayOption(String firstName, String lastName, String address, String city, String state, String pin,
                         String phoneNumber) {

        setFirstName(firstName);
        setLastName(lastName);
        setAddress(address);
        setCity(city);
        setState(state);
        setPin(pin);
        setPhoneNumber(phoneNumber);
    }

    public DisplayOption() {

    }

    //Getter and Setter methods
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
        this.state = state;
    }
    public String getPin() {
        return pin;
    }
    public void setPin(String pin) {
        this.pin = pin;
    }
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    //to string method
    @Override
    public String toString() {
        return "DisplayOption [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", city="
                + city + ", state=" + state  + ", pin=" + pin + ", phoneNumber=" + phoneNumber + "]";
    }
}
