package state;

public class BookingState implements IBookingState{

    public BookingState(){}

    public BookingState(IBookingState other){}

    public Booking findBookingByNumber(long bookingNumber){}

    public List<Booking> findBookingsByEventNumber(long eventNumber){}

    public Booking createBooking(Consumer booker,
                                  EventPerformance performance,
                                  int numTickets,
                                  double amountPaid){}

}
