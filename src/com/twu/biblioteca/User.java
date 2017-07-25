package com.twu.biblioteca;

public class User {
    private String name;
    private String email;
    private String phoneNumber;
    private String library_number;
    private String password;

    public User(String name, String email, String phoneNumber,
                String library_number, String password) {
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.library_number = library_number;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getLibrary_number() {
        return library_number;
    }

    public String getPassword() {
        return password;
    }

    public String getUserDetail() {
        return String.format("name:%-4s email:%-4s phoneNumber:%s", name, email, phoneNumber);
    }

    public boolean checkCredentials(String input_library_number, String input_password) {
        return library_number.equals(input_library_number) &&
                password.equals(input_password);
    }
}
