package com.codegym.controller;

import com.codegym.model.Phonebook;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PhonebookManagement implements ReadFile,WriteFile{
    private List<Phonebook> phonebooks= new ArrayList<>();

    public int size(){
        return phonebooks.size();
    }
    public void removePhoneBook(Phonebook phonebook){
        phonebooks.remove(phonebook);
    }
    public Phonebook findPhoneNumberById(int searchID) {
        for (Phonebook phonebook : phonebooks){
            if (phonebook.getId() == searchID)
                return phonebook;
        }
        return null;
    }

    public Phonebook findContactByName(String name){
        for (Phonebook phonebook : phonebooks){
            if (phonebook.getName().equals(name))
                return phonebook;
        }
        return null;
    }

    public void displayAll() {
        for (Phonebook phonebook: phonebooks) {
            System.out.println(phonebook);
        }
    }


    public void addNew(Phonebook phonebook) {
        phonebooks.add(phonebook);
    }


    public void updateByName(String name, Phonebook phonebook) {
        Phonebook phonebook1 = findContactByName(name);
        phonebooks.set(1, phonebook1);
    }


    public boolean deleteByName(int searchID) {
       Phonebook phonebook2 = findPhoneNumberById(searchID);
       phonebooks.remove();
    }


    @Override
    public void readFile(String path) throws IOException, ClassNotFoundException {
        FileReader fileReader = new FileReader(path);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] lines = line.split(",");
            int id = Integer.parseInt(lines[0].trim());
            String name = lines[1].trim();
            String phone = lines[2].trim();
            String address = lines[3].trim();
            String email = lines[4].trim();
            String facebook = lines[5].trim();
            Phonebook phonebook = new Phonebook(id, name, phone, address,email,facebook);
            this.phonebooks.add(phonebook);
        }
        bufferedReader.close();
        fileReader.close();
    }

    @Override
    public void writeFile(String path) throws IOException {
        FileWriter fileWriter = new FileWriter("contact.csv");
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        for (Phonebook phonebook : phonebooks) {
            bufferedWriter.write(phonebook.toString());
        }
        bufferedWriter.close();
        fileWriter.close();
    }
}
