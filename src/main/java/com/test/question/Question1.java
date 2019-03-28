package com.test.question;

public class Question1 {

	/**
	 * check string is null/empty
	 * @param string
	 * @return
	 */
	public boolean isNullOrEmpty(String string){

		if(string == null || string.length() == 0 )
			return true;
		return false;
	}
}
