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
	public String getPass2() {
		return pass2;
	}
	
	/*Setters*/
	public void setUser(String user){
		this.user = user;		
	}
	
	public void setMail(String mail){
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
	
	public void setPass2(String pass2) {
		this.pass2 = pass2;
	}

}
