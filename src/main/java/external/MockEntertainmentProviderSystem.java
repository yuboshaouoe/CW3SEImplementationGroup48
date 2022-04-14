package external;

import model.Event;

import java.time.LocalDateTime;
import java.util.List;


public class MockEntertainmentProviderSystem implements EntertainmentProviderSystem{

    private String orgName;
    private String orgAddress;


    public MockEntertainmentProviderSystem(String orgName,
                                           String orgAddress){
        this.orgName = orgName;
        this.orgAddress = orgAddress;
    }

    public void recordNewEvent(long eventNumber,
                               String title,
                               int numTickets){

    }

    public void cancelEvent(long eventNumber,
                            String message){}

    public void recordNewPerformance(long eventNumber,
                                     long performanceNumber,
                                     LocalDateTime startDateTime,
                                     LocalDateTime endDateTime){}

    public int getNumTicketsLeft(long eventNumber,
                                 long performanceNumber){}

    public void recordNewBooking(long eventNumber,
                                 long performanceNumber,
                                 long bookingNumber,
                                 String consumerName,
                                 String consumerEmail,
                                 int bookedTickets){}

    public void cancelBooking(long bookingNumber){}

}
