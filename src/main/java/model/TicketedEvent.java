package model;

public class TicketedEvent extends Event{

    private double ticketPrice;
    private int numTickets;

    public TicketedEvent(long eventNumber,
                         EntertainmentProvider organiser,
                         String title,
                         EventType type,
                         double ticketPrice,
                         int numTickets){
        super(eventNumber, organiser, title, type);
        this.ticketPrice = ticketPrice;
        this.numTickets = numTickets;
    }

    public double getOriginalTicketPrice(){return this.ticketPrice;}

    //public double getDiscountedTicketPrice(){}  //dont need as group of 3

    public int getNumTickets(){return numTickets;}

    //public String getSponsorAccountEmail(){}    //dont need as group of 3

    //public boolean isSponsored(){}              //dont need as group of 3

    public String toString(){

        return "Event Title: " + this.getTitle() +
               "\nEvent No: " + this.getEventNumber() +
               "\nEvent Type: " + this.getType().toString() +
               "\nTicket Price: " + this.ticketPrice +
               "\nNo. of Tickets: " + this.numTickets;
    }
}
