package com.telran.addressbook.model;

public class ContactData {
    private final String firstName;
    private final String lastName;
    private final String title;
    private final String company;
    private final String companyAddress;
    private final String phone;
    private final String email;
    private final String address;

    public ContactData(String firstName, String lastName, String title, String company, String companyAddress, String phone, String email, String address) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.title = title;
        this.company = company;
        this.companyAddress = companyAddress;
        this.phone = phone;
        this.email = email;
        this.address = address;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getTitle() {
        return title;
    }

    public String getCompany() {
        return company;
    }

    public String getCompanyAddress() {
        return companyAddress;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }
}
