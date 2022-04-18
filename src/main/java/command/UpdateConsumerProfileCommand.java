package command;

import controller.Context;
import model.Consumer;
import model.ConsumerPreferences;
import model.User;

import java.util.List;
import java.util.Map;

import static java.util.Objects.isNull;

public class UpdateConsumerProfileCommand extends UpdateProfileCommand {

    private String oldPassword;
    private String newName;
    private String newEmail;
    private String newPhoneNumber;
    private String newPassword;
    private String newPaymentAccountEmail;
    private ConsumerPreferences newPreferences;

    public UpdateConsumerProfileCommand(String oldPassword,
                                         String newName,
                                         String newEmail,
                                         String newPhoneNumber,
                                         String newPassword,
                                         String newPaymentAccountEmail,
                                         ConsumerPreferences newPreferences){

        this.oldPassword = oldPassword;
        this.newName = newName;
        this.newEmail = newEmail;
        this.newPhoneNumber = newPhoneNumber;
        this.newPassword = newPassword;
        this.newPaymentAccountEmail = newPaymentAccountEmail;
        this.newPreferences = newPreferences;

    }

    public void execute(Context context){

        if(!isNull(oldPassword) &&
                !isNull(newName) &&
                !isNull(newEmail) &&
                !isNull(newPhoneNumber) &&
                !isNull(newPassword) &&
                !isNull(newPaymentAccountEmail) &&
                !isNull(newPreferences)) {

            User curr = context.getUserState().getCurrentUser();

            if (curr instanceof Consumer   &&  !isProfileUpdateInvalid(context, oldPassword, newEmail)) {
                Consumer cons = (Consumer) curr;

                cons.setEmail(newEmail);
                cons.setName(newName);
                cons.setPhoneNumber(newPhoneNumber);
                cons.updatePassword(newPassword);
                cons.setPaymentAccountEmail(newPaymentAccountEmail);
                cons.setPreferences(newPreferences);
            }
        }

    }

}
