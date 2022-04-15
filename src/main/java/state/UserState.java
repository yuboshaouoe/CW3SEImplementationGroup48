package state;

import model.GovernmentRepresentative;
import model.User;

import java.util.Collection;
import java.util.Collections;
import java.util.Map;

public class UserState implements IUserState{

//    private Collection<User> users;

    Map<String,User> users;
//    private Collection<User> loggedInUsers;

    private User currentUser;

    public UserState(){
        this.users = Collections.emptyList();
        //this.users = new HashMap<>();
        this.currentUser = null;
    }

    public UserState(IUserState other){
        this.users = ((UserState)other).users;
        this.currentUser = ((UserState)other).currentUser;

        // check the deep copy here! (maybe i implement a shallow copy only)
    }

    public void addUser(User user){users.put(user.getEmail(), user);}

    public Map<String, User> getAllUsers(){return users;}

    public User getCurrentUser(){return currentUser;}

    public void setCurrentUser(User user){currentUser = user;}

}

