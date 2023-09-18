/**
 * 
 */
package com.flipkart.business;


import com.flipkart.bean.GymOwner;
import com.flipkart.bean.User;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDAOInterface;
import com.flipkart.exception.AlreadyRegisteredException;
import com.flipkart.dao.UserDAOImplementation;
import com.flipkart.dao.UserDAOInterface;

/**
 * @author kshitij.gupta1
 */
public class UserServiceOperation implements UserServiceInterface{

	UserDAOInterface userDAO;
	GymOwnerDAOInterface gymOwnerDAO;
	public UserServiceOperation() {
		userDAO = new UserDAOImplementation();
		gymOwnerDAO = new GymOwnerDAOImplementation();
	}
	@Override
	public void registerUser(User user) throws AlreadyRegisteredException { // Used to register the passed user
		if(userDAO.queryUserDB(user)) {
			throw new AlreadyRegisteredException(user.getEmailID(), user.getRole());
		}
		userDAO.insertUserDB(user);
	}
	
	@Override
	public void updateUser(User user, String password) { // Used to update password of given user
		userDAO.updateUserDB(user,password);
	}

	@Override
	public void registerGymOwner(GymOwner gymOwner) { // Used to register given gym owner
		gymOwnerDAO.insertGymOwnerDB(gymOwner);
	}
}
