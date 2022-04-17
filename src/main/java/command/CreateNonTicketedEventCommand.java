package command;

import controller.Context;
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

            EventState eventState = (EventState) context.getEventState();
            UserState userState = (UserState) context.getUserState();

            // Create event and event number
            NonTicketedEvent event = eventState.createNonTicketedEvent((EntertainmentProvider) userState.getCurrentUser(),title, type);
            eventNumberResult = event.getEventNumber();
        }
    }
}