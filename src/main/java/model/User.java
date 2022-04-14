package model;

import at.favre.lib.crypto.bcrypt.BCrypt;


public abstract class User {
    private String email;
    private String passwordHash;
    private String paymentAccountEmail;

    protected User(String email, String password, String paymentAccountEmail){
        this.email = email;
        this.passwordHash = BCrypt.withDefaults().hashToString(12, password.toCharArray());
        this.paymentAccountEmail = paymentAccountEmail;
    }

    public boolean checkPasswordMatch(String password){
        return BCrypt.verifyer().verify(password.toCharArray(), passwordHash).verified;
    }

    public void updatePassword(String newPassword){
        this.passwordHash = BCrypt.withDefaults().hashToString(12, newPassword.toCharArray());
    }


    public String getEmail(){return email;}

    public void setEmail(String newEmail){this.email = newEmail;}

    public String getPaymentAccountEmail(){return paymentAccountEmail;}

    public void setPaymentAccountEmail(String newPaymentAccountEmail){this.paymentAccountEmail = newPaymentAccountEmail;}

    public String toString(){
        return "User Email: " + this.email;
    }
}
