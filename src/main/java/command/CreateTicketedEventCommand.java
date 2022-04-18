package command;

import controller.Context;
import external.EntertainmentProviderSystem;
import model.EntertainmentProvider;
import model.EventType;
import model.TicketedEvent;
import state.EventState;
import state.UserState;

public class CreateTicketedEventCommand extends CreateEventCommand {
    private int numTickets;
    private double ticketPrice;

    public CreateTicketedEventCommand(String title,
                                       EventType type,
                                       int numTickets,
                                       double ticketPrice){
        super(title, type);
        this.numTickets = numTickets;
        this.ticketPrice = ticketPrice;
    }

    public void execute(Context context){
        if (isUserAllowedToCreateEvent(context)) {
            //EventState eventState = (EventState) context.getEventState();
            //UserState userState = (UserState) context.getUserState();
            EntertainmentProvider curr = (EntertainmentProvider) context.getUserState().getCurrentUser();

            context.getEventState().createTicketedEvent(curr,
                    title, type, ticketPrice, numTickets);
        }
    }
}
