package com.codegym.controller;

import com.codegym.model.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ContactManagement implements ReadFile, WriteFile {
    private List<Contact> contacts = new ArrayList<>();
    private static ContactManagement contactManagement;

    public int size() {
        return contacts.size();
    }

    public void removeContact(Contact contact) {
        contacts.remove(contact);
    }

    public int findIndexByPhonenumber(String phonenumber) {
        int index = -1;
        for (int i = 0; i < this.contacts.size(); i++) {
            if (this.contacts.get(i).getPhonenumber().equals(phonenumber)) {
                index = i;
                break;
            }
        }
        return index;
    }

    public Contact findContactByName(String name) {
        for (Contact contact : contacts) {
            if (contact.getName().equals(name))
                return contact;
        }
        return null;
    }

    public void displayAll() {
        for (Contact contact : contacts) {
            System.out.println(contact);
        }
    }

    public void addNew(Contact contact) {
        this.contacts.add(contact);
    }


    public void updateByName(String name, Contact contact) {
        Contact phonebook1 = findContactByName(name);
        contacts.set(1, phonebook1);
    }

    public boolean deleteByName(String name) {
        Contact contact = findContactByName(name);
        if (name.equals(contact.getName())) {
            contacts.remove(contact);
            return true;
        } else {
            return false;
        }
    }

    public void deleteContact(String phonenumber){
        int index = findIndexByPhonenumber(phonenumber);
        this.contacts.remove(index);
    }

    public void updateContact(Contact contact, String phonenumber){
        int index = findIndexByPhonenumber(phonenumber);
        this.contacts.set(index,contact);
    }

    public static ContactManagement getInstance() {
        if (contactManagement == null) {
            contactManagement = new ContactManagement();
        }
        return contactManagement;
    }

    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            String name = lines[0].trim();
            String phone = lines[1].trim();
            String address = lines[2].trim();
            String email = lines[3].trim();
            String facebook = lines[4].trim();
            Contact phonebook = new Contact(name, phone, address, email, facebook);
            this.contacts.add(phonebook);
        }
        bufferedReader.close();
        fileReader.close();
    }

    @Override
    public void writeFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter("contact.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Contact contact : contacts) {
            bufferedWriter.write(contact.toString());
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
