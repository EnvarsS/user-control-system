package org.envycorp.usercontrolsystem.storage_util;

import org.envycorp.usercontrolsystem.model.User;

import java.util.ArrayList;

public class InMemoryRepository {
    private static final InMemoryRepository instance = new InMemoryRepository();

    private final ArrayList<User> users;

    private InMemoryRepository() {
        this.users = new ArrayList<>();
        users.add(new User("Admin", "Admin", "Admin", "admin@gmail.com", "admin"));
        users.add(new User("Not", "Admin", "Admin", "admin2@gmail.com", "admin"));
    }

    public static InMemoryRepository getInstance() {
        return instance;
    }

    public void addUser(User user) {
        if(!isEmailExists(user.getEmail()))
            users.add(user);
    }

    private boolean isEmailExists(String email) {
        return users.stream().anyMatch(user -> user.getEmail().equals(email));
    }

    public ArrayList<User> getAllUsers() {
        return users;
    }

    public User getUserById(int id) {
        return users.stream().filter(user -> user.getId() == id).findFirst().orElse(null);
    }

    public void deleteUserById(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public User isUserAuthenticated(String email, String password) {
        return users.stream().filter(user -> user.getEmail().equals(email) && user.getPassword().equals(password)).findFirst().orElse(null);
    }

}
