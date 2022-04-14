package model;

public class GovernmentRepresentative extends User {

    public GovernmentRepresentative(String email,
                                    String password,
                                    String paymentAccountEmail){
        super(email, password, paymentAccountEmail);
    }

    public String toString(){
        return "Gov. Rep Email: " + this.getEmail();
    }
}
