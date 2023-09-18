/**
 * 
 */
package com.flipkart.dao;

import com.flipkart.bean.GymOwner;
import com.flipkart.bean.SlotCatalogDetails;
import com.flipkart.constants.SQLConstants;
import com.flipkart.utils.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * @author kshitij.gupta1
 */
public class GymOwnerDAOImplementation implements GymOwnerDAOInterface{

	@Override
	public void insertGymDB(Integer gymOwnerID, String gymName, String gymAddress) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.INSERT_INTO_GYM_DB);
			stmt.setInt(1, gymOwnerID);
			stmt.setInt(2, 0);
			stmt.setString(3, gymName);
			stmt.setString(4,  gymAddress);
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public boolean queryGymDB(Integer gymOwnerID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.QUERY_GYM_DB_FOR_GYMOWNER);
			stmt.setInt(1, gymOwnerID);
			ResultSet rs = stmt.executeQuery();
			boolean flag = false;
			while(rs.next()) {
				flag = true;
				Integer gymID = rs.getInt("GymID");
			    Integer approvalStatus = rs.getInt("ApprovalStatus");
			    String gymName = rs.getString("gymName");
			    String gymAddress = rs.getString("gymAddress");
			    System.out.println("gymID: " + gymID + " approvalStatus: " + approvalStatus + " gymName: " + gymName + " gymAddress: " + gymAddress);
			}
			return flag;
		} catch(Exception e) {
			System.out.println(e);
			return false;
		}
		
	}
	
	@Override
	public Integer queryGymDB(Integer gymOwnerID, String gymName, String gymAddress) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {
			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.QUERY_GYM_DB_FOR_GYMID);
			stmt.setInt(1, gymOwnerID);
			stmt.setString(2, gymName);
			stmt.setString(3,  gymAddress);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("GymID");
			}
			return 0; // Add exception here
		} catch(Exception e) {
			System.out.println(e);
			return 0; // Exception
		}
	}

	@Override
	public void insertGymOwnerDB(GymOwner gymOwner) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.INSERT_INTO_GYM_OWNER_DB);
			stmt.setString(1,gymOwner.getName());
			stmt.setString(2,gymOwner.getAddress());
			stmt.setString(3,gymOwner.getIDProof());
			stmt.setInt(4,0);
			stmt.setString(5,gymOwner.getEmailID());
			stmt.setString(6, gymOwner.getPassword());
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}

	}
	
	public void insertSlotDB(SlotCatalogDetails slot) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.INSERT_INTO_SLOT_DB);
			stmt.setInt(1, slot.getGymID());
			stmt.setInt(2, slot.getSlotNumber());
			stmt.setInt(3,  slot.getAvailableSeats());
			stmt.setInt(4,  slot.getApprovedStatus());
			stmt.executeUpdate();

		} catch(Exception e) {
			System.out.println(e);
		}
	}

	@Override
	public Integer getIDFromGymOwnerDB(String email) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.QUERY_ID_GYMOWNER_DB);
			stmt.setString(1, email);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				return rs.getInt("GymOwnerID");
			}
			return -1;

		} catch(Exception e) {
			System.out.println(e);
			return -1;
		}
	}
	
	@Override
	public void queryGymOwnerDB(Integer gymOwnerID) {
		Connection conn = null;
		PreparedStatement stmt = null;
		try {

			conn = DatabaseConnector.getConnection();
			stmt = conn.prepareStatement(SQLConstants.QUERY_PROFILE_GYMOWNER_DB);
			stmt.setInt(1, gymOwnerID);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				String email = rs.getString("emailID");
				String address = rs.getString("Address");
				String name = rs.getString("name");
				System.out.println("GymOwnerEmail: " + email + " Name: " + name + 
						" Address: " + address + "GymOwnerID: " + gymOwnerID);
			}

		} catch(Exception e) {
			System.out.println(e);
		}
	}

}
