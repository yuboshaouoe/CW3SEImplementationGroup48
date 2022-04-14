package controller;

import external.MockPaymentSystem;
import external.PaymentSystem;
import state.EventState;
import state.IBookingState;
import state.IEventState;
import state.UserState;

public class Context {

    private MockPaymentSystem mockPaymentSystem;
    private IUserState userState;
    private IEventState eventState;
    private IBookingState bookingState;



    public Context(){}

    public Context(Context other){}

    public PaymentSystem getPaymentSystem(){}

    public IUserState getUserState(){return userState}

    public IBookingState getBookingState(){return bookingState}

    public IEventState getEventState(){return eventState}
}
