package models;

import java.io.Serializable;
import java.sql.ResultSet;

import database.DataBase;

public class BeanUserInfo implements Serializable  {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String username;
	private String image;
	private String description;
	private int tweets;
	private int followers;
	private int following;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	public BeanUserInfo getBasicInfo(int id){
		BeanUserInfo user = new BeanUserInfo();
		String query = "SELECT userId, logName , userName, profileImg  FROM users where userId = '"+id+"';";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet users = DB.executeSQL(query);
			users.next();
			user.setName(users.getString("userName"));
			user.setUsername(users.getString("logName"));
			user.setId(id);
			user.setImage(users.getString("profileImg"));
			DB.disconnectBD();
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	public BeanUserInfo getAllInfoById(int id) {
		BeanUserInfo user = new BeanUserInfo();
		String query = "SELECT userId, logName , userName, description, flwedNum, flwingNum, tweetsNum, profileImg  FROM users where userId = "+id+";";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet users = DB.executeSQL(query);
			users.next();
			user.setName(users.getString("userName"));
			user.setUsername(users.getString("logName"));
			user.setDescription(users.getString("description"));
			user.setFollowers(users.getInt("flwedNum"));
			user.setFollowing(users.getInt("flwingNum"));
			user.setId(users.getInt("userId"));
			user.setTweets(users.getInt("tweetsNum"));
			user.setImage(users.getString("profileImg"));
			DB.disconnectBD();
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	public BeanUserInfo getAllInfo(String name){
		BeanUserInfo user = new BeanUserInfo();
		String query = "SELECT userId, logName , userName, description, flwedNum, flwingNum, tweetsNum, profileImg  FROM users where logName = '"+name+"';";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet users = DB.executeSQL(query);
			users.next();
			user.setName(users.getString("userName"));
			user.setUsername(users.getString("logName"));
			user.setDescription(users.getString("description"));
			user.setFollowers(users.getInt("flwedNum"));
			user.setFollowing(users.getInt("flwingNum"));
			user.setId(users.getInt("userId"));
			user.setTweets(users.getInt("tweetsNum"));
			user.setImage(users.getString("profileImg"));
			DB.disconnectBD();
			return user;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	public int getTweets() {
		return tweets;
	}
	public void setTweets(int tweets) {
		this.tweets = tweets;
	}
	public int getFollowers() {
		return followers;
	}
	public void setFollowers(int followers) {
		this.followers = followers;
	}
	public int getFollowing() {
		return following;
	}
	public void setFollowing(int following) {
		this.following = following;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String profileImg) {
		this.image = profileImg;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public BeanUserInfo getAllInfoById(String parameter) {
		// TODO Auto-generated method stub
		return null;
	}
}
	