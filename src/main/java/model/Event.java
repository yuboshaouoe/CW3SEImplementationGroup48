package model;

import state.IBookingState;

import java.util.Collection;

public abstract class Event {

    private long eventNumber;
    private EntertainmentProvider organiser;
    private String title;
    private EventType type;
    private EventStatus status;

    private Collection<EventPerformance> performances;

    protected Event(long eventNumber,
                    EntertainmentProvider organiser,
                    String title,
                    EventType type){
        this.eventNumber = eventNumber;
        this.organiser = organiser;
        this.title = title;
        this.type = type;
        this.status = EventStatus.ACTIVE;
    }

    public long getEventNumber(){return this.eventNumber;}

    public EntertainmentProvider getOrganiser(){return this.organiser;}

    public String getTitle(){return this.title;}

    public EventType getType(){return this.type;}

    public EventStatus getStatus(){return this.status;}

    public void cancel() {
        this.status = EventStatus.CANCELLED;

    }

    public void addPerformance(EventPerformance performance){
        performances.add(performance);
    }

    public EventPerformance getPerformanceByNumber(long performanceNumber){
        for (EventPerformance p : this.performances){
            if (p.getPerformanceNumber() == performanceNumber){
                return p;
            }
        }
        return null;
    }

    public Collection<EventPerformance> getPerformances(){
        return this.performances;
    }

}
