package models;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.beanutils.BeanUtils;

import database.DataBase;

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
	public String checkUser(DataBase DB, HttpServletRequest request){
		String user = request.getParameter("user");
		String query = "SELECT Count(username) AS c FROM users WHERE username = '" + user  + "';";
		try {
			DB = new DataBase();
			ResultSet res = DB.executeSQL(query);
			res.next();
			if(res.getInt(1) > 0) return "repeat";
			else return "new";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	public String checkMail(DataBase DB, HttpServletRequest request){
		String mail = request.getParameter("mail");
		String query = "SELECT Count(username) AS c FROM users WHERE email = '" + mail  + "';";
		try {
			DB = new DataBase();
			ResultSet res = DB.executeSQL(query);
			res.next();
			if(res.getInt(1) > 0) return "repeat";
			else return "new";
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

	public void registerUser(DataBase DB, HttpServletRequest request){
		BeanUser user = new BeanUser();
		Map<String, String[]> params = new HashMap<>(request.getParameterMap());
		params.remove("register");
		try {
			BeanUtils.populate(user, params);
		} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String usern = user.getUser();
		String mail = user.getMail();
		String password = user.getPass();
		String date = user.getBirthD();
		String team = user.getTeam();
		String query = "INSERT into users VALUES ('" 
						+ usern + "','"+ mail + "','" 
						+ password + "','" + date 
						+ "','" + team + "',NULL);";
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public List<BeanUser> getUsers(){
		String query = "SELECT * FROM users";
		DataBase DB;
		try {
			DB = new DataBase();
			List<BeanUser> list = new ArrayList<BeanUser>();
			ResultSet users = DB.executeSQL(query);
			while (users.next()){
				BeanUser user = new BeanUser();
				user.setUser(users.getString("username"));
				user.setPass(users.getString("passwd"));
				user.setMail(users.getString("email"));
				user.setBirthD(users.getString("birthday"));
				user.setTeam(users.getString("team"));
				list.add(user);
			}
			DB.disconnectBD();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}
	
	public List<String> getTeams(){
		String query = "SELECT DISTINCT team FROM users";
		DataBase DB;
		try {
			DB = new DataBase();
			List<String> list = new ArrayList<String>();
			ResultSet teams = DB.executeSQL(query);
			while (teams.next()){
				list.add(teams.getString("team"));
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

