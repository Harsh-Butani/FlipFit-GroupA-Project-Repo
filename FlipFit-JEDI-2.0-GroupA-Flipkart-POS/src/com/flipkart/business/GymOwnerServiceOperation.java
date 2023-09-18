package com.flipkart.business;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.dao.AdminDAOImplementation;
import com.flipkart.dao.AdminDAOInterface;
import com.flipkart.dao.GymOwnerDAOImplementation;
import com.flipkart.dao.GymOwnerDAOInterface;

/**
 * @author kshitij.gupta1
 */
public class GymOwnerServiceOperation implements GymOwnerServiceInterface{

	
	GymOwnerDAOInterface dao;
	public GymOwnerServiceOperation(){
		dao  = new GymOwnerDAOImplementation();
	}
	@Override
	public boolean registerGym(GymDetails gym) { // Used to request registration for the passed gym
		dao.insertGymDB(gym.getGymOwnerID(), gym.getGymName(), gym.getGymAddress());
		return true;
	}

	@Override
	public boolean viewMyGyms(Integer gymOwnerID) { // Used to view gyms of the passed gym owner
		return dao.queryGymDB(gymOwnerID);
	}
	
	public Integer fetchGymID(Integer gymOwnerID, String gymName, String gymAddress) { // Used to fetch gym ID from the passed parameters
		return dao.queryGymDB(gymOwnerID, gymName, gymAddress);
	}
	
	public void addSlots(SlotCatalogDetails slot) { // Used to add slot in the Slot DB
		dao.insertSlotDB(slot);
	}
	
	public Integer getGymOwnerID(String email) { // Used to retrieve gym owner ID from his/her email
		return dao.getIDFromGymOwnerDB(email);
	}
	
	public void viewProfile(Integer gymOwnerID) {
		dao.queryGymOwnerDB(gymOwnerID);
	}
}
