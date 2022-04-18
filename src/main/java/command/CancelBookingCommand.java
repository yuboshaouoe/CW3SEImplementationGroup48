package command;

import controller.Context;
import model.*;

import java.time.LocalDateTime;

import static java.util.Objects.isNull;

public class CancelBookingCommand implements ICommand {

    private long bookingNumber;
    private boolean success;

    public CancelBookingCommand(long bookingNumber) {
        this.bookingNumber = bookingNumber;
        this.success = false;
    }

    public void execute(Context context) {
        User user = context.getUserState().getCurrentUser();
        String userEmail = user.getPaymentAccountEmail();
        LocalDateTime currTime = LocalDateTime.now();

        if (  user instanceof Consumer   &&   !isNull(context.getBookingState().findBookingByNumber(this.bookingNumber))  ){ //check user is consumer, booking exists
            Booking booking = context.getBookingState().findBookingByNumber(this.bookingNumber);
            double payment = booking.getAmountPaid();
            Consumer booker = booking.getBooker();
            Consumer currConsumer = (Consumer) user;
            EventPerformance perf = booking.getEventPerformance();

            if (  booker.equals(currConsumer)   &&   booking.getStatus().equals(BookingStatus.Active)  &&  perf.getStartDateTime().isAfter(currTime.plusHours(24)) ){ //check booking was made by current user, booking is still active and not within 24hrs time
                String sellerEmail = perf.getEvent().getOrganiser().getPaymentAccountEmail();
                boolean refunded = context.getPaymentSystem().processRefund(userEmail, sellerEmail, payment);

                if (  refunded  ){  //check refund was successful
                    booking.cancelByConsumer();
                    success = true;
                }
            }
        }
    }

    public Boolean getResult(){return success;}

}
