package model;

public class NonTicketedEvent extends Event {

    public NonTicketedEvent(long eventNumber,
                            EntertainmentProvider organiser,
                            String title,
                            EventType type){
        super(eventNumber, organiser, title, type);
    }

    public String toString(){
        return "Event No: " + this.getEventNumber() + "\nTitle: " + this.getTitle() + "\nEvent Type: " + this.getType().toString();
    }

}
