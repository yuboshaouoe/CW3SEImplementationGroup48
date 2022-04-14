package model;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends User{

    private String name;
    private String phoneNumber;

    private List<Booking> bookings;
    private ConsumerPreferences preferences;

    public Consumer(String name,
                    String email,
                    String phoneNumber,
                    String password,
                    String paymentAccountEmail){
        super(email, password, paymentAccountEmail);
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.bookings = new ArrayList<>();
        this.preferences = new ConsumerPreferences();
    }

    public void addBooking(Booking booking){bookings.add(booking);}     //add new booking to list

    public String getName(){return this.name;}

    public ConsumerPreferences getPreferences(){return this.preferences;}

    public void setPreferences(ConsumerPreferences preferences){this.preferences = preferences;}

    public List<Booking> getBookings(){return this.bookings;}

    public void notify(String message){System.out.println("Consumer has been notified");}

    public void setName(String newName){this.name = newName;}

    public void setPhoneNumber(String newPhoneNumber){this.phoneNumber = newPhoneNumber;}

    public String toString(){
        return "Cust name: " + this.name + "\nCust email: " + this.getEmail() + "\nCust phoneNum: " + this.phoneNumber;
    }
}
