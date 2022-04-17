package command;

import controller.Context;
import model.*;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class CancelBookingCommand implements ICommand{

    private long bookingNumber;
    private boolean success;

    public CancelBookingCommand(long bookingNumber){
        this.bookingNumber = bookingNumber;
        this.success = false;
    }

    public void execute(Context context){
        User user = context.getUserState().getCurrentUser();
        String userEmail = user.getEmail();

        if(user instanceof Consumer) { //check if current user is a consumer

            if(!isNull(context.getBookingState().findBookingByNumber(this.bookingNumber))) { //check booking exists
                Booking booking = context.getBookingState().findBookingByNumber(this.bookingNumber);
                double payment = booking.getAmountPaid();
                Consumer booker = booking.getBooker();
                Consumer currConsumer = (Consumer) user;

                if(booker.equals(currConsumer)) { //booking owner is current user

                    if(booking.getStatus().equals(BookingStatus.Active)) { //check booking is active
                        LocalDateTime currTime = LocalDateTime.now();
                        EventPerformance perf = booking.getEventPerformance();
                        String sellerEmail = perf.getEvent().getOrganiser().getEmail();

                        if (perf.getStartDateTime().isAfter(currTime.plusHours(24))) { //check start time is further than 24 hours away
                            boolean refunded = context.getPaymentSystem().processRefund(userEmail, sellerEmail, payment);

                            if(refunded) { //check refund is successful
                                booking.cancelByConsumer();
                                success = true;
                            }
                        }
                    }
                }
            }
        }

    }

    public Boolean getResult(){return success;}

}
