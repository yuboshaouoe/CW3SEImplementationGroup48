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
        String userEmail = user.getEmail();

        if (user instanceof Consumer){ //check user is a consumer
            if(!isNull(context.getEventState().findEventByNumber(this.eventNumber))) { //check event exists
                Event event = context.getEventState().findEventByNumber(this.eventNumber);  //get event

                if (event instanceof TicketedEvent) {   //check event is ticketed

                    if (this.numTicketsRequested >= 1) { //check number of tickets ordered isn't less than one
                        TicketedEvent eventTicket = (TicketedEvent) event;
                        Consumer consumer = (Consumer) user;

                        if (!isNull(eventTicket.getPerformanceByNumber(this.performanceNumber))) { //check performance exists
                            EventPerformance perf = eventTicket.getPerformanceByNumber(this.performanceNumber);
                            LocalDateTime currentTime = LocalDateTime.now();

                            if (currentTime.isBefore(perf.getEndDateTime())) {  //check performance hasn't ended yet

                                if (eventTicket.getNumTickets() >= this.numTicketsRequested) { //check number of tickets is still available
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
            }
        }
    }

    public Long getResult(){return this.newBookingNum;}
}
