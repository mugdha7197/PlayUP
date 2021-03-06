package com.playup.dao.user;

import com.playup.model.user.IUser;

/**
 * @author Mugdha Anil Agharkar
 */

public interface IUserDao {
    IUser getUserByUserEmail(String email);

    boolean addNewUser(IUser user);

    boolean isUserAlreadyRegistered(IUser user);

    boolean updatePasswordAfterReset(IUser user);
}
