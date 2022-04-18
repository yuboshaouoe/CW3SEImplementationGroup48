import command.RegisterConsumerCommand;
import controller.Controller;
import logging.Logger;
import model.*;
import org.junit.jupiter.api.*;
import state.BookingState;
import command.*;
import state.BookingState;
import state.EventState;
import state.IBookingState;
import state.IEventState;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class TestBookingState {
    private BookingState bookingState;

    @BeforeEach
    void printTestName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @BeforeEach
    void setup(){
        bookingState = new BookingState();
    }

    @AfterEach
    void clearLogs() {
        Logger.getInstance().clearLog();
        System.out.println("---");
    }

    @Test
    @DisplayName("CreateBooking test")
    void createBookings(){
        Consumer consumer = new Consumer("bob", "goodgoodbob@ed.ac.uk","07313141423","qwert",
                "goodgoodbob@ed.ac.uk");
        ArrayList<String> entertainmentProvider = new ArrayList<>();
        entertainmentProvider.add("entertain");
        ArrayList<String> entertainmenProviderEmail= new ArrayList<>();
        entertainmenProviderEmail.add("entertain@gmail.com");

        EntertainmentProvider ep = new EntertainmentProvider("Test", "does not", "work@gmail.com", "as" ,"Iexpected@gmial.com", "aaaaa", entertainmentProvider, entertainmenProviderEmail);


        EventState eventState = new EventState();
//        eventState.createEventPerformance(ep,"idk","01", "00" , "aaaa");














    }

}
