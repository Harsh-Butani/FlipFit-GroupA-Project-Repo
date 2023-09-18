package com.flipkart.application;

/**
 * @author kshitij.gupta1
 */
import java.util.Scanner;
//import java.time.*;
import java.util.Date;

import com.flipkart.bean.GymOwner;
import com.flipkart.business.VerificationServiceOperation;
import com.flipkart.exception.AlreadyRegisteredException;
import com.flipkart.exception.InvalidAadharException;
import com.flipkart.exception.UserNotRegisteredException;
import com.flipkart.exception.WrongEmailFormatException;
import com.flipkart.validator.GymOwnerValidation;
import com.flipkart.validator.UserValidation;
import com.flipkart.bean.User;
import com.flipkart.business.VerificationServiceInterface;
import com.flipkart.business.UserServiceInterface;
import com.flipkart.business.UserServiceOperation;

public class GymFlipFitApplication {

	public static void main(String[] args) throws UserNotRegisteredException {
		// TODO Auto-generated
        System.out.println("Welcome to FlipFit Application for Slot Booking!");
        Scanner in = new Scanner(System.in);
        while(true) {
        	System.out.println("----Menu----");
        	System.out.println("Press 1 for Login");
        	System.out.println("Press 2 for Registration of User");
        	System.out.println("Press 3 for Updating Password");
        	System.out.println("Press 4 to Exit");
        	
        	int option = in.nextInt();
        	boolean flag = false;
        	
			VerificationServiceInterface verifier = new VerificationServiceOperation();
			UserServiceInterface userService = new UserServiceOperation();
        	switch (option) {
        		case 1:
        			User userLogin = new User();
        			System.out.println("Enter emailID");
        			userLogin.setEmailID(in.next());
        			System.out.println("Enter password");
        			userLogin.setPassword(in.next());
        			System.out.println("Enter your role (Customer/GymOwner/Admin)");
        			userLogin.setRole(in.next());
        			
        			try {
	        			if(verifier.verifyCredentials(userLogin)) {
	        				Date currentDate = new Date();
//	        				LocalDate localDate = LocalDate.now();
//	        				LocalTime localTime = LocalTime.now();
//	        				LocalDateTime localDateTime = LocalDateTime.now();
	        				System.out.println("Successfully logged in at " + currentDate);
	        				if(userLogin.getRole().equals("Customer")) {
	            				GymFlipFitCustomerMenu.customerMenu(in);
	            			}
	            			else if(userLogin.getRole().equals("GymOwner")) {
	            				GymFlipFitGymOwnerMenu.gymOwnerMenu(in);
	            			}
	            			else {
	            				GymFlipFitAdminMenu.adminMenu(in);
	            			}
	        			}
	        			else {
	        				System.out.println("Incorrect/Invalid credentials");
	        			}
        			}
        			catch(UserNotRegisteredException e) {
        				System.out.println("User with email ID " + e.getEmail() + " and role " + e.getRole() + " not registered");
        			}
        			break;
        		case 2:
        			User user  = new User();
        			System.out.println("Enter email ID");
					String emailID = in.next();
					try {
						if(!UserValidation.checkEmail(emailID)) {
							continue;
						}
					}
					catch(WrongEmailFormatException e) {
						System.out.println("The email " + e.getEmail() + " doesn't match the correct format. Please retry");
						continue;
					}
        			//user.setEmailID(in.next());
        			System.out.println("Create a password");
					String password = in.next();
        			//user.setPassword(in.next());
        			System.out.println("Enter your role (Customer/GymOwner)");
					String role = in.next();
        			//user.setRole(role);
					switch (role){
						case "GymOwner":
							GymOwner gymOwner = new GymOwner();
							gymOwner.setEmailID(emailID);
							gymOwner.setPassword(password);
							System.out.println("Enter your name");
							gymOwner.setName(in.next());
							System.out.println("Enter your Address");
							gymOwner.setAddress(in.next());
							System.out.println("Enter your IDProof(Aadhar number)");
							gymOwner.setIDProof(in.next());
							try {
								if(!GymOwnerValidation.checkAadhar(gymOwner.getIDProof())) {
									continue;
								}
							}
							catch(InvalidAadharException e) {
								System.out.println("Please enter a valid Aadhar Number of 12 digits");
								continue;
							}
							userService.registerGymOwner(gymOwner);
							break;
						case "Customer":
							user.setEmailID(emailID);
							user.setPassword(password);
							user.setRole(role);
							try {
								userService.registerUser(user);
								System.out.println("Registration complete");
							}
							catch(AlreadyRegisteredException e) {
								System.out.println("User with email ID " + e.getEmail() + " and role " + e.getRole() + " already exists");
							}
							break;
						default:
							System.out.println("Please enter a valid role!");


					}

        			break;
        		case 3:
        			user = new User();
        			System.out.println("Enter emailID");
        			user.setEmailID(in.next());
        			System.out.println("Enter current password");
        			user.setPassword(in.next());
        			System.out.println("Enter your role (Customer/GymOwner/Admin)");
        			user.setRole(in.next());
        			try {
	        			if(verifier.verifyCredentials(user)) {
	        				System.out.println("Enter your new password: ");
	        				String newPassword = in.next();
	        				userService.updateUser(user,newPassword);
	        			}else {
	        				System.out.println("Please enter correct password.");
	        			}
        			}
        			catch(UserNotRegisteredException e) {
        				System.out.println("User with email ID " + e.getEmail() + " and role " + e.getRole() + " not registered");
        			}
        			break;
        		case 4:
        			in.close();
        			flag = true;
        			break;
        		default:
        			System.out.println("Please enter a valid option.");
        			break;
        	}
        	if(flag) {
        		break;
        	}
        }
		
	}
}