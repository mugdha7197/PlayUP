package com.playup.service.user;

/**
 * @author Mugdha Anil Agharkar
 */

public class UserProfileServiceFactory extends UserProfileServiceAbstractFactory {
    private static UserProfileServiceFactory instance = null;
    private IUserLoginService userLoginService;
    private IOneTimePasswordService oneTimePasswordService;
    private IUserRegistrationService userRegistrationService;

    private UserProfileServiceFactory() {}

    public static UserProfileServiceFactory instance() {
        if (instance == null) {
            instance = new UserProfileServiceFactory();
        }
        return instance;
    }

    @Override
    public IUserLoginService userLoginService() {
        if(userLoginService == null) {
            userLoginService = new UserLoginServiceImpl();
        }
        return userLoginService;
    }

    @Override
    public IOneTimePasswordService oneTimePasswordService() {
        if(oneTimePasswordService == null) {
            oneTimePasswordService = new OneTimePasswordServiceImpl();
        }
        return oneTimePasswordService;
    }

    @Override
    public IUserRegistrationService userRegistrationService() {
        if(userRegistrationService == null) {
            userRegistrationService = new UserRegistrationServiceImpl();
        }
        return userRegistrationService;
    }
}
