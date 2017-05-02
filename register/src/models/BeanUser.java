package models;

import java.io.Serializable;

public class BeanUser implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String user = "";
	private String mail = "";
	private String pass = "";
	private String team = "";
	private String birthD = "";
	
	/*  Control which parameters have been correctly filled */
	private int[] error = {0,0}; 
	
	/* Getters */
	public String getUser(){
		return user;
	}
	
	public String getMail() {
		return mail;
	}
	
	public int[] getError() {
		return error;
	}
	
	public String getPass() {
		return pass;
	}
	
	public String getTeam() {
		return team;
	}
	
	public String getBirthD() {
		return birthD;
	}
	
	
	/*Setters*/
	public void setUser(String user){
		
		System.out.println("Filling user field");
		/* We simulate a user with the same unsername exists in our DB */
		error[0] = 1;
		
	}
	
	public void setMail(String mail){
		System.out.println("Filling mail field");
		this.mail = mail;
	}
	

	public void setPass(String pass) {
		this.pass = pass;
	}



	public void setTeam(String team) {
		this.team = team;
	}



	public void setBirthD(String birthD) {
		this.birthD = birthD;
	}
	
	/* Logic Functions */
	
	/*Check if all the fields are filled correctly */
	public boolean isComplete() {
	    return(hasValue(getUser()) &&
	           hasValue(getMail()) );
	}
	
	private boolean hasValue(String val) {
		return((val != null) && (!val.equals("")));
	}

}
