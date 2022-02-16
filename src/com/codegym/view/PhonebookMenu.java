package com.codegym.view;

import com.codegym.controller.PhonebookManagement;
import com.codegym.model.Phonebook;

import java.io.IOException;
import java.util.Scanner;

public class PhonebookMenu {
    public static Scanner scanner = new Scanner(System.in);

    public void run() {
        PhonebookManagement phonebookManagement = new PhonebookManagement();
        phonebookManagement.addNew(new Phonebook(1,"a","a","a","a","a"));
        int choice = -1;
        do {
            menu();
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    showPhonebook(phonebookManagement);
                    break;
                case 2:
                    System.out.println("---Thêm mới");

                    Phonebook phonebook = inputNewPhonebook();
                    phonebookManagement.addNew(phonebook);
                    break;
                case 3:
                    updatePhone(phonebookManagement);
                    break;
                case 4:
                    deletePhone(phonebookManagement);
                    break;
                case 5:
                    findPhoneNumber(phonebookManagement);
                    break;
                case 6:
                    System.out.println("Đọc file");
                    try {
                        phonebookManagement.readFile("contact.csv");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    try {
                        phonebookManagement.writeFile("contact.csv");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
            while (choice != 0) ;
        }


        private void updatePhone (PhonebookManagement phonebookManagement){
            System.out.println("---Cập nhật thông tin số điên thaoị");
            System.out.println("Nhập số điện thoai");
            String searchNumber = scanner.nextLine();
            phonebookManagement.findContactByName(searchNumber);
            System.out.println("Cập nhật thất bại do ko tìm thấy sdt");
        }

        private void deletePhone (PhonebookManagement phonebookManagement){
            System.out.println(("---Xóa---"));
            System.out.println("Nhập danh bạ mà bạn muốn xóa:");
            int searchID = scanner.nextInt();
            scanner.nextLine();

            Phonebook searchResult = phonebookManagement.findPhoneNumberById(searchID);

            if (searchResult == null){
                System.out.println("khoong tim thay");
            } else {
                phonebookManagement.removePhoneBook(searchResult);
                System.out.println("Da xoa");
            }

        }

        private void findPhoneNumber (PhonebookManagement phonebookManagement){
            System.out.println("---Tìm kiếm---");
            System.out.println("Nhập liên lạc bạn muốn tìm: ");
            String name = scanner.nextLine();
            Phonebook phonebook = phonebookManagement.findContactByName(name);
            if (name.equals(phonebook.getName())) {
                System.out.println("Thông tin danh bạ cần tìm" + "\"" + phonebook.toString());
            }
        }

        private Phonebook inputNewPhonebook(){
            System.out.println("Nhập mã người dùng");
            scanner.nextLine();
            int id = scanner.nextInt();
            System.out.println("Nhập họ và tên");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Nhập số điện thoại");
            String phoneNumber = scanner.nextLine();
            System.out.println("Nhập địa chỉ người dùng");
            String address = scanner.nextLine();
            System.out.println("Nhập email người dùng");
            String email = scanner.nextLine();
            System.out.println("Nhập facebook người dùng(");
            String facebook = scanner.nextLine();
            Phonebook phonebook = new Phonebook(id, name, phoneNumber, address, email, facebook);
            return phonebook;
        }

        private void showPhonebook (PhonebookManagement phonebookManagement){
            int size = phonebookManagement.size();
            if (size == 0) {
                System.out.println("Danh bạ trống");
            } else {
                System.out.println("---Danh bạ---");
                phonebookManagement.displayAll();
            }
        }

        private Phonebook inputPhonebookInfo () {
            System.out.println("Nhập mã người dùng");
            int id = scanner.nextInt();
            System.out.println("Nhập họ và tên");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Nhập số điện thoại");
            String phoneNumber = scanner.nextLine();
            System.out.println("Nhập địa chỉ người dùng");
            String address = scanner.nextLine();
            System.out.println("Nhập email người dùng");
            String email = scanner.nextLine();
            System.out.println("Nhập facebook người dùng(");
            String facebook = scanner.nextLine();
            return new Phonebook(id, name, phoneNumber, address, email, facebook);
        }

        private void menu () {
            System.out.println("---CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ---");
            System.out.println("Chọn chức năng theo số(để tiếp tục)");
            System.out.println("1. Xem danh sách");
            System.out.println("2. Thêm mới");
            System.out.println("3. Cập Nhật");
            System.out.println("4. Xóa");
            System.out.println("5. Tìm kiếm");
            System.out.println("6. Đọc từ file");
            System.out.println("7. Ghi vào file");
            System.out.println("8. Thoát");
        }
    }
