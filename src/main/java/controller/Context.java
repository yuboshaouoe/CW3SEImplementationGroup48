package controller;

import state.IEventState;

public class Context {
    public Context(){}

    public Context(Context other){}

    public PaymentSystem getPaymentSystem(){}

    public IUserState getUserState(){}

    public IBookingState getBookingState(){}

    public IEventState getEventState(){}
}
