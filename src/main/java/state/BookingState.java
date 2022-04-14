package state;

import model.Booking;
import model.Consumer;
import model.Event;
import model.EventPerformance;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class BookingState implements IBookingState{

    private long nextBookingNumber;
    private Collection<Booking> bookings;

    public BookingState(){}

    public BookingState(IBookingState other){}

    public Booking findBookingByNumber(long bookingNumber){}

    public List<Booking> findBookingsByEventNumber(long eventNumber){}

    public Booking createBooking(Consumer booker,
                                 EventPerformance performance,
                                 int numTickets,
                                 double amountPaid){

    }
}
