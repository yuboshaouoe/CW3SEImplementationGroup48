package controller;

import state.IEventState;

public class Context {

    private MockPaymentSystem mockPaymentSystem;
    private IUserState userState;
    private IEventState eventState;
    private IBookingState bookingState;



    public Context(){}

    public Context(Context other){}

    public PaymentSystem getPaymentSystem(){}

    public IUserState getUserState(){}

    public IBookingState getBookingState(){}

    public IEventState getEventState(){}
}
