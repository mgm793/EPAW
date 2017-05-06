package models;

import java.io.Serializable;

public class BeanUser implements Serializable  {

	private static final long serialVersionUID = 1L;

	private String user = "";
	private String mail = "";
	private String pass = "";
	private String pass2 = "";
	private String team = "";
	private String birthD = "";
	
	
	/* Getters */
	public String getUser(){
		return user;
	}
	
	public String getMail() {
		return mail;
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
		this.user = user;
		System.out.println("Filling user field");
		
	}
	
	public void setMail(String mail){
		System.out.println("Filling mail field");
		this.mail = mail;
	}
	

	public void setPass(String pass) {
		System.out.println("Filling PASS field");
		this.pass = pass;
	}



	public void setTeam(String team) {
		System.out.println("Filling Team field");
		this.team = team;
	}



	public void setBirthD(String birthD) {
		this.birthD = birthD;
		System.out.println("Filling BirthD field");
	}
	


	public String getPass2() {
		return pass2;
	}

	public void setPass2(String pass2) {
		this.pass2 = pass2;
		System.out.println("Filling PASS2 field");
	}

}
