package command;

import controller.Context;
import external.MockEntertainmentProviderSystem;
import model.*;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class BookEventCommand implements ICommand{

    private long eventNumber;
    private long performanceNumber;
    private int numTicketsRequested;
    private long newBookingNum;

    public BookEventCommand(long eventNumber,
                            long performanceNumber,
                            int numTicketsRequested){
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
        this.numTicketsRequested = numTicketsRequested;
    }

    public void execute(Context context) {
        User user = context.getUserState().getCurrentUser();    //get current user
        String userEmail = user.getPaymentAccountEmail();

        if(user instanceof Consumer && !isNull(context.getEventState().findEventByNumber(this.eventNumber))) { //check event exists
            Event event = context.getEventState().findEventByNumber(this.eventNumber);  //get event
            Consumer consumer = (Consumer) user;

            if (this.numTicketsRequested >= 1 && event instanceof TicketedEvent) { //check event is ticketed and number of tickets requested isn't 0
                TicketedEvent eventTicket = (TicketedEvent) event;
                if (!isNull(eventTicket.getPerformanceByNumber(this.performanceNumber))) { //check performance exists
                    EventPerformance perf = eventTicket.getPerformanceByNumber(this.performanceNumber);
                    LocalDateTime currentTime = LocalDateTime.now();

                    if (eventTicket.getNumTickets() >= this.numTicketsRequested && currentTime.isBefore(perf.getEndDateTime())) { //check number of tickets is still available
                        double pricePaid = eventTicket.getOriginalTicketPrice();
                        pricePaid = pricePaid * numTicketsRequested;
                        String sellerEmail = eventTicket.getOrganiser().getPaymentAccountEmail();
                        boolean paid = context.getPaymentSystem().processPayment(userEmail, sellerEmail, pricePaid);

                        if (paid) { //check payment is successful
                            Booking newBooking = context.getBookingState().createBooking(consumer, perf, this.numTicketsRequested, pricePaid);
                            this.newBookingNum = newBooking.getBookingNumber();
                        }
                    }
                }
            }
        }
    }

    public Long getResult(){return this.newBookingNum;}
}
