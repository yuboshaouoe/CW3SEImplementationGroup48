import command.RegisterConsumerCommand;
import controller.Context;
import controller.Controller;
import logging.Logger;
import model.*;
import model.Event;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.TestInfo;

import command.*;
import controller.Controller;
import logging.Logger;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

import java.awt.*;
import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserEventCreationTest {


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

            System.out.println("creating consumer");
            RegisterConsumerCommand regCon = new RegisterConsumerCommand(name, email, phoneNumber, password, paymentAccountEmail);
            controller.runCommand(regCon);
        }

        void createTestEvent(Controller controller){



        }

        @Test
        void testUserCreation(){
            Controller controller = new Controller();

            String name = "Testing McTest";
            String email = "email@gmail.com";
            String phoneNumber = "01234567891011";
            String password = "secure123";
            String paymentAccountEmail = "pay@gmail.com";

            System.out.println("creating consumer");
            RegisterConsumerCommand regCon = new RegisterConsumerCommand(name, email, phoneNumber, password, paymentAccountEmail);
            controller.runCommand(regCon);

            String title = "testing festival";
            EventType type = EventType.Dance;

            CreateEventCommand createEvent = new CreateEventCommand(title, type);
            controller.runCommand(createEvent);

            Consumer test = regCon.getResult();
            

            assertTrue(test != null);
            //assertTrue(newEv != null);
        }


}
