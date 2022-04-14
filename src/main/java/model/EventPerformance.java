package model;

import java.time.LocalDateTime;
import java.util.List;

public class EventPerformance {

    private long performanceNumber;
    private Event event;
    private String venueAddress;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private List<String> performerNames;
    private boolean hasSocialDistancing;
    private boolean hasAirFiltration;
    private boolean isOutdoors;
    private int capacityLimit;
    private int venueSize;


    public EventPerformance(long performanceNumber,
                            Event event,
                            String venueAddress,
                            LocalDateTime startDateTime,
                            LocalDateTime endDateTime,
                            List<String> performerNames,
                            boolean hasSocialDistancing,
                            boolean hasAirFiltration,
                            boolean isOutdoors,
                            int capacityLimit,
                            int venueSize){
        this.performanceNumber = performanceNumber;
        this.event = event;
        this.venueAddress = venueAddress;
        this.startDateTime = startDateTime;
        this.endDateTime = endDateTime;
        this.performerNames = performerNames;
        this.hasSocialDistancing = hasSocialDistancing;
        this.hasAirFiltration = hasAirFiltration;
        this.isOutdoors = isOutdoors;
        this.capacityLimit = capacityLimit;
        this.venueSize = venueSize;
    }

    public long getPerformanceNumber(){return this.performanceNumber;}

    public Event getEvent(){return this.event;}

    public LocalDateTime getStartDateTime(){return this.startDateTime;}

    public LocalDateTime getEndDateTime(){return this.endDateTime;}

    public boolean hasSocialDistancing(){return this.hasSocialDistancing;}

    public boolean hasAirFiltration(){return this.hasAirFiltration;}

    public boolean isOutdoors(){return this.isOutdoors;}

    public int getCapacityLimit(){return this.capacityLimit;}

    public int getVenueSize(){return this.venueSize;}

    public String toString(){
        String output = "PerformanceNo: " + this.performanceNumber + "\n At Event: " + this.event.toString();
        return output;
    }
}
