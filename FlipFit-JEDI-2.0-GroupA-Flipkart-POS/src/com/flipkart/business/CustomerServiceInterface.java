/**
 *
 */
package com.flipkart.business;

import com.flipkart.exception.SlotFullException;
import com.flipkart.exception.SlotNotBookedException;

/**
 * @author kshitij.gupta1
 */
public interface CustomerServiceInterface {
	/**
	 * Method for customer to view all gyms
	 * @return boolean value based on whether any gyms exist
	 */
	public boolean viewGyms();



	/**
	 * Method for customer to book a slot, in case a user has already booked a gym at the same slot, the previous slot is cancelled
	 * @param gymID	ID of the gym
	 * @param slotNumber slotnumber of new booking
	 * @param userID ID of the user
	 * @throws SlotFullException
	 * @throws SlotNotBookedException
	 */
	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID) throws SlotFullException, SlotNotBookedException;



	/**
	 * Method for customer to cancel a booked slot
	 * @param gymID ID of the gym
	 * @param slotNumber slotnumber of new booking
	 * @param userID ID of the user
	 * @throws SlotNotBookedException
	 */
	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID) throws SlotNotBookedException;



	/**
	 * Method for customer to view all of their bookings
	 * @param userID ID of the user
	 */
	public boolean viewAllBookings(Integer userID);



	/**
	 * Method for customer to get the details of a particular gym
	 * @param gymID ID of the gym
	 */
	public void getGymInfo(Integer gymID);


	/**
	 * Method for customer to check available slots of a particular gym
	 * @param gymID ID of the gym
	 */
	public boolean checkAvailableSlots(Integer gymID);



	/**
	 * Method for customer to cancel a booked slot
	 * @param slotNumber slotnumber of new booking
	 * @param userID ID of the user
	 * @throws SlotNotBookedException
	 */
	public boolean cancelBookedSlots(Integer slotNumber, Integer userID) throws SlotNotBookedException;


	/**
	 * Method for customer to get their userID from their email, password and role
	 * @param email emailID of the customer
	 * @param password password of customer
	 * @param role role of customer
	 * @throws SlotNotBookedException
	 */
	public int getUserID(String email, String password, String role);
	
	/**
	 * Method for customer to view their profile
	 * @param userID userID of the customer
	 * @throws SlotNotBookedException
	 */
	public void viewProfile(Integer userID);

}