package com.playup.service;

import com.playup.constants.ApplicationConstants;
import com.playup.dao.SupportDao;
import com.playup.database.DataBaseUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.sql.SQLException;

@Service
public class TicketGeneratorService implements ITicketGenerator  {

    private static TicketGeneratorService instance;

    public static TicketGeneratorService getInstance() {
        if(instance == null) {
            instance = new TicketGeneratorService();
        }
        return instance;
    }

    @Override
    public int generateTicketNumber(int minimumTicketNumber, int maximumTicketNumber) {
        int ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
        try {
            boolean isNumberExits = SupportDao.getInstance().checkWhetherTicketNumberExists(ticketNumber);
            while(isNumberExits) {
                ticketNumber = (int)(Math.random()*(maximumTicketNumber-minimumTicketNumber+1)+minimumTicketNumber);
                isNumberExits = SupportDao.getInstance().checkWhetherTicketNumberExists(ticketNumber);
            }
        }catch(SQLException s) {
            System.out.println(s);
            return -1;
        }
        return ticketNumber;
    }


}