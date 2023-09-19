/**
 * 
 */
package com.flipkart.business;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.exception.GymAlreadyRegisteredException;
import com.flipkart.exception.SlotNotBookedException;

import java.util.ArrayList;

/**
 * @author kshitij.gupta1
 */
public interface GymOwnerServiceInterface {
	/**
	 * Method for GymOwner to register a new gym
	 * @param gym Details of the new gym
	 * @throws Throws an exception if gym is already registered
	 */
	public boolean registerGym(GymDetails gym) throws GymAlreadyRegisteredException;

	/**
	 * Method for GymOwner to view their gyms
	 * @param gymOwnerID ID of the gymOwner
	 */
	public ArrayList<GymDetails> viewMyGyms(Integer gymOwnerID);

	/**
	 * Method for GymOwner to fetch their GymID given the GymOwnerID and gym details
	 * @param gymOwnerID ID of gymowner
	 * @param gymName Name of gym whose ID is to be fetched
	 * @param gymAddress Address of gym whose name is to be fetched
	 */
	public Integer fetchGymID(Integer gymOwnerID, String gymName, String gymAddress);

	/**
	 * Method for GymOwner to add slots
	 * @param slot Details of slot to be added
	 */
	public void addSlots(SlotCatalogDetails slot);

	/**
	 * Method for GymOwner to fetch their GymOwnerID
	 * @param email emailID of GymOwner
	 */
	public Integer getGymOwnerID(String email);
	
	/**
	 * Method for GymOwner to fetch their profile
	 * @param gymOwnerID gymOwnerID of GymOwner
	 */
	public void viewProfile(Integer gymOwnerID);
}
