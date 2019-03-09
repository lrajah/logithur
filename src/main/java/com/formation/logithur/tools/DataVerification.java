package com.formation.logithur.tools;

/**
 * Class de vérification des données <b><b> Vient vérifier la bonne mise en forme
 * des différentes données
 * 
 * @author Arzh
 * @version 1.0.0
 */
public class DataVerification {

	/**
	 * Method to verify email format
	 * 
	 * @param email - <b><b>User Email
	 * @return boolean
	 */
	public static boolean checkEmail(String email) {
		
		if (email.length() < 100 ) {

		return email.matches("^[\\w/-]+(?:\\.[\\w/-]+)*@(?:[\\w-]+\\.)+(com|fr|be|de|uk|es|it|eu|net|org)$");
		
		}
		
		return false;
	}

	/**
	 * Method to verify password format
	 * 
	 * @param password - <b><b>User Password
	 * @return boolean
	 */
	public static boolean checkPassword(String password) {
		
		return password.matches("^(?:(?=.+[a-z])(?=.+[A-Z])(?=.+[\\d])(?=.+[;:!?%$£€§&=+*_\\/-]))[A-Za-z\\d;:!?%$£€§&=+*_\\/-]{8,30}$");
	}

	/**
	 * Method to verify nickname format
	 * 
	 * @param nickname - <b><b>User Nickname
	 * @return boolean
	 */
	public static boolean checkNickname(String nickname) {
		
		return nickname.matches("^(?:(?=.*[a-z])|(?=.*[A-Z])(?=.*[\\d]))[A-Za-z\\d]{4,20}$"); 		
	}
}
