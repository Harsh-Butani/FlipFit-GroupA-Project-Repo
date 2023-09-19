/**
 * 
 */
package com.flipkart.validator;

import com.flipkart.exception.WrongEmailFormatException;

/**
 * @author kshitij.gupta1
 */
public class UserValidation {
	private static String email;
	public UserValidation(String email) {
		UserValidation.email = email;
	}
	
	public static boolean checkEmail(String email) throws WrongEmailFormatException {
		int len = email.length();
		int at=-1, dot=-1;
		for(int i=0;i<len;i++) {
			if(email.charAt(i)=='@') {
				if(at!=-1) {
					throw new WrongEmailFormatException(email);
				}
				else {
					at=i;
				}
			}
			if(email.charAt(i)=='.') {
				dot=i;
			}
		}
		if(dot<at || at==-1) {
			throw new WrongEmailFormatException(email);
		}
		return true;
	}
}
