package models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import database.DataBase;

public class BeanTweet implements Serializable  {

	private static final long serialVersionUID = 1L;

	private int id;
	private int userId;
	private String text;
	private String date;
	private int retweets;
	private int comments;
	private int loves;
	private int isretweet;
	private BeanUserInfo userInfo;

	protected String niceDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		SimpleDateFormat month_date = new SimpleDateFormat("MMM");
		String month_name = month_date.format(cal.getTime());
		return String.valueOf(dayOfMonth) + " " + month_name;
	}
	
	public void newTweet(String body, int userId){
		String query = "insert into tweets (userId, tweetText) values ('"+userId+"','"+ body +"');";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public List<BeanTweet> getOwnTweets(String id) {
		String query = "SELECT * FROM tweets where userId='"+ id +"' order by tweetId desc";
		DataBase DB;
		try {
			DB = new DataBase();
			List<BeanTweet> list = new ArrayList<BeanTweet>();
			userInfo = new BeanUserInfo(); 
			ResultSet tweets = DB.executeSQL(query);
			while (tweets.next()){
				BeanTweet tweet = new BeanTweet();
				tweet.setDate(tweet.niceDate(tweets.getDate("createDate")));
				tweet.setId(tweets.getInt("tweetId"));
				tweet.setUserId(tweets.getInt("userId"));
				tweet.setText(tweets.getString("tweetText"));
				tweet.setRetweets(tweets.getInt("retNum"));
				tweet.setLoves(tweets.getInt("loveNum"));
				tweet.setComments(tweets.getInt("commNum"));
				tweet.setIsretweet(tweets.getInt("isRetweet"));
				tweet.setUserInfo(userInfo.getBasicInfo(tweet.getUserId()));
				list.add(tweet);
			}
			DB.disconnectBD();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	
	public List<BeanTweet> getTweets(){
		String query = "SELECT * FROM tweets order by tweetId desc";
		DataBase DB;
		try {
			DB = new DataBase();
			List<BeanTweet> list = new ArrayList<BeanTweet>();
			userInfo = new BeanUserInfo(); 
			ResultSet tweets = DB.executeSQL(query);
			while (tweets.next()){
				BeanTweet tweet = new BeanTweet();
				tweet.setDate(tweet.niceDate(tweets.getDate("createDate")));
				tweet.setId(tweets.getInt("tweetId"));
				tweet.setUserId(tweets.getInt("userId"));
				tweet.setText(tweets.getString("tweetText"));
				tweet.setRetweets(tweets.getInt("retNum"));
				tweet.setLoves(tweets.getInt("loveNum"));
				tweet.setComments(tweets.getInt("commNum"));
				tweet.setIsretweet(tweets.getInt("isRetweet"));
				tweet.setUserInfo(userInfo.getBasicInfo(tweet.getUserId()));
				list.add(tweet);
			}
			DB.disconnectBD();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getText() {
		return text;
	}


	public void setText(String text) {
		this.text = text;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public int getRetweets() {
		return retweets;
	}


	public void setRetweets(int retweets) {
		this.retweets = retweets;
	}


	public int getLoves() {
		return loves;
	}


	public void setLoves(int loves) {
		this.loves = loves;
	}


	public int getIsretweet() {
		return isretweet;
	}


	public void setIsretweet(int isretweet) {
		this.isretweet = isretweet;
	}


	public BeanUserInfo getUserInfo() {
		return userInfo;
	}


	public void setUserInfo(BeanUserInfo userInfo) {
		this.userInfo = userInfo;
	}


	public int getComments() {
		return comments;
	}


	public void setComments(int comments) {
		this.comments = comments;
	}


}
	