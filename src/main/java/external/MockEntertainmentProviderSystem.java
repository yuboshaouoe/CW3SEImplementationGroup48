//!!! NEEDS REVISION !!!

package external;

import java.time.LocalDateTime;
import java.util.*;


public class MockEntertainmentProviderSystem implements EntertainmentProviderSystem {

    private String orgName;
    private String orgAddress;

    private Map<Long, EventEntry> record;

    public MockEntertainmentProviderSystem(String orgName,
                                           String orgAddress) {
        this.orgName = orgName;
        this.orgAddress = orgAddress;
    }

    public void recordNewEvent(long eventNumber,
                               String title,
                               int numTickets) {
        if (record.containsKey(eventNumber)){
            System.out.println("Event already exists!");
        } else {
            EventEntry event = new EventEntry(eventNumber, title, numTickets);
            this.record.put(eventNumber, event);
        }
    }

    public void cancelEvent(long eventNumber,
                            String message) {
        if (record.containsKey(eventNumber)){
            record.remove(eventNumber);
            System.out.println(message);
        } else {
            System.out.println("Event doesn't exist!");
        }
    }

    public void recordNewPerformance(long eventNumber,
                                     long performanceNumber,
                                     LocalDateTime startDateTime,
                                     LocalDateTime endDateTime) {
        if (record.containsKey(eventNumber)){
            EventEntry event = record.get(eventNumber);
            if (!event.getPerformanceRecords().containsKey(performanceNumber)){
                PerformanceEntry p = new PerformanceEntry(performanceNumber, startDateTime, endDateTime);
                Map<Long, PerformanceEntry> newRecord = event.getPerformanceRecords();
                newRecord.put(performanceNumber, p);
                event.setPerformanceRecords(newRecord);
                record.replace(eventNumber, event);
            } else {
                System.out.println("The performance already exist!");
            }
        } else {
            System.out.println("The event doesn't exist!");
        }
    }

    public int getNumTicketsLeft(long eventNumber,
                                 long performanceNumber) {
        if (record.containsKey(eventNumber)){
            return record.get(eventNumber).getNumTickets();
        } else {
            System.out.println("The event doesn't exist!");
        }
        return -1;
    }

    public void recordNewBooking(long eventNumber,
                                 long performanceNumber,
                                 long bookingNumber,
                                 String consumerName,
                                 String consumerEmail,
                                 int bookedTickets) {
        if(record.containsKey(eventNumber)){
            EventEntry event = record.get(eventNumber);
            Map<Long, PerformanceEntry> pRecord = event.getPerformanceRecords();
            if(pRecord.containsKey(performanceNumber)){
                PerformanceEntry p = pRecord.get(performanceNumber);
                if(!p.getBookingRecords().containsKey(bookingNumber)){
                    BookingEntry b = new BookingEntry(bookingNumber, consumerName, consumerEmail, bookedTickets);
                    Map<Long, BookingEntry> newRecord = p.getBookingRecords();
                    newRecord.put(bookingNumber, b);
                    p.setBookingRecords(newRecord);
                    pRecord.replace(performanceNumber, p);
                    event.setPerformanceRecords(pRecord);
                    record.replace(eventNumber, event);
                } else {
                    System.out.println("The booking already exists!");
                }
            } else {
                System.out.println("The performance doesn't exist!");
            }
        } else {
            System.out.println("The event doesn't exist");
        }
    }

    public void cancelBooking(long bookingNumber) {

    }
}

class EventEntry {

    private long eventNumber;
    private String title;
    private int numTickets;

    private Map<Long, PerformanceEntry> performanceRecords;

    public EventEntry(long eventNumber,
                      String title,
                      int numTickets){
        this.eventNumber = eventNumber;
        this.numTickets = numTickets;
        this.title = title;
    }

    public long getEventNumber() {
        return eventNumber;
    }

    public String getTitle() {
        return title;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }

    public Map<Long, PerformanceEntry> getPerformanceRecords() {
        return performanceRecords;
    }

    public void setPerformanceRecords(Map<Long, PerformanceEntry> performanceRecords) {
        this.performanceRecords = performanceRecords;
    }
}

class PerformanceEntry {

    private long performanceNumber;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Map<Long, BookingEntry> bookingRecords;

    public PerformanceEntry(long performanceNumber,
                            LocalDateTime startDateTime,
                            LocalDateTime endDateTime){
        this.performanceNumber = performanceNumber;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
    }

    public long getPerformanceNumber() {
        return performanceNumber;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public Map<Long, BookingEntry> getBookingRecords() {
        return bookingRecords;
    }

    public void setBookingRecords(Map<Long, BookingEntry> bookingRecords) {
        this.bookingRecords = bookingRecords;
    }
}

class BookingEntry {

    private long bookingNumber;
    private String consumerName;
    private String consumerEmail;
    private int bookedTickets;

    public BookingEntry(long bookingNumber,
                        String consumerName,
                        String consumerEmail,
                        int bookedTickets){
        this.bookingNumber = bookingNumber;
        this.consumerEmail = consumerEmail;
        this.consumerName = consumerName;
        this.bookedTickets = bookedTickets;
    }

    public long getBookingNumber() {
        return bookingNumber;
    }
}