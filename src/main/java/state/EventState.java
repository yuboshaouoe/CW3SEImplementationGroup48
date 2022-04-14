package state;

import model.*;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

public class EventState implements IEventState{

    private List<Event> allEvents;
    private List<EventPerformance> allPerf;
    private long eventNumCounter = 0;
    private long performanceNumCounter = 0;

    public EventState(){}

    public EventState(IEventState other){}

    public List<Event> getAllEvents(){
        return allEvents;
    }

    public Event findEventByNumber(long eventNumber){
        for(Event e : allEvents){
            if (e.getEventNumber() == eventNumber){
                return e;
            }
        }
        return null;
    }

    public NonTicketedEvent createNonTicketedEvent(EntertainmentProvider organiser,
                                                    String title,
                                                    EventType type){
        eventNumCounter ++;
        NonTicketedEvent newEvent = new NonTicketedEvent(eventNumCounter, organiser, title, type);
        allEvents.add(newEvent);
        return newEvent;
    }

    public TicketedEvent createTicketedEvent(EntertainmentProvider organiser,
                                              String title,
                                              EventType type,
                                              double ticketPrice,
                                              int numTickets){

        eventNumCounter ++;
        TicketedEvent newEvent = new TicketedEvent(eventNumCounter, organiser, title, type, ticketPrice,numTickets);
        allEvents.add(newEvent);
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

        performanceNumCounter++;
        EventPerformance performance = new EventPerformance(performanceNumCounter, event, venueAddress, startDateTime, endDateTime, performerNames, hasSocialDistancing, hasAirFiltration, isOutdoors, capacityLimit, venueSize);
        allPerf.add(performance);
        return performance;

    }
}
