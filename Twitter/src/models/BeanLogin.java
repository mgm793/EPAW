package models;
import java.io.Serializable;
import java.sql.ResultSet;


import database.DataBase;

public class BeanLogin implements Serializable {

	private static final long serialVersionUID = 1L;
	private String user = "";
	private String pass = "";
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
	public boolean getAcces(String user, String pass){
		String query = "SELECT COUNT(*) FROM users WHERE username = '"+ user +"' and passwd = '" + pass + "'";
		try {
			DataBase DB = new DataBase();
			ResultSet res = DB.executeSQL(query);
			res.next();
			if(res.getInt(1) > 0) {
				return true;
			}
			else return false;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
