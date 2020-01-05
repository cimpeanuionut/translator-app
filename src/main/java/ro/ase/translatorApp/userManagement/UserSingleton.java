package ro.ase.translatorApp.userManagement;

import java.util.ArrayList;
import java.util.List;

public class UserSingleton {
    static private UserSingleton instance;
    private User currentUser;
    final private List<User> users;

    private UserSingleton(){
        users = new ArrayList<>();
    }

    public static synchronized UserSingleton getInstance(){
        if(instance == null){
            instance = new UserSingleton();
        }
        return instance;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public void addUser(User user){
        this.users.add(user);
    }

    public List<User> getUsers(){
        return users;
    }
}
