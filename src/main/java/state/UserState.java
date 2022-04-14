package state;

import model.GovernmentRepresentative;
import model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class UserState implements IUserState{

    private Collection<User> users;
    private Collection<User> loggedInUsers;

    public UserState(){
        this.users = Collections.emptyList();
        this.loggedInUsers = null;
    }

    public UserState(IUserState other){}

    public void addUser(User user){}

    public Map<String, User> getAllUsers(){}

    public User getCurrentUser(){}

    public void setCurrentUser(User user){}

}

