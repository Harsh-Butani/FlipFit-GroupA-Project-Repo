/**
 * 
 */
package com.flipkart.application;

import java.util.Scanner;
import com.flipkart.business.AdminServiceOperation;
import com.flipkart.business.AdminServiceInterface;

/**
 * @author kshitij.gupta1
 */
public class GymFlipFitAdminMenu {
	public static void adminMenu(Scanner in) {
		AdminServiceInterface admin = new AdminServiceOperation();


		while(true) {
			System.out.println("----Admin Menu----");
			System.out.println("Press 1 for approving gym owner request");
			System.out.println("Press 2 for viewing pending gym owner requests");
			System.out.println("Press 3 for approving gym registration requests");
			System.out.println("Press 4 for viewing pending gym registration requests");
			System.out.println("Press 5 to exit");
			
			int option = in.nextInt();

			switch(option) {
				case 1:
					System.out.println("Do you want to approve all requests? Enter Y for yes N for no");
					String approvalChoice = in.next();
					switch (approvalChoice){
						case "Y":
							admin.approveAllGymOwnerRequest();
							System.out.println("Approved all gym owner requests! \n");
							break;
						case "N":
							System.out.println("Do you have the gym owner id? Enter Y for yes N for no");
							String choice = in.next();
							switch (choice){
								case "N":
									System.out.println("These are the pending requests, choose one to approve\n");
									admin.viewPendingGymOwnerRequests();
									System.out.println("\n");
									System.out.println("Enter GymOwnerID: ");
									int GymOwnerID = in.nextInt();
									if(admin.approveGymOwnerRequest(GymOwnerID)) {

										System.out.println("Approved Gym Owner Request for the provided ID");

									}
									break;
								case "Y":
									System.out.println("Enter GymOwnerID: ");
									int GymOwnerID1 = in.nextInt();
									if(admin.approveGymOwnerRequest(GymOwnerID1)) {

										System.out.println("Approved Gym Owner Request for the provided ID");

									}
									break;
								default:
									System.out.println("Enter a valid choice!");
							}
							break;
						default:
							System.out.println("Enter a valid choice!");
					}



					break;
				case 2:
					if(!admin.viewPendingGymOwnerRequests()){
						System.out.println("No pending gym owner registration requests");
					}
					break;
				case 3:
					System.out.println("Do you want to approve all requests? Enter Y for yes N for no");
					String gymApprovalChoice = in.next();
					switch (gymApprovalChoice){
						case "Y":
							admin.approveAllGymRegistration();
							System.out.println("Approved all gym registration requests! \n");
							break;
						case "N":
							System.out.println("Do you have the gym id? Enter Y for yes N for no");
							String choice = in.next();
							switch (choice){
								case "N":
									boolean isNonEmpty = admin.viewPendingGymRegistrations();
									if(!isNonEmpty) {
										System.out.println("No pending requests");
									}
									System.out.println("\n");
									System.out.println("Enter GymID: ");
									int gymID = in.nextInt();
									if(admin.approveGymRegistration(gymID)) {

										System.out.println("Approved Gym registration Request for the provided ID");

									}
									break;
								case "Y":
									System.out.println("Enter gymID: ");
									int gymID1 = in.nextInt();
									if(admin.approveGymRegistration(gymID1)) {

										System.out.println("Approved Gym registration Request for the provided ID");

									}
									break;
								default:
									System.out.println("Enter a valid choice!");
							}
							break;
						default:
							System.out.println("Enter a valid choice!");
					}
					break;
				case 4:
					if(!admin.viewPendingGymRegistrations()) {
						System.out.println("No pending gym registration requests");
					}
					System.out.println("\n");
					break;
				case 5:
					return;
				default:
					System.out.println("Enter a valid option");
					break;
			}
		}
	}
}
