package models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataBase;

public class BeanUserInfo implements Serializable  {

	private static final long serialVersionUID = 1L;

	private int id;
	private String name;
	private String username;
	private String image;
	private String description;
	private String mail;
	private String team;
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
	
	public void addTweet(){
		++this.tweets;
	}
	public void removeTweet() {
		if(this.tweets > 0) --this.tweets;
		
	}
	
	public boolean isfollow(int id1,int id2){
		String query = "select isFollow("+id1+","+id2+")";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet isF = DB.executeSQL(query);
			isF.next();
			boolean bool = isF.getBoolean(1);
			DB.disconnectBD();
			return bool;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	public String getNameById(int id){
		String query = "SELECT logName FROM users where userId="+ id;
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet tweets = DB.executeSQL(query);
			if(tweets.next()){
				name = tweets.getString("logName");
			}
			DB.disconnectBD();
			return name;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	public int getId(String name){
		String query = "SELECT userId FROM users where logName='"+ name +"'";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet tweets = DB.executeSQL(query);
			int id = 0;
			if(tweets.next()){
				id = tweets.getInt("userId");
			}
			DB.disconnectBD();
			return id;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return 0;
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
		String query = "SELECT userId, logName , userName, description, flwedNum, flwingNum, tweetsNum, profileImg, teamName, email  FROM users where userId = "+id+";";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet users = DB.executeSQL(query);
			users.next();
			user.setName(users.getString("userName"));
			user.setUsername(users.getString("logName"));
			user.setDescription(users.getString("description"));
			user.setMail(users.getString("email"));
			user.setTeam(users.getString("teamName"));
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
		String query = "SELECT userId, logName , userName, description, flwedNum, flwingNum, tweetsNum, profileImg, teamName, email  FROM users where logName = '"+name+"';";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet users = DB.executeSQL(query);
			users.next();
			user.setName(users.getString("userName"));
			user.setUsername(users.getString("logName"));
			user.setTeam(users.getString("teamName"));
			user.setMail(users.getString("email"));
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
	
	public void follow(String id1, String id2){
		String query = "call addFollow("+ id1 + "," + id2 +");";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
			++this.following;
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	
	public void unfollow(String id1, String id2){
		String query = "call deleteFollow("+ id1 + "," + id2 +");";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
			--this.following;
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
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
	public String getTeam() {
		return team;
	}
	public void setTeam(String team) {
		this.team = team;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public void updateInfo(int id, String name, String mail, String pass, String image, String description,String team) {
		String query = "call changeUserInfo("+ id + ",'" + name + "','" + pass +"','"+ mail + "','" + description +"','" + image + "','"+ team +"');";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
		
	}
	
	public List<BeanUserInfo> getAllUsersInfo(){
		List<BeanUserInfo> users = new ArrayList<BeanUserInfo>();
		String query = "SELECT userId, logName , userName, teamName, email FROM users;";
		DataBase DB;
		try {
			DB = new DataBase();
			ResultSet u = DB.executeSQL(query);
			while(u.next()){
				BeanUserInfo user = new BeanUserInfo();
				user.setName(u.getString("userName"));
				user.setUsername(u.getString("logName"));
				user.setTeam(u.getString("teamName"));
				user.setMail(u.getString("email"));
				user.setId(u.getInt("userId"));
				users.add(user);
			}
			DB.disconnectBD();
			return users;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public void deleteUser(int userId) {
		String query = "call deleteUser("+ userId +");";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
			
		}catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
}
	