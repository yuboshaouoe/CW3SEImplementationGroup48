package command;

import controller.Context;
import state.IEventState;
import state.IUserState;

public class LogoutCommand implements ICommand{

    public LogoutCommand(){}

    public void execute(Context context){
        IUserState u = context.getUserState();
        if (u.getCurrentUser() != null){
            u.setCurrentUser(null);
        }
    }

    public Void getResult(){return null;}

}
