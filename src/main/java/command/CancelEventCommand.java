package command;

import controller.Context;
import model.EventType;

public class CancelEventCommand implements ICommand{

    private String organiserMessage;
    private Long eventNumber;
    private Boolean successResult;


    public CancelEventCommand(long eventNumber,
                              String organiserMessage){
        this.organiserMessage = organiserMessage;
        this.eventNumber = eventNumber;
    }

    public void execute(Context context){
    }

    public Boolean getResult(){return successResult;}


}
