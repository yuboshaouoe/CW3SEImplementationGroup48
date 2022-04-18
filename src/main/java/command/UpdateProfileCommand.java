package command;

import controller.Context;
import model.User;

import java.util.Map;

public class UpdateProfileCommand implements ICommand{

    protected Boolean successResult;

    public UpdateProfileCommand(){}

    protected boolean isProfileUpdateInvalid(Context context,
                                              String oldPassword,
                                              String newEmail){

        successResult = false;
        if(context.getUserState().getCurrentUser().checkPasswordMatch(oldPassword)){
            Map<String, User> allUsers = context.getUserState().getAllUsers();
            if(!allUsers.containsKey(newEmail)){
                successResult = true;
            }
        }
        return successResult;
    }

    @Override
    public void execute(Context context) {}

    public Boolean getResult(){
        return successResult;
    }

}
