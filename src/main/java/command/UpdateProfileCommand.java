package command;

import controller.Context;

public class UpdateProfileCommand {

    protected Boolean successResult;

    public UpdateProfileCommand(){}

    protected boolean isProfileUpdateInvalid(Context context,
                                              String oldPassword,
                                              String newEmail){}

    public Boolean getResult(){}

}
