package external;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;


public class MockEntertainmentProviderSystem implements EntertainmentProviderSystem {

    private String orgName;
    private String orgAddress;

    private Map<Long, String> eventNameRecord;

    private Map<Long, Integer> eventTicketRecord;

    private Map<Long, List<Long>> performanceRecord;

    private Map<Long, AbstractMap.SimpleEntry<LocalDateTime, LocalDateTime>> timeRecord;

    private Map<Long, AbstractMap.SimpleEntry<String, String>> consumerRecord;

    private Map<Long, Integer> bookedTicketsRecord;

    public MockEntertainmentProviderSystem(String orgName,
                                           String orgAddress) {
        this.orgName = orgName;
        this.orgAddress = orgAddress;
        this.eventNameRecord = Collections.emptyMap();
        this.eventTicketRecord = Collections.emptyMap();
        this.performanceRecord = Collections.emptyMap();
        this.timeRecord = Collections.emptyMap();
        this.consumerRecord = Collections.emptyMap();
        this.bookedTicketsRecord = Collections.emptyMap();
    }

    public void recordNewEvent(long eventNumber,
                               String title,
                               int numTickets) {
         eventNameRecord.put(eventNumber, title);
         eventTicketRecord.put(eventNumber, numTickets);
    }

    public void cancelEvent(long eventNumber,
                            String message) {
        eventNameRecord.remove(eventNumber);
        eventTicketRecord.remove(eventNumber);
        System.out.println(message);
    }

    public void recordNewPerformance(long eventNumber,
                                     long performanceNumber,
                                     LocalDateTime startDateTime,
                                     LocalDateTime endDateTime) {
        List<Long> performanceList = performanceRecord.get(eventNumber);
        if (!performanceList.contains(performanceNumber)){
            performanceList.add(performanceNumber);
            performanceRecord.replace(eventNumber, performanceList);
            timeRecord.put(performanceNumber, new AbstractMap.SimpleEntry<>(startDateTime, endDateTime));
        }
    }

    public int getNumTicketsLeft(long eventNumber,
                                 long performanceNumber) {
        return eventTicketRecord.get(eventNumber);
    }

    public void recordNewBooking(long eventNumber,
                                 long performanceNumber,
                                 long bookingNumber,
                                 String consumerName,
                                 String consumerEmail,
                                 int bookedTickets) {
        bookedTicketsRecord.put(bookingNumber, bookedTickets);
        consumerRecord.put(bookingNumber, new AbstractMap.SimpleEntry<>(consumerEmail, consumerName));
    }

    public void cancelBooking(long bookingNumber) {
        bookedTicketsRecord.remove(bookingNumber);
        consumerRecord.remove(bookingNumber);
    }
}