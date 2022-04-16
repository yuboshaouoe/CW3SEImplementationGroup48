package state;

import model.GovernmentRepresentative;
import model.User;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class UserState implements IUserState{

    private Map<String,User> users;
    private User currentUser;

    public UserState(){
        this.users = new HashMap<>();
        this.currentUser = null;
        GovernmentRepresentative representative =
                new GovernmentRepresentative("prince.andrew@gov.uk",
                                            "bruh moment",
                                "prince.andrew@gov.uk");
        this.users.put(representative.getEmail(), representative);
    }

    public UserState(IUserState other){
        this.users = new HashMap<>();
        this.users.putAll(other.getAllUsers());
        this.currentUser = other.getCurrentUser();
    }

    public void addUser(User user){users.put(user.getEmail(), user);}

    public Map<String, User> getAllUsers(){return users;}

    public User getCurrentUser(){return currentUser;}

    public void setCurrentUser(User user){currentUser = user;}

}

