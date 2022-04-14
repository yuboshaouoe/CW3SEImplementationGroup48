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
                   LocalDateTime bookingDateTime){
        this.booking = BookingStatus.Active;
    }

    public long getBookingNumber(){return this.bookingNumber;}

    public BookingStatus getStatus(){return this.booking;}

    public Consumer getBooker(){return this.booker;}

    public EventPerformance getEventPerformance(){return this.performance;}

    public double getAmountPaid(){return this.amountPaid;}

    public void cancelByConsumer(){this.booking = BookingStatus.CANCELLED_BY_CONSUMER;}

    public void cancelPaymentFailed(){this.booking = BookingStatus.PAYMENT_FAILED;}

    public void cancelByProvider(){this.booking = BookingStatus.CANCELLED_BY_PROVIDER;}

    public String toString(){
        String output = "Booking no: " + this.bookingNumber + "\nBooked by: " + this.booker.toString() + "\nEvent: " + this.performance.toString() + "\nEvent Time: " + this.bookingDateTime.toString() + "\nNo. Tickets: " + this.numTickets + "\nCost: " + this.amountPaid;
        return output;
    }
}
