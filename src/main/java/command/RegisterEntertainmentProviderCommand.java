package command;

import controller.Context;
import model.EntertainmentProvider;

import java.util.List;

public class RegisterEntertainmentProviderCommand implements ICommand{
    private String orgName;
    private String orgAddress;
    private String paymentAccountEmail;
    private String mainRepName;
    private String mainRepEmail;
    private String passWord;
    private List<String> otherRepNames;
    private List<String> otherRepEmails;
    private EntertainmentProvider newEntertainmentProviderResult;
    private EntertainmentProvider attribute;

    public RegisterEntertainmentProviderCommand(String orgName,
                                                 String orgAddress,
                                                 String paymentAccountEmail,
                                                 String mainRepName,
                                                 String mainRepEmail,
                                                 String password,
                                                 List<String> otherRepNames,
                                                 List<String> otherRepEmails){
        this.orgName = orgName;
        this.orgAddress = orgAddress;
        this.paymentAccountEmail = paymentAccountEmail;
        this.mainRepName = mainRepName;
        this.mainRepEmail = mainRepEmail;
        this.passWord = password;
        this.otherRepNames = otherRepNames;
        this.otherRepEmails = otherRepEmails;
    }

    public void execute(Context context){
        boolean allNotNone = (orgName != null || orgAddress != null || paymentAccountEmail != null || mainRepName != null || mainRepEmail != null || passWord != null || otherRepEmails != null || otherRepNames != null);
        boolean noSameEmail = ! context.getUserState().getAllUsers().containsKey(mainRepEmail);
        boolean noSameNameOrAddress = ! (context.getUserState().getAllUsers().containsKey(orgName) || context.getUserState().getAllUsers().containsKey(orgAddress));

        boolean verifyPassed = allNotNone && noSameEmail && noSameNameOrAddress;

        if (verifyPassed){
            newEntertainmentProviderResult = new EntertainmentProvider(orgName, orgAddress, paymentAccountEmail, mainRepName, mainRepEmail, passWord, otherRepNames, otherRepEmails);
        } else {System.out.println("Failed to register entertainment provider because verification is not passed");}
    }

    public EntertainmentProvider getResult(){ return newEntertainmentProviderResult;}




}
