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
	
	public int getAcces(String user, String pass){
		if((user != null && user.contains("'")) || (pass != null && pass.contains("'"))) return 0;
		String query = "SELECT * FROM users WHERE username = '"+ user +"' and passwd = '" + pass + "'";
		try {
			DataBase DB = new DataBase();
			ResultSet res = DB.executeSQL(query);
			if(res.next()){		
				if(res.getString("username") != null) {
					if(res.getInt("admin") == 1){
						DB.disconnectBD();
						return 2;
					}
					DB.disconnectBD();
					return 1;
				}
				else{
					DB.disconnectBD();
					return 0;
				}
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return 0;
	}
}
