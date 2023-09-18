package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */

import com.flipkart.dao.CustomerDAOImplementation;
import com.flipkart.dao.CustomerDAOInterface;
import com.flipkart.exception.SlotFullException;
import com.flipkart.exception.SlotNotBookedException;


public class CustomerServiceOperation implements CustomerServiceInterface{
	CustomerDAOInterface dao;

	public CustomerServiceOperation() {
		dao = new CustomerDAOImplementation();
	}

	@Override
	public boolean viewGyms() { // Used to view all registered gyms
		return dao.queryAllGymDB();
	}

	@Override
	public boolean bookSlot(Integer gymID, Integer slotNumber, Integer userID) throws SlotFullException { // Used to book slot at a particular gym and slot number
		if(dao.slotFull(gymID, slotNumber)) {
			throw new SlotFullException(gymID, slotNumber); // If slot is full, then cannot book
		}
		if(dao.queryBookingListDB(userID, slotNumber)) {
			try {
				cancelBookedSlots(slotNumber, userID); // Cancel previous booking for the same slot
			} catch (SlotNotBookedException e) {
				e.printStackTrace();
			}
		}
		dao.decreaseSeatsSlotDB(gymID, slotNumber); // Decrease available seats in the passed gym and slot number
		dao.addBookingListDB(userID, gymID, slotNumber); // Adding booking of user in BookinglistDB
		return true;
	}

	@Override
	public boolean cancelBookedSlots(Integer gymID, Integer slotNumber, Integer userID) throws SlotNotBookedException {
		if(!dao.queryBookingListDB(userID, slotNumber)) {
			throw new SlotNotBookedException(gymID, slotNumber); // Cannot cancel a slot which is not booked
		}
		dao.increaseSeatsSlotDB(gymID, slotNumber); // Increase available seats in the passed gym and slot number
		dao.deleteBookingListDB(userID, slotNumber); // Remove entry of the booking from BookingListDB
		return true;
	}

	@Override
	public boolean cancelBookedSlots(Integer slotNumber, Integer userID) throws SlotNotBookedException {
		Integer oldGymID = dao.queryCancelBookingDB(userID, slotNumber); // Retrieve the old gym ID whose cancellation is to be done
		dao.increaseSeatsSlotDB(oldGymID, slotNumber); // Increase available seats in old gym
		dao.deleteBookingListDB(userID, slotNumber); // Delete entry from BookingListDB
		return true;
	}

	@Override
	public int getUserID(String email, String password, String role) {

		return dao.queryUserDBForID(email,password,role); // Used to retrieve user ID whose email, password and role is given
	}

	@Override
	public boolean viewAllBookings(Integer userID) { // Used to view bookings of the user whose user ID is passed
		return dao.queryBookingListDB(userID);
	}

	@Override
	public void getGymInfo(Integer gymID) { // Used to retrieve gym info of the gym whose ID is passed
		dao.queryGymDB(gymID);
	}

//	@Override
//	public void checkBookingList() {
//		// TODO Auto-generated method stub
//		System.out.println("Checking booking list");
//
//	}

	@Override
	public boolean checkAvailableSlots(Integer gymID) { // Used to check available slots for the given gym
		return dao.querySeatsSlotDB(gymID);
	}
	
	@Override
	public void viewProfile(Integer userID) {
		dao.queryProfileUserDB(userID);
	}
}