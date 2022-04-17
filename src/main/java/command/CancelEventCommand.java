package command;

import controller.Context;

import java.time.LocalDateTime;
import java.util.List;

import model.*;

import static java.util.Objects.isNull;

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

        if(!organiserMessage.isEmpty()) { //check string isn't empty
            User currUser = context.getUserState().getCurrentUser();
            String currEmail = currUser.getEmail();

            if (currUser instanceof EntertainmentProvider) {  //if current user is entertainment provider

                if (!isNull(context.getEventState().findEventByNumber(this.eventNumber))){ //if event exists
                    Event event = context.getEventState().findEventByNumber(this.eventNumber);

                    if(event.getStatus().equals(EventStatus.ACTIVE)){  //if event is active

                        if(currEmail.equals(event.getOrganiser().getEmail())){  //if current user is the event organiser
                            boolean started = false;
                            LocalDateTime currTime = LocalDateTime.now();

                            for(EventPerformance p : event.getPerformances()){  //check no performances have started
                                if(currTime.isAfter(p.getStartDateTime())){
                                    started = true;
                                    break;
                                }
                            }

                            if(!started){

                            }
                        }
                    }

                }
            }
        }


    }

    public Boolean getResult(){return successResult;}


}
