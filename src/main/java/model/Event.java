package model;

import java.util.Collection;

public abstract class Event {

    protected Event(long eventNumber,
                    EntertainmentProvider,
                    String title,
                    EventType type
                    ){}

    public long getEventNumber(){}

    public EntertainmentProvider getOrganiser(){}

    public String getTitle(){}

    public EventType getType(){}

    public EventStatus getStatus(){}

    public void cancel() {
        EventStatus.CANCELLED;
    }

    public void addPerformance(EventPerformance performance){}

    public EventPerformance getPerformanceByNumber(long performanceNumber){}

    public Collection<EventPerformance> getPerformances(){}


}
