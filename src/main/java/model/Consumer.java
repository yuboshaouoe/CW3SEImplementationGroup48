package model;

import java.util.ArrayList;
import java.util.List;

public class Consumer extends User{
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

    public void addBooking(Booking booking){}

    public String getName(){}

    public ConsumerPreferences getPreferences(){}

    public void setPreferences(ConsumerPreferences preferences){}

    public List<Booking> getBookings(){}

    public void notify(String message){}

    public void setName(String newName){}

    public void setPhoneNumber(String newPhoneNumber){}

    public String toString(){}
}
