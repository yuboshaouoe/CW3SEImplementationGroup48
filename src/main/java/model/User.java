package model;

import at.favre.lib.crypto.bcrypt.BCrypt;


public abstract class User {
    private String email;
    private String passwordHash;
    private String paymentAccountEmail;

    protected User(String email, String password, String paymentAccountEmail){
        this.email = email;
        this.passwordHash = password;
        //this.passwordHash = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        this.paymentAccountEmail = paymentAccountEmail;
    }



    public boolean checkPasswordMatch(String password){}

    public void updatePassword(String newPassword){}


    public String getEmail(){return email;}

    public void setEmail(String newEmail){this.email = newEmail;}

    public String getPaymentAccountEmail(){return paymentAccountEmail;}

    public void setPaymentAccountEmail(String newPaymentAccountEmail){this.paymentAccountEmail = newPaymentAccountEmail;}

    // public String toString(){} ez to cause bug, I ll left this

}
