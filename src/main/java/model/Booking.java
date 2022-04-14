package model;
import java.time.LocalDateTime;

public class Booking {

    private long bookingNumber;
    private Consumer booker;
    private EventPerformance performance;
    private int numTickets;
    private double amountPaid;
    private LocalDateTime bookingDateTime;

    private BookingStatus booking;

    public Booking(long bookingNumber,
                   Consumer booker,
                   EventPerformance performance,
                   int numTickets,
                   double amountPaid,
                   LocalDateTime bookingDateTime){}

    public long getBookingNumber(){return this.bookingNumber;}

    public BookingStatus getStatus(){}

    public Consumer getBooker(){return this.booker;}

    public EventPerformance getEventPerformance(){return this.performance;}

    public double getAmountPaid(){return this.amountPaid;}

    public void cancelByConsumer(){}

    public void cancelPaymentFailed(){this.booking = BookingStatus.PAYMENT_FAILED;}

    public void cancelByProvider(){this.booking = BookingStatus.CANCELLED_BY_PROVIDER;}

    public String toString(){}
}
