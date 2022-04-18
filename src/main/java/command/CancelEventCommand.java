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
        this.successResult = false;
    }

    public void execute(Context context){

        User currUser = context.getUserState().getCurrentUser();
        String currEmail = currUser.getEmail();

        if (  !organiserMessage.isEmpty()   &&   currUser instanceof EntertainmentProvider   &&   !isNull(context.getEventState().findEventByNumber(this.eventNumber))  ){
            Event event = context.getEventState().findEventByNumber(this.eventNumber);

                if(  event.getStatus().equals(EventStatus.ACTIVE)   &&   currEmail.equals(event.getOrganiser().getEmail())  ){
                            boolean started = false;
                            LocalDateTime currTime = LocalDateTime.now();

                            for(EventPerformance p : event.getPerformances()){
                                if(currTime.isAfter(p.getStartDateTime())){
                                    started = true;
                                    break;
                                }
                            }
                            if(!started){
                                //sponsorship refunding left out
                                event.cancel();
                                for (Booking b : context.getBookingState().findBookingsByEventNumber(eventNumber)){
                                    b.cancelByProvider();
                                    context.getPaymentSystem().processRefund(
                                            b.getBooker().getPaymentAccountEmail(), // consumer email
                                            b.getEventPerformance().getEvent().getOrganiser().getPaymentAccountEmail(), // provider email
                                            b.getAmountPaid()); // transaction amount
                                }
                                this.successResult = true;
                            }
                }

        }



    }

    public Boolean getResult(){return successResult;}


}
