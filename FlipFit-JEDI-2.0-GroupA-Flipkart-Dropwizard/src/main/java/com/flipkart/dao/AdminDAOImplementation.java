/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

import java.rmi.server.RemoteRef;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author kshitij.gupta1
 */
public class AdminDAOImplementation implements AdminDAOInterface{

	@Override
	public void approveGymOwnerDB(Integer gymOwnerID) { // Used to set approval status to true for the given gym owner in GymOwnerDB and insert them in User DB
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_GYM_OWNER_QUERY);
			stmt.setInt(1, gymOwnerID);
			stmt.executeUpdate();
			stmt = conn.prepareStatement(SQLConstants.FETCH_GYM_OWNER_DETAILS_JUST_APPROVED);
			stmt.setInt(1,gymOwnerID);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String emailID = rs.getString("emailID");
				String password = rs.getString("password");
				stmt = conn.prepareStatement(SQLConstants.INSERT_APPROVED_GYM_OWNERS_TO_USER_DB);
				stmt.setString(1,emailID);
				stmt.setString(2,password);
				stmt.setString(3, "GymOwner");
				stmt.executeUpdate();
			}




		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void approveAllGymOwnerDB() { // Used to set approval status to true for all gym owners (in GymOwnerDB) whose approval status is false and insert them in UserDB
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.FETCH_PENDING_GYM_OWNERS_FOR_USER_DB_INSERTION);
			ResultSet rs = stmt.executeQuery();
			while(rs.next()){
				String emailID = rs.getString("emailID");
				String password = rs.getString("password");
				stmt = conn.prepareStatement(SQLConstants.INSERT_APPROVED_GYM_OWNERS_TO_USER_DB);
				stmt.setString(1,emailID);
				stmt.setString(2,password);
				stmt.setString(3, "GymOwner");
				stmt.executeUpdate();
			}
			stmt = conn.prepareStatement(SQLConstants.APPROVE_ALL_PENDING_GYM_OWNER_QUERY);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public int queryGymOwnerDB() { //Used to Query the GymOwner DB by Admin to fetch the pending approval requests
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			int count = 0;
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_PENDING_GYM_OWNER_REQUEST_QUERY);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()){
				if(!flag) {
					System.out.println("These are the pending requests, choose one to approve\n");
				}
				count++;
				flag = true;
				String gymOwnerID = rs.getString("GymOwnerID");
				String gymOwnerName = rs.getString("name");
				String gymOwnerAddress = rs.getString("address");
				System.out.println("GymOwnerID: " + gymOwnerID + ", GymOwnerName: " + gymOwnerName + ", gymOwnerAddress: " + gymOwnerAddress);
			}
			return count;
		} catch(Exception e) {
			System.out.println(e);
			return -1;
		}
		
	}

	@Override
	public void approveGymDB(Integer gymID) { //Used to approve the Gym registration followed by auto approval of Slots
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_GYM_REGISTRATION_QUERY);
			stmt.setInt(1, gymID);
			stmt.executeUpdate();

			stmt = conn.prepareStatement(SQLConstants.APPROVE_SLOTS_OF_APPROVED_GYM);
			stmt.setInt(1,gymID);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
		
	}

	@Override
	public void approveAllGymDB() { // Used to approve all pending Gym requests in one go, followed by auto approval of Slots
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.APPROVE_ALL_PENDING_GYM_REGISTRATION_QUERY);
			stmt.executeUpdate();

			stmt = conn.prepareStatement(SQLConstants.APPROVE_ALL_SLOTS_OF_APPROVED_GYM);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}

	}

	@Override
	public boolean queryGymDB() { //Used to Query the Gym DB by Admin to fetch All pending Gym Registration requests
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.VIEW_ALL_PENDING_GYM_REGISTRATION_REQUEST_QUERY);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
				while (rs.next()) {
					if(!flag) {
						System.out.println("These are the pending requests, choose one to approve\n");
					}
					flag = true;
					String gymID = rs.getString("GymID");
					String gymOwnerID = rs.getString("GymOwnerID");
					String gymName = rs.getString("gymName");
					String gymAddress = rs.getString("gymAddress");
					System.out.println("GymID: " + gymID + ", GymOwnerID: " + gymOwnerID + ", GymName: " + gymName + ", GymAddress: " + gymAddress);
				}
				return flag;

		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}

}
