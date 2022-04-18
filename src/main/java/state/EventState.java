package state;

import external.EntertainmentProviderSystem;
import model.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class EventState implements IEventState{

    private List<Event> events;
    //private List<EventPerformance> allPerf;
    private long nextEventNumber;
    private long nextPerformanceNumber;

    public EventState(){
        this.events = new ArrayList<Event>();
        this.nextEventNumber = 1;
        this.nextPerformanceNumber = 1;

    }

    public EventState(IEventState other){
        EventState newState = (EventState) other;
        this.events = new ArrayList<Event>();
        this.events.addAll(newState.getAllEvents());
        this.nextEventNumber = newState.nextEventNumber;
        this.nextPerformanceNumber = newState.nextPerformanceNumber;
    }

    public List<Event> getAllEvents(){return events;}

    public Event findEventByNumber(long eventNumber){
        for(Event e : events){
            if (e.getEventNumber() == eventNumber){
                return e;
            }
        }
        return null;
    }

    public NonTicketedEvent createNonTicketedEvent(EntertainmentProvider organiser,
                                                    String title,
                                                    EventType type){
        NonTicketedEvent newEvent = new NonTicketedEvent(nextEventNumber, organiser, title, type);
        nextEventNumber ++;
        events.add(newEvent);
        newEvent.getOrganiser().getProviderSystem().recordNewEvent(newEvent.getEventNumber(),
                newEvent.getTitle(), 0);
        return newEvent;
    }

    public TicketedEvent createTicketedEvent(EntertainmentProvider organiser,
                                              String title,
                                              EventType type,
                                              double ticketPrice,
                                              int numTickets){

        TicketedEvent newEvent = new TicketedEvent(nextEventNumber, organiser, title, type, ticketPrice,numTickets);
        nextEventNumber ++;
        events.add(newEvent);
        newEvent.getOrganiser().getProviderSystem().recordNewEvent(newEvent.getEventNumber(),
                                                                   newEvent.getTitle(),
                                                                   newEvent.getNumTickets());
        return newEvent;
    }

    public EventPerformance createEventPerformance(Event event,
                                                    String venueAddress,
                                                    LocalDateTime startDateTime,
                                                    LocalDateTime endDateTime,
                                                    List<String> performerNames,
                                                    boolean hasSocialDistancing,
                                                    boolean hasAirFiltration,
                                                    boolean isOutdoors,
                                                    int capacityLimit,
                                                    int venueSize) {

        EventPerformance performance = new EventPerformance(nextPerformanceNumber, event, venueAddress, startDateTime, endDateTime, performerNames, hasSocialDistancing, hasAirFiltration, isOutdoors, capacityLimit, venueSize);

        nextPerformanceNumber++;
        event.addPerformance(performance);
        return performance;

    }
}
