package com.codegym.view;

import com.codegym.controller.ContactManagement;
import com.codegym.model.Contact;

import java.io.IOException;
import java.util.Scanner;

public class ContactMenu {
    public static Scanner scanner = new Scanner(System.in);

    public void run() {
        ContactManagement contactManagement = new ContactManagement();
        contactManagement.addNew(new Contact("a","a","a","a","a"));
        int choice = -1;
        do {
            menu();
            System.out.println("Chọn chức năng: ");
            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("---Xem danh sách");
                    showContact(contactManagement);
                    break;
                case 2:
                    System.out.println("---Thêm mới");
                    Contact contact = inputNewContactInfo();
                    contactManagement.addNew(contact);
                    break;
                case 3:
                    System.out.println(("---Cập nhật---"));
                    updateContact(contactManagement);
                    break;
                case 4:
                    System.out.println("---Xóa---");
                    deleteContact(contactManagement);
                    break;
                case 5:
                    System.out.println("---Tìm kiếm---");
                    findContact(contactManagement);
                    break;
                case 6:
                    System.out.println("---Đọc file---");
                    try {
                        contactManagement.readFile("contact.csv");
                    } catch (IOException | ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
                case 7:
                    System.out.println("---Ghi file---");
                    try {
                        contactManagement.writeFile("contact.csv");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                    break;
            }
        }
            while (choice != 0) ;
        }


        private void updateContact(ContactManagement phonebookManagement){
            System.out.println("---Cập nhật thông tin số điên thaoị");
            System.out.println("Nhập tên contact bạn muốn thay đổi");
            String searchName = scanner.nextLine();
            phonebookManagement.findContactByName(searchName);
            System.out.println("Cập nhật thất bại do ko tìm thấy sdt");
        }

        private void deleteContact(ContactManagement contactManagement){
            System.out.println(("---Xóa---"));
            System.out.println("Nhập danh bạ mà bạn muốn xóa:");
            String name = scanner.nextLine();
            System.out.println("Bạn chắc chắn muốn xóa?(Y/N?)");
            String deleteChoice = scanner.nextLine();
                if(deleteChoice.equals("Y")){
                    Contact contact = contactManagement.findContactByName(name);
                    contactManagement.removeContact(contact);
                } else if (deleteChoice.equals("N")){

                } else {

                }
        }

        private void findContact(ContactManagement contactManagement){
            System.out.println("---Tìm kiếm---");
            System.out.println("Nhập tên liên lạc bạn muốn tìm: ");
            String name = scanner.nextLine();
            Contact contact = contactManagement.findContactByName(name);
            if (name.equals(contact.getName())) {
                System.out.println("Thông tin danh bạ cần tìm" + "\"" + contact);
            }
        }

        private Contact inputNewContactInfo(){
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
            Contact contact = new Contact(name, phoneNumber, address, email, facebook);
            return contact;
        }

        private void showContact(ContactManagement phonebookManagement){
            int size = phonebookManagement.size();
            if (size == 0) {
                System.out.println("Danh bạ trống");
            } else {
                System.out.println("---Danh bạ---");
                phonebookManagement.displayAll();
            }
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
            System.out.println("0. Thoát");
            System.out.println("Chọn chức năng");
        }
    }
