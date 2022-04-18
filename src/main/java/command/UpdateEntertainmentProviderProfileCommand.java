package command;

import controller.Context;
import model.EntertainmentProvider;
import model.User;

import java.util.List;
import java.util.Map;

public class UpdateEntertainmentProviderProfileCommand extends UpdateProfileCommand{

    private String oldPassword;
    private String newOrgName;
    private String newOrgAddress;
    private String newPaymentAccountEmail;
    private String newMainRepName;
    private String newMainRepEmail;
    private String newPassword;
    private List<String> newOtherRepNames;
    private List<String> newOtherRepEmails;


    public UpdateEntertainmentProviderProfileCommand(String oldPassword,
                                                     String newOrgName,
                                                     String newOrgAddress,
                                                     String newPaymentAccountEmail,
                                                     String newMainRepName,
                                                     String newMainRepEmail,
                                                     String newPassword,
                                                     List<String> newOtherRepNames,
                                                     List<String> newOtherRepEmails) {

        this.oldPassword = oldPassword;
        this.newOrgName = newOrgName;
        this.newOrgAddress = newOrgAddress;
        this.newPaymentAccountEmail = newPaymentAccountEmail;
        this.newMainRepName = newMainRepName;
        this.newMainRepEmail = newMainRepEmail;
        this.newPassword = newPassword;
        this.newOtherRepNames = newOtherRepNames;
        this.newOtherRepEmails = newOtherRepEmails;

    }

    public void execute(Context context) {

        User curr = context.getUserState().getCurrentUser();

        if (oldPassword != null && newOrgName != null && newOrgAddress != null
                && newPaymentAccountEmail != null && newMainRepName != null && newMainRepEmail != null
                && newPassword != null && newOtherRepNames != null && newOtherRepEmails != null) {

            if (curr instanceof EntertainmentProvider   &&   !isProfileUpdateInvalid(context, oldPassword, newMainRepEmail)) {
                EntertainmentProvider ent = (EntertainmentProvider) context.getUserState().getCurrentUser();
                Map<String, User> allUsers = context.getUserState().getAllUsers();

                boolean duplicates = false;
                for (User u : allUsers.values()) {
                    if (u instanceof EntertainmentProvider) {
                        EntertainmentProvider ue = (EntertainmentProvider) u;
                        if (ue.getOrgName().equals(newOrgName) && ue.getOrgAddress().equals(newOrgAddress)) {
                            duplicates = true;
                        }
                    }
                }

                if (!duplicates) {
                    ent.setOrgName(newOrgName);
                    ent.setOrgAddress(newOrgAddress);
                    ent.setPaymentAccountEmail(newPaymentAccountEmail);
                    ent.setMainRepName(newMainRepName);
                    ent.setMainRepEmail(newMainRepEmail);
                    ent.updatePassword(newPassword);
                    ent.setOtherRepNames(newOtherRepNames);
                    ent.setOtherRepEmails(newOtherRepEmails);
                    }

                }
            }

        }
    }


