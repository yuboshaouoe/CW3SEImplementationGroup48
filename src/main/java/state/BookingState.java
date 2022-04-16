package state;

import model.Booking;
import model.Consumer;
import model.Event;
import model.EventPerformance;

import java.time.LocalDateTime;
import java.util.*;

public class BookingState implements IBookingState{

    private long nextBookingNumber;
    private List<Booking> bookings;


    public BookingState(){
        this.nextBookingNumber = 1;
        this.bookings = new ArrayList<Booking>();
    }

    public BookingState(IBookingState other){
        BookingState newState = (BookingState)other;
        this.nextBookingNumber = newState.nextBookingNumber;
        this.bookings = new ArrayList<Booking>();
        this.bookings.addAll(newState.getAllBookings());

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
        List<Booking> foundBookings = null;
        for( Booking b : bookings){
            if (b.getEventPerformance().getEvent().getEventNumber() == eventNumber){
                foundBookings.add(b);
            }
        }
        return foundBookings;
    }

    public Booking createBooking(Consumer booker,
                                 EventPerformance performance,
                                 int numTickets,
                                 double amountPaid){
        Booking b = new Booking(nextBookingNumber, booker, performance, numTickets, amountPaid, LocalDateTime.now());
        bookings.add(b);
        nextBookingNumber++;
        return b;
    }
    public List<Booking> getAllBookings(){return this.bookings;}
}
