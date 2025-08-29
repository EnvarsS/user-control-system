package org.envycorp.usercontrolsystem.model;

import org.envycorp.usercontrolsystem.storage_util.IdGenerator;

public class User {
    private int id;
    private String firstName;
    private String surname;
    private String position;
    private String email;
    private String password;

    public User(String firstName, String lastName, String position, String email, String password) {
        this.id = IdGenerator.generateId();
        this.firstName = firstName;
        this.surname = lastName;
        this.position = position;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public String getPosition() {
        return position;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public void changeUserParams(String firstName, String surname, String position, String email, String password) {
        this.firstName = firstName;
        this.surname = surname;
        this.position = position;
        this.email = email;
        this.password = password;
    }
}
