package com.codegym.model;

public class Contact {
    private String name;
    private String phonenumber;
    private String address;
    private String email;
    private String facebook;


    public Contact() {
    }

    public Contact(String name, String phonenumber, String address, String email, String facebook) {
        this.name = name;
        this.phonenumber = phonenumber;
        this.address = address;
        this.email = email;
        this.facebook = facebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    @Override
    public String toString() {
        return "Contact"+
                ", name='" + name + '\'' +
                ", phonenumber=" + phonenumber +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
}
