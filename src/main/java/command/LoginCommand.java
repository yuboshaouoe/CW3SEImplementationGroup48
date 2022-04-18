package command;

import controller.Context;
import model.User;

import java.util.Map;

public class LoginCommand implements ICommand{

    private String email;
    private String password;
    private User result;

    public LoginCommand(String email,
                        String password){
        this.email = email;
        this.password = password;
        this.result = null;
    }

    public void execute(Context context){
        Map<String,User> allUsers = context.getUserState().getAllUsers();
        if (allUsers.containsKey(email)) {
            User user1 = allUsers.get(email);
            if (user1.checkPasswordMatch(password)) {
                result = user1;
            }
        }
    }

    public User getResult(){return result;}

}
