package state;

import model.Booking;
import java.util.List;

public interface IBookingState {

    Booking findBookingByNumber(long bookingNumber);

    List<Booking> findBookingsByEventNumber(long eventNumber);

    Booking createBooking(Consumer booker,
                          EventPerformance performance,
                          int numTickets,
                          double amountPaid);
}
