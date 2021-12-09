package com.playup.service.support;

import static org.junit.jupiter.api.Assertions.*;
import com.playup.constants.ApplicationConstants;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Shiv Gaurang Desai
 */
public class TicketGeneratorServiceTest {
    @Autowired
    SupportTicketGeneratorServiceImpl ticketGeneratorService;
    @Test
    void ticketGeneratorServiceNotNullTest() throws ClassNotFoundException {
        Class<?> classFinder = Class.forName("com.playup.service.support.SupportTicketGeneratorServiceImpl", false, getClass().getClassLoader());
        assertNotNull(classFinder);
    }

    @Test
    void ticketNumberValidTest() {
        int number = ticketGeneratorService.generateTicketNumber(ApplicationConstants.MINIMUM_SUPPORT_TICKET_NUMBER,ApplicationConstants.MAXIMUM_SUPPORT_TICKET_NUMBER);
        assertTrue(number>=1000&&number<=10000);
    }

    @Test
    void ticketNumberNotValidTest() {
        int number = ticketGeneratorService.generateTicketNumber(ApplicationConstants.MINIMUM_SUPPORT_TICKET_NUMBER,ApplicationConstants.MAXIMUM_SUPPORT_TICKET_NUMBER);
        assertFalse(number<1000||number>10000);
    }
}
