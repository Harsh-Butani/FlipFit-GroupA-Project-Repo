/**
 *
 */

package com.flipkart.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

/**
 * @author kshitij.gupta1
 */
public class CustomerDAOImplementation implements CustomerDAOInterface {

	@Override
	public boolean queryAllGymDB() { // Used to Query all the approved gyms by Customer
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_GYMS_QUERY);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()){
				if(!flag) {
					System.out.printf("%-15s %-15s %-15s%n", "Gym ID", "Gym Name", "Gym Address");
				}
				flag = true;
				String gymID = rs.getString("gymID");
				String gymName = rs.getString("gymName");
				String gymAddress = rs.getString("gymAddress");
				System.out.printf("  %-15s %-15s %-15s%n", gymID, gymName, gymAddress);
			}
			return flag;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber) { //Used to Query Booking List to Fetch all the Bookings of User
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_CUSTOMER_BOOKING_LIST_DB_QUERY);
			stmt.setInt(1, UserID);
			stmt.setInt(2, slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Integer queryCancelBookingDB(Integer UserID, Integer slotNumber) { //Used to Query Booking DB to fetch bookings for cancellation
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_CUSTOMER_BOOKING_LIST_DB_QUERY);
			stmt.setInt(1, UserID);
			stmt.setInt(2, slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt("gymID");
			}
			return -1;
		} catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}

	@Override
	public Integer queryUserDBForID(String email, String password, String role) { //Used to query the User DB to fetch user ID if User doesn't know
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.QUERY_USER_DB_FOR_USERID);
			stmt.setString(1,email);
			stmt.setString(2,password);
			stmt.setString(3,role);


			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return rs.getInt("UserID");
			}
			return -1;
		} catch(Exception e) {
			System.out.println(e);
			return -1;
		}

	}

	@Override
	public void decreaseSeatsSlotDB(Integer gymID, Integer slotNumber) { //Decrease Seats in the Slot Db for particular Gym and its Slot
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();

			stmt = conn.prepareStatement(SQLConstants.VIEW_AVAILABLE_SEATS_FROM_SLOT_FOR_DECREASE);
			stmt.setInt(1,gymID);
			stmt.setInt(2,slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Integer currentSeats = rs.getInt("availableSeats");
				currentSeats--;
				stmt = conn.prepareStatement(SQLConstants.DECREASE_AVAILABLE_SEATS_FROM_SLOT);
				stmt.setInt(1,currentSeats);
				stmt.setInt(2,gymID);
				stmt.setInt(3,slotNumber);
				stmt.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println("Inside catch of decreaseSeats()");
			System.out.println(e);
		}
	}

	@Override
	public void addBookingListDB(Integer userID, Integer gymID, Integer slotNumber) { //Add Booking to Booking DB
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.ADD_BOOKING_TO_CUSTOMER_BOOKINGLIST);
			stmt.setInt(1,userID);
			stmt.setInt(2,gymID);
			stmt.setInt(3,slotNumber);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void increaseSeatsSlotDB(Integer gymID, Integer slotNumber) { //Increase Slots of a gym's slot after cancellation
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_AVAILABLE_SEATS_FROM_SLOT_FOR_INCREASE);
			stmt.setInt(1,gymID);
			stmt.setInt(2,slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				Integer currentSeats = rs.getInt("availableSeats");
				currentSeats++;
				stmt = conn.prepareStatement(SQLConstants.INCREASE_AVAILABLE_SEATS_FROM_SLOT);
				stmt.setInt(1,currentSeats);
				stmt.setInt(2,gymID);
				stmt.setInt(3,slotNumber);
				stmt.executeUpdate();
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public void deleteBookingListDB(Integer userID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.DELETE_BOOKING_FROM_BOOKINGLIST);
			stmt.setInt(1,userID);
			stmt.setInt(2, slotNumber);
			stmt.executeUpdate();
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean queryBookingListDB(Integer userID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_BOOKINGS_OF_A_USER);
			stmt.setInt(1,userID);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()){
				if(!flag) {
					System.out.printf("%-15s %-15s %-15s %-15s%n", "User ID", "Gym ID", "Slot Number", "Slot Timings");
				}
				flag = true;
				Integer ruserID = rs.getInt("userID");
				String gymID = rs.getString("gymID");
//				String slotNumber = rs.getString("slotNumber");
				Integer slotNumber = rs.getInt("slotNumber");
				Integer startHour = slotNumber%12;
				Integer endHour = (slotNumber+1)%12;
				String AMPMStart = (slotNumber < 12 ? "AM" : "PM");
				String AMPMEnd = (slotNumber < 11 ? "AM" : "PM");
				String timing = Integer.toString(startHour) + " " + AMPMStart + " - " + Integer.toString(endHour) + " " + AMPMEnd;
				System.out.printf("  %-15s %-15s %-15s %-15s%n", ruserID, gymID, slotNumber, timing);
			}
			return flag;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public void queryGymDB(Integer gymID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_INFO_OF_A_PARTICULAR_GYM);
			stmt.setInt(1,gymID);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				String gymName = rs.getString("gymName");
				String gymAddress = rs.getString("gymAddress");
				System.out.println("Gym Name: " + gymName);
				System.out.println("Gym Address: " + gymAddress);
			}else{
				System.out.println("No approved/registered gym with given gym ID");
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean querySeatsSlotDB(Integer gymID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_AVAILABLE_SLOTS_OF_A_PARTICULAR_GYM);
			stmt.setInt(1,gymID);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()){
				if(!flag) {
					System.out.printf("%-15s %-15s %-15s%n", "Slot Number", "Slot Timings", "Available Seats");
				}
				flag = true;
				Integer slotNumber = rs.getInt("slotNumber");
				Integer availableSeats = rs.getInt("availableSeats");
				Integer startHour = slotNumber%12;
				Integer endHour = (slotNumber+1)%12;
				String AMPMStart = (slotNumber < 12 ? "AM" : "PM");
				String AMPMEnd = (slotNumber < 11 ? "AM" : "PM");
				String timing = Integer.toString(startHour) + " " + AMPMStart + " - " + Integer.toString(endHour) + " " + AMPMEnd;
				System.out.printf("   %-15s %-15s %-15s%n", slotNumber, timing, availableSeats);
			}
			return flag;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}

	@Override
	public Boolean queryBookingListDB(Integer UserID, Integer slotNumber, Integer gymID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_BOOKING_OF_A_USER_FOR_CANCELLATION);
			stmt.setInt(1,UserID);
			stmt.setInt(2,slotNumber);
			stmt.setInt(3,gymID);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return true;
			}
			return false;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override 
	public Boolean slotFull(Integer gymID, Integer slotNumber) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.CHECK_SEATS_AVAILABLE_FOR_GIVEN_GYM_AND_SLOT);
			stmt.setInt(1,gymID);
			stmt.setInt(2,slotNumber);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				return false;
			}
			return true;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
	}
	
	@Override
	public void queryProfileUserDB(Integer userID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.QUERY_PROFILE_USER_DB);
			stmt.setInt(1,userID);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				String email = rs.getString("email");
				String role = rs.getString("role");
				System.out.println("User ID: " + userID);
				System.out.println("Email: " + email);
				System.out.println("Role: " + role);
			}
		} catch(Exception e) {
			System.out.println(e);
		}
	}


}