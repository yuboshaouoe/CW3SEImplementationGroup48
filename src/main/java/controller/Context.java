package controller;

import external.MockPaymentSystem;
import external.PaymentSystem;
import state.*;

public class Context {

    private MockPaymentSystem paymentSystem;
    private IUserState userState;
    private IEventState eventState;
    private IBookingState bookingState;



    public Context(){
        this.paymentSystem  = new MockPaymentSystem();
        this.userState      = new UserState();
        this.eventState     = new EventState();
        this.bookingState   = new BookingState();


    }

    public Context(Context other){
        this.userState     = new UserState(userState);
        this.eventState    = new EventState(eventState);
        this.bookingState  = new BookingState(bookingState);
        paymentSystem      = (MockPaymentSystem) other.getPaymentSystem();
    }

    public PaymentSystem getPaymentSystem(){return paymentSystem;}

    public IUserState getUserState(){return userState;}

    public IBookingState getBookingState(){return bookingState;}

    public IEventState getEventState(){return eventState;}
}
