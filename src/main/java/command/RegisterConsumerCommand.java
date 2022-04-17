package command;

import controller.Context;
import model.Consumer;

public class RegisterConsumerCommand {

    private String name;
    private String email;
    private String phoneNumber;
    private String password;
    private String paymentAccountEmail;

    private Consumer newConsumerResult;


    public RegisterConsumerCommand (String name,
                                    String email,
                                    String phoneNumber,
                                    String password,
                                    String paymentAccountEmail){
        this.name = name;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.password = password;
        this.paymentAccountEmail = paymentAccountEmail;
    }

    public void execute(Context context){
        boolean allNotNone = (name != null || email != null || phoneNumber == null || password == null || paymentAccountEmail == null);
        boolean registeredUser = (context.getUserState().getAllUsers().containsKey(name) || context.getUserState().getAllUsers().containsKey(email));

        if (registeredUser && allNotNone){
            newConsumerResult = new Consumer(name, email, phoneNumber, password, paymentAccountEmail);
        } else {System.out.println("Failed to register consumer because verification is not passed");}
    }

    public Consumer getResult(){
        return newConsumerResult;
    }

}
