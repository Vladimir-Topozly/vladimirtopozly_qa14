package com.telran.addressbook.model;

public class ContactData {
    private String firstName;
    private String lastName;
    private String title;
    private String company;
    private String companyAddress;
    private String phone;
    private String email;
    private String address;

    public ContactData setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData setTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData setCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData setCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        return this;
    }

    public ContactData setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public ContactData setEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactData setAddress(String address) {
        this.address = address;
        return this;
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

    public String getEmail() { return email; }

    public String getAddress() {
        return address;
    }
}
