import command.*;
import controller.Controller;
import logging.Logger;
import model.*;
import org.junit.jupiter.api.*;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class TestUserState {
    @BeforeEach
    void printTestName(TestInfo testInfo) {
        System.out.println(testInfo.getDisplayName());
    }

    @AfterEach
    void clearLogs() {
        Logger.getInstance().clearLog();
        System.out.println("---");
    }

    private static void createCinemaProviderWith3Events(Controller controller) {
        controller.runCommand(new RegisterEntertainmentProviderCommand(
                "Cinema Conglomerate",
                "Global Office, International Space Station",
                "$$$@there'sNoEmailValidation.wahey!",
                "Mrs Representative",
                "odeon@cineworld.com",
                "F!ghT th3 R@Pture",
                List.of("Dr Strangelove"),
                List.of("we_dont_get_involved@cineworld.com")
        ));

        CreateTicketedEventCommand eventCmd1 = new CreateTicketedEventCommand(
                "The LEGO Movie",
                EventType.Movie,
                50,
                15.75//,
                //false
        );
        controller.runCommand(eventCmd1);
        long eventNumber1 = eventCmd1.getResult();
        controller.runCommand(new AddEventPerformanceCommand(
                eventNumber1,
                "You know how much it hurts when you step on a Lego piece?!?!",
                LocalDateTime.now().minusWeeks(1),
                LocalDateTime.now().minusWeeks(1).plusHours(2),
                Collections.emptyList(),
                false,
                true,
                false,
                50,
                50
        ));

        CreateTicketedEventCommand eventCmd2 = new CreateTicketedEventCommand(
                "Frozen Ballet",
                EventType.Dance,
                50,
                35
                //, true
        );
        controller.runCommand(eventCmd2);
        long eventNumber2 = eventCmd2.getResult();
        controller.runCommand(new AddEventPerformanceCommand(
                eventNumber2,
                "Odeon cinema",
                LocalDateTime.now().plusWeeks(1).plusDays(2).plusHours(3),
                LocalDateTime.now().plusWeeks(1).plusDays(2).plusHours(6),
                Collections.emptyList(),
                false,
                true,
                false,
                50,
                50
        ));

        CreateNonTicketedEventCommand eventCmd3 = new CreateNonTicketedEventCommand(
                "The Shining at the Meadows (Free Screening) (Live Action)",
                EventType.Sports
        );
        controller.runCommand(eventCmd3);
        long eventNumber3 = eventCmd3.getResult();
        controller.runCommand(new AddEventPerformanceCommand(
                eventNumber3,
                "The Meadows, Edinburgh",
                LocalDateTime.now(),
                LocalDateTime.now().plusYears(1),
                List.of("You"),
                false,
                false,
                true,
                1000,
                9999
        ));

        controller.runCommand(new LogoutCommand());
    }

}
