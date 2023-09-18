package com.flipkart.business;

import com.flipkart.bean.User;
import com.flipkart.dao.UserDAOImplementation;
import com.flipkart.dao.UserDAOInterface;
import com.flipkart.exception.UserNotRegisteredException;

/**
 * @author kshitij.gupta1
 */
public class VerificationServiceOperation implements VerificationServiceInterface{
	UserDAOInterface userDAO = new UserDAOImplementation();
	public VerificationServiceOperation(){
		userDAO = new UserDAOImplementation();
	}
	@Override
	public boolean verifyCredentials(User user) throws UserNotRegisteredException { // Used to verify credentials
		if(!userDAO.queryUserDB(user)) {
			throw new UserNotRegisteredException(user.getEmailID(), user.getRole());
		}
		return userDAO.queryDetailsUserDB(user);
	}

}