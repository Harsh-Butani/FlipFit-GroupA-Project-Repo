/**
 * 
 */
package com.flipkart.validator;

import com.flipkart.exception.InvalidAadharException;

/**
 * @author kshitij.gupta1
 */
public class GymOwnerValidation {
	private static Integer aadhar;
	public GymOwnerValidation(Integer aadhar) {
		GymOwnerValidation.aadhar = aadhar;
	}
	
	public static boolean checkAadhar(String aadhar) throws InvalidAadharException {
		int cnt=aadhar.length();
		if(cnt!=12) {
			throw new InvalidAadharException();
		}
		for(int i=0;i<cnt;i++) {
			if(!(aadhar.charAt(i)>='0' && aadhar.charAt(i)<='9')) {
				throw new InvalidAadharException();
			}
		}
		return true;
	}
}
