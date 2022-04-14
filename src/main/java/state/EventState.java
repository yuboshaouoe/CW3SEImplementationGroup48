package state;

import model.*;

import java.time.LocalDateTime;
import java.util.List;

public class EventState implements IEventState{

    public EventState(){}

    public EventState(IEventState other){}

    public List<Event> getAllEvents(){}

    public Event findEventByNumber(long eventNumber){}

    public NonTicketedEvent createNonTicketedEvent(EntertainmentProvider organiser,
                                                    String title,
                                                    EventType type){

    }

    public TicketedEvent createTicketedEvent(EntertainmentProvider organiser,
                                              String title,
                                              EventType type,
                                              double ticketPrice,
                                              int numTickets){

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
                                                    int venueSize){

    }
}
