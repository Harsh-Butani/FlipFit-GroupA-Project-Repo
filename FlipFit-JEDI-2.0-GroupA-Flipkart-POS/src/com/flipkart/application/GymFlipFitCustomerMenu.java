/**
 * 
 */
package com.flipkart.application;
/**
 * @author kshitij.gupta1
 */
import java.util.Scanner;

import com.flipkart.bean.User;
import com.flipkart.business.CustomerServiceInterface;
import com.flipkart.business.CustomerServiceOperation;
import com.flipkart.business.VerificationServiceInterface;
import com.flipkart.business.VerificationServiceOperation;
import com.flipkart.exception.SlotFullException;
import com.flipkart.exception.SlotNotBookedException;
import com.flipkart.exception.UserNotRegisteredException;

/**
 * 
 */
public class GymFlipFitCustomerMenu {
	public static void customerMenu(Scanner in) {

		CustomerServiceInterface customer = new CustomerServiceOperation();
		System.out.println("Do you know your UserID? Enter Y for yes and N for no");
		String userChoice = in.next();
		Integer UserID = null;
		VerificationServiceInterface verifier = new VerificationServiceOperation();
		User userLogin = new User();
		switch (userChoice){
			case "Y":
				UserID = in.nextInt();
				break;
			case "N":
				System.out.println("Enter your email:");
				String email = in.next();
				userLogin.setEmailID(email);
				System.out.println("Enter your password:");
				String password = in.next();
				userLogin.setPassword(password);
				userLogin.setRole("Customer");
				try {
					if(verifier.verifyCredentials(userLogin)) {
						UserID = customer.getUserID(email,password,"Customer");
					}
					else {
						System.out.println("Incorrect/Invalid credentials");
						return;
					}
				}
				catch(UserNotRegisteredException e) {
					System.out.println("User with email ID " + e.getEmail() + " and role " + e.getRole() + " not registered");
				}

				break;
			default:
				System.out.println("Enter a valid choice!");

		}

		
		while(true) {
			System.out.println("----Customer Menu----");
			System.out.println("Press 1 to view gyms");
			System.out.println("Press 2 to book slot");
			System.out.println("Press 3 to cancel booked slots");
			System.out.println("Press 4 to view all bookings");
			System.out.println("Press 5 to view gym info");
			System.out.println("Press 6 to check available slots");
			System.out.println("Press 7 to check profile");
			System.out.println("Press 8 to exit");
			
			int option = in.nextInt();
			switch(option) {
				case 1:
					if(!customer.viewGyms()) {
						System.out.println("No gyms currently available");
					}
					break;
				case 2:
					System.out.println("Enter gym ID");
					Integer gymID = in.nextInt();
					System.out.println("Enter slot number");
					Integer slotnumber = in.nextInt();
					try {
						customer.bookSlot(gymID, slotnumber, UserID);
					}
					catch(SlotFullException e) {
						System.out.println("Gym with ID " + e.getGymID() + " and slot number " + e.getSlotNumber() + " has no available seats");
					}
					catch(SlotNotBookedException e) {
						System.out.println("Gym with ID " + e.getGymID() + " and slot number " + e.getSlotNumber() + " wasn't booked");
					}
					break;
				case 3:
					System.out.println("Enter gym ID");
					gymID = in.nextInt();
					System.out.println("Enter slot number");
					slotnumber = in.nextInt();
					try {
						customer.cancelBookedSlots(gymID, slotnumber, UserID);
					}
					catch(SlotNotBookedException e) {
						System.out.println("Gym with ID " + e.getGymID() + " and slot number " + e.getSlotNumber() + " wasn't booked");
					}
					break;
				case 4:
					if(!customer.viewAllBookings(UserID)) {
						System.out.println("You have no bookings");
					}
					break;
				case 5:
					System.out.println("Enter Gym ID: ");
					gymID = in.nextInt();
					customer.getGymInfo(gymID);
					break;
				case 6:
					System.out.println("Enter Gym ID: ");
					gymID = in.nextInt();
					if(!customer.checkAvailableSlots(gymID)) {
						System.out.println("No slots available");
					}
					break;
				case 7:
					customer.viewProfile(UserID);
					break;
				case 8:
					return;
				default:
					System.out.println("Enter a valid option");
					break;
			}
		}
	}
}
