package com.playup.service.email;

import com.playup.constants.ApplicationConstants;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Shiv Gaurang Desai
 */

@Service
public class EmailValidationServiceImpl implements IEmailValidationService {
    private static EmailValidationServiceImpl emailValidationServiceInstance;

    private EmailValidationServiceImpl(){}

    public static EmailValidationServiceImpl getInstance () {
        if(emailValidationServiceInstance==null) {
            emailValidationServiceInstance = new EmailValidationServiceImpl();
            return emailValidationServiceInstance;
        }
        return emailValidationServiceInstance;
    }

    @Override
    public boolean isEmailValid(String email) {
        boolean isSpecialCharacterPresent = false;
        Pattern p = Pattern.compile(ApplicationConstants.EMAIL_REGEX, Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(email);
        isSpecialCharacterPresent = m.find();
        return isSpecialCharacterPresent;
    }
}
