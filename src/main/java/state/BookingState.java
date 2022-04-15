package state;

import model.Booking;
import model.Consumer;
import model.Event;
import model.EventPerformance;

import java.util.*;

public class BookingState implements IBookingState{

    private long nextBookingNumber;
    private Collection<Booking> bookings;

    public BookingState(){
        this.nextBookingNumber = 1;
        this.bookings = Collections.emptyList();
    }

    public BookingState(IBookingState other){
        this.nextBookingNumber = ((BookingState)other).nextBookingNumber;
        // dont know how to make deep copy of collection here. confused me for a long time

    }

    public Booking findBookingByNumber(long bookingNumber){

        for( Booking b : bookings){
            if (b.getBookingNumber() == bookingNumber){
                return b;
            }
        }
        return null;

    }

    public List<Booking> findBookingsByEventNumber(long eventNumber){
        List<Booking> foundBookings;
        List<Event> allEvents =
        for( Booking b : bookings){
            if ()
        }
    }

    public Booking createBooking(Consumer booker,
                                 EventPerformance performance,
                                 int numTickets,
                                 double amountPaid){

    }
}
