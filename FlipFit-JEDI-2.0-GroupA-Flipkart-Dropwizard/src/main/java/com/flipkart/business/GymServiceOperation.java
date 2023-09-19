package com.flipkart.business;
/**
 * @author kshitij.gupta1
 */
public class GymServiceOperation implements GymServiceInterface{

	@Override
	public void getGymInfo() {
		System.out.println("No gym info available");
	}

	@Override
	public void checkBookingList() {
		System.out.println("Checking booking list");
		
	}

	@Override
	public void checkAvailableSlots() {
		System.out.println("No gym, no slots");
	}

}
