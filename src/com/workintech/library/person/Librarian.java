package com.workintech.library.person;

import com.workintech.library.enums.UserRole;

public class Librarian extends Person {
    private String email;
    private String password;
    private UserRole role;

    //constructors start

    public Librarian(String firstName, String lastName, String email, String password) {
        super(firstName, lastName);
        this.email = email;
        this.password = password;
        this.role = UserRole.LIBRARIAN;
    }


    //constructors end

    //getter setter start

    public String getEmail() {
        return email;
    }

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    //getter setter end

    @Override
    public String toString() {
        return super.toString();
    }
}
