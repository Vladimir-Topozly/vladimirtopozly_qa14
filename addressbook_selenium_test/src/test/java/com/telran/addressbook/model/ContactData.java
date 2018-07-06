package com.telran.addressbook.model;

import java.io.File;
import java.util.Objects;

public class ContactData {
    private int contactId;
    private String firstName;
    private String lastName;
    private String title;
    private String company;
    private String companyAddress;
    private String phone;
    private String email;
    private String address;
    private File photo;
    private String group;

    public String getGroup() {
        return group;
    }

    public ContactData withGroup(String group) {
        this.group = group;
        return this;
    }

    public File getPhoto() {
        return photo;
    }

    public ContactData withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

    public ContactData withFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public ContactData withLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public ContactData withTitle(String title) {
        this.title = title;
        return this;
    }

    public ContactData withCompany(String company) {
        this.company = company;
        return this;
    }

    public ContactData withCompanyAddress(String companyAddress) {
        this.companyAddress = companyAddress;
        return this;
    }

    public ContactData withPhone(String phone) {
        this.phone = phone;
        return this;
    }

    @Override
    public String toString() {
        return "ContactData{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public ContactData withEmail(String email) {
        this.email = email;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return contactId == that.contactId &&
                Objects.equals(firstName, that.firstName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(contactId, firstName);
    }

    public ContactData withAddress(String address) {
        this.address = address;
        return this;
    }

    public int getContactId() {
        return contactId;
    }

    public ContactData withContactID(int contactId) {
        this.contactId = contactId;
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

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }


}
