package command;

import controller.Context;

import java.util.List;

public class UpdateEntertainmentProviderProfileCommand {

    public UpdateEntertainmentProviderProfileCommand(String oldPassword,
                                                      String newOrgName,
                                                      String newOrgAddress,
                                                      String newPaymentAccountEmail,
                                                      String newMainRepName,
                                                      String newMainRepEmail,
                                                      String newPassword,
                                                      List<String> newOtherRepNames,
                                                      List<String> newOtherRepEmails){}

    public void execute(Context context){}

}
