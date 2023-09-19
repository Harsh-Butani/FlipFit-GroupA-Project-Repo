/**
 * 
 */
package com.flipkart.application;
/**
 * @author kshitij.gupta1
 */
import java.util.Scanner;

import com.flipkart.bean.GymDetails;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.business.GymOwnerServiceInterface;
import com.flipkart.business.GymOwnerServiceOperation;
import com.flipkart.exception.GymAlreadyRegisteredException;
import com.flipkart.exception.UserNotRegisteredException;

/**
 * 
 */
public class GymFlipFitGymOwnerMenu {
	public static void gymOwnerMenu(Scanner in) {
		System.out.println("Do you know your Gym Owner ID? Enter Y for yes and N for no");
		String userChoice = in.next();
		Integer gymOwnerID = null;
		GymOwnerServiceInterface gymOwner = new GymOwnerServiceOperation();
		switch(userChoice) {
			case "Y":
				System.out.println("Enter gym owner ID");
				gymOwnerID = in.nextInt();
				break;
			case "N":
				System.out.println("Enter your email ID");
				String email = in.next();
				gymOwnerID = gymOwner.getGymOwnerID(email);
				break;
			default:
				System.out.println("Enter a valid choice!");
				return;
		}
		while(true) {
			System.out.println("----Gym Owner Menu----");
			System.out.println("Press 1 to register gym");
			System.out.println("Press 2 to view your gyms");
			System.out.println("Press 3 to view profile");
			System.out.println("Press 4 to exit");
			
			int option = in.nextInt();
			switch(option) {
				case 1:
					System.out.println("Enter gym name");
					String gymName = in.next();
					System.out.println("Enter gym address");
					String gymAddress = in.next();
					GymDetails gym = new GymDetails();
					gym.setGymOwnerID(gymOwnerID);
					gym.setGymName(gymName);
					gym.setGymAddress(gymAddress);
					try {
						if(gymOwner.registerGym(gym)) {
							System.out.println("Successfully registered");
						}
					}
					catch(GymAlreadyRegisteredException e) {
						System.out.println("Gym is already registered");
						continue;
					}
					System.out.println("Choose slot from the below menu");
					for (int j = 0; j < 24; j++) {
						int startHour = j % 12;
						int endHour = (j + 1) % 12;
						
						if (startHour == 0) {
							startHour = 12;
						}
						
						if (endHour == 0) {
							endHour = 12;
						}
						
						String slot1 = String.format("Slot %d - %d %s to %d %s", j, startHour, (j < 12 ? "AM" : "PM"), endHour, (j < 11 ? "AM" : "PM"));
						
						System.out.println(slot1);
					}
					System.out.println("Enter number of slots");
					Integer numberOfSlots = in.nextInt();
					System.out.println("Enter maximum seats");
					Integer maxSeats = in.nextInt();
					Integer gymID = gymOwner.fetchGymID(gymOwnerID, gymName, gymAddress);
					for(int i=0;i<numberOfSlots;i++) {
						SlotCatalogDetails slot = new SlotCatalogDetails();
						slot.setAvailableSeats(maxSeats);
						slot.setGymID(gymID);
						slot.setApprovedStatus(0);
						System.out.println("Enter slot number");
						Integer slotNumber = in.nextInt();
						slot.setSlotNumber(slotNumber);
						gymOwner.addSlots(slot);
					}
					break;
				case 2:
					if(!gymOwner.viewMyGyms(gymOwnerID)) {
						System.out.println("No gyms registered yet (Not approved by Admin if registration requests sent)");
					}
					break;
				case 3:
					gymOwner.viewProfile(gymOwnerID);
					break;
				case 4:
					return;
				default:
					System.out.println("Enter a valid option");
					break;
			}
		}
	}
}
