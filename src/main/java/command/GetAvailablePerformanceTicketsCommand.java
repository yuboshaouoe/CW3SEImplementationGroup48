package command;

import controller.Context;
import model.Event;
import model.TicketedEvent;
import static java.util.Objects.isNull;


public class GetAvailablePerformanceTicketsCommand implements ICommand{

    private long eventNumber;
    private long performanceNumber;
    private Integer result;

    public GetAvailablePerformanceTicketsCommand(long eventNumber,
                                                 long performanceNumber){
        this.eventNumber = eventNumber;
        this.performanceNumber = performanceNumber;
        this.result = null;
    }

    public void execute(Context context){
        if(!isNull(context.getEventState().findEventByNumber(this.eventNumber))) {
            Event event = context.getEventState().findEventByNumber(eventNumber);
            // if event doesn't exist -> event instanceof TicketedEvent == false
            if (event instanceof TicketedEvent   &&   !isNull(event.getPerformanceByNumber(performanceNumber)) ){
                result = ((TicketedEvent) event).getNumTickets();
            }
        }
    }

    public Integer getResult(){return result;}
}
