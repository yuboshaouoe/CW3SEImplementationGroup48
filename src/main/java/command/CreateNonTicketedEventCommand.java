package command;

import controller.Context;
import external.EntertainmentProviderSystem;
import external.MockPaymentSystem;
import model.EntertainmentProvider;
import model.EventType;
import model.NonTicketedEvent;

import state.EventState;
import state.UserState;

public class CreateNonTicketedEventCommand extends CreateEventCommand{
    public CreateNonTicketedEventCommand(String title, EventType type) {
        super(title, type);
    }

    public void execute(Context context){
        if (isUserAllowedToCreateEvent(context)) {

            //EventState eventState = (EventState) context.getEventState();
            //UserState userState = (UserState) context.getUserState();
            // Create event

            EntertainmentProvider curr = (EntertainmentProvider) context.getUserState().getCurrentUser();

            context.getEventState().createNonTicketedEvent(curr,title, type);
        }
    }
}
