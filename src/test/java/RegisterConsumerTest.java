import command.*;
import controller.Controller;
import logging.Logger;
import model.Consumer;
import model.Event;
import model.EventPerformance;
import model.EventType;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.awt.*;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegisterConsumerTest {

    @BeforeEach
    void printTestName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    void clearLogs() {
        Logger.getInstance().clearLog();
        System.out.println("---");
    }

    //================CREATE USERS==================

    void createTestConsumer(Controller controller){
        String name = "Testing McTest";
        String email = "email@gmail.com";
        String phoneNumber = "01234567891011";
        String password = "secure123";
        String paymentAccountEmail = "pay@gmail.com";

        controller.runCommand(new RegisterConsumerCommand(name, email, phoneNumber, password, paymentAccountEmail));
    }

    void createTestProviderBlank(Controller controller){
        String orgName = "";
        String orgAddress = "";
        String paymentAccountEmail = "";
        String mainRepName = "";
        String mainRepEmail = "";
        String password = "";
        List<String> otherRepNames = Collections.emptyList();
        List<String> otherRepEmails = Collections.emptyList();

        controller.runCommand(new RegisterEntertainmentProviderCommand(
                orgName,
                orgAddress,
                paymentAccountEmail,
                mainRepName,
                mainRepEmail,
                password,
                otherRepNames,
                otherRepEmails));
    }

    void createTestProviderONE(Controller controller){
        String orgName = "";
        String orgAddress = "";
        String paymentAccountEmail = "";
        String mainRepName = "";
        String mainRepEmail = "";
        String password = "";
        List<String> otherRepNames = Collections.emptyList();
        List<String> otherRepEmails = Collections.emptyList();

        controller.runCommand(new RegisterEntertainmentProviderCommand(
                orgName,
                orgAddress,
                paymentAccountEmail,
                mainRepName,
                mainRepEmail,
                password,
                otherRepNames,
                otherRepEmails));
    }

    //===========CREATE EVENTS================


    void addEvent1(Controller controller){
        String title = "testing festival";
        EventType type = EventType.Dance;

        CreateEventCommand createEvent = new CreateEventCommand(title, type);
        controller.runCommand(createEvent);

    }

    void addEvent2(Controller controller){
        String title = "testing game";
        EventType type = EventType.Sports;

        CreateEventCommand createEvent = new CreateEventCommand(title, type);
        controller.runCommand(createEvent);

    }

    void addEventEmpty(Controller controller){
        String title = "";
        EventType type = EventType.Movie;

        CreateEventCommand createEvent = new CreateEventCommand(title, type);
        controller.runCommand(createEvent);
    }


    void createEventAndAddTestPerformance(Controller controller){

        String title = "testing game";
        EventType type = EventType.Sports;

        CreateEventCommand createEvent = new CreateEventCommand(title, type);
        controller.runCommand(createEvent);

        long eventNum = createEvent.getResult();
        String venueAddress = "testing blvrd";
        LocalDateTime start = LocalDateTime.now().minusHours(3);
        LocalDateTime end = LocalDateTime.now().minusHours(2);
        List<String> names = Arrays.asList("James", "John", "Jacob");
        boolean hasSocialDistancing = true;
        boolean hasAirFilter = false;
        boolean isOutdoors = false;
        int capacityLim = 20;
        int venueSize = 40;

        AddEventPerformanceCommand addPerf = new AddEventPerformanceCommand(eventNum, venueAddress, start, end, names,hasSocialDistancing, hasAirFilter, isOutdoors, capacityLim, venueSize);
        controller.runCommand(addPerf);
        //return addPerf.getResult();

    }

    //==========CONSUMER LOG IN LOG OUT============
    void logOutConsumer(Controller controller){
        createTestConsumer(controller);
        LogoutCommand logOut = new LogoutCommand();
        controller.runCommand(logOut);
    }

    @Test
    void logInCorrectlyConsumer(Controller controller){
        String email = "email@gmail.com";
        String password = "secure123";
        createTestConsumer(controller);
        LogoutCommand logOut = new LogoutCommand();
        controller.runCommand(logOut);
        LoginCommand logIn = new LoginCommand(email, password);
        controller.runCommand(logIn);
        assertTrue(logIn.getResult() != null);
    }

    void logInWrongEmailConsumer(Controller controller){
        String email = "email@gmail.com";
        String password = "secure123";
        createTestConsumer(controller);
        LogoutCommand logOut = new LogoutCommand();
        controller.runCommand(logOut);
        LoginCommand logIn = new LoginCommand(email, password);
        controller.runCommand(logIn);
    }

    void logInWrongPasswordConsumer(Controller controller){
        String email = "email@gmail.com";
        String password = "wrong123";
        createTestConsumer(controller);
        LogoutCommand logOut = new LogoutCommand();
        controller.runCommand(logOut);
        LoginCommand logIn = new LoginCommand(email, password);
        controller.runCommand(logIn);
    }


    //=========ACTIONS========

    void consumerBookingCorrect(Controller controller){

        addEvent1(controller);
        createTestConsumer(controller);


    }




    void bookWithConsumer(Controller controller, Consumer tester){

    }

    //@Test
    void logInLogOut(){
        Controller controller = new Controller();

        createTestConsumer(controller);
        logOutConsumer(controller);
        logInCorrectlyConsumer(controller);
    }


    //@Test
    void registerConsumerTest(){
        Controller controller = new Controller();

        createTestConsumer(controller);
        logOutConsumer(controller);

        logInCorrectlyConsumer(controller);

        createEventAndAddTestPerformance(controller);

        //assertTrue(perf != null);
        //assertTrue(consumers.stream().anyMatch(consumer -> consumer.getName().equals("John Biggson")));
        //assertTrue(consumers.stream().anyMatch(consumer -> consumer.getName().equals("Jane Giantsdottir")));
    }


}
