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
	private boolean isLove;
	private boolean isRetweet;
	private boolean isComment;
	private BeanUserInfo userInfo;

	protected String niceDate(Date date){
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		int dayOfMonth = cal.get(Calendar.DAY_OF_MONTH);
		SimpleDateFormat month_date = new SimpleDateFormat("MMM");
		String month_name = month_date.format(cal.getTime());
		return String.valueOf(dayOfMonth) + " " + month_name;
	}
	
	public void love(String userId, String tweetId){
		String query = "CALL addLike("+userId+","+tweetId+");";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void unlove(String userId, String tweetId){
		String query = "CALL deleteLike("+userId+","+tweetId+");";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void newTweet(String body, int userId, String hash){
		String query = "CALL addTweet('"+userId+"','"+ body +"',0);";
		String query1 = "Select tweetId from tweets where userId =" + userId + " order by tweetId desc";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			ResultSet tweet = DB.executeSQL(query1);
			tweet.next();
			int id = tweet.getInt("tweetId");
			if(hash != "null"){
				String htags[]  = hash.split(",");
				for(int i = 0; i < htags.length; ++i){
					System.out.println(htags[i]);
					String query2 = "CALL addHashtag("+id+",'"+htags[i]+"');";
					DB.insertSQL(query2);
				}
			}
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
				DataBase DB1 = new DataBase();
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
				String query1 = "SELECT isLike(" + tweets.getInt("userId") + "," + tweets.getInt("tweetId") + ");" ;
				ResultSet isLike = DB1.executeSQL(query1);
				isLike.next();
				tweet.setIsLove(isLike.getBoolean(1));
//				String query2 = "SELECT isRetweet(" + tweets.getInt("userId") + "," + tweets.getInt("tweetId") + ");" ;
//				ResultSet isRet = DB1.executeSQL(query2);
//				isRet.next();
//				tweet.setRetweet(isLike.getBoolean(1));
				String query3 = "SELECT isComment(" + tweets.getInt("userId") + "," + tweets.getInt("tweetId") + ");" ;
				ResultSet isRep = DB1.executeSQL(query3);
				isRep.next();
				tweet.setIsComment(isRep.getBoolean(1));
				DB1.disconnectBD();
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

	public List<String> getTT() {
		String query = "CALL mostUsedHashtags();";
		DataBase DB;
		List<String> HashTT = new ArrayList<String>();
		try {
			DB = new DataBase();
			ResultSet TT = DB.executeSQL(query);
			while(TT.next()){
				HashTT.add(TT.getString("hashText"));
			}
			DB.disconnectBD();
			return HashTT;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	public List<String> getMVP() {
		String query = "CALL mostFollowedUsers();";
		DataBase DB;
		List<String> HashTT = new ArrayList<String>();
		try {
			DB = new DataBase();
			ResultSet TT = DB.executeSQL(query);
			while(TT.next()){
				if(!TT.getString("userName").equals("admin"))
					HashTT.add(TT.getString("userName"));
			}
			DB.disconnectBD();
			return HashTT;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean getIsLove() {
		return isLove;
	}

	public void setIsLove(boolean b) {
		this.isLove = b;
	}

	public boolean getIsComment() {
		return isComment;
	}
	
	public void setIsComment(boolean b){
		this.isComment = b;
	}

	public void setComment(boolean isComment) {
		this.isComment = isComment;
	}

	public boolean isRetweet() {
		return isRetweet;
	}

	public void setRetweet(boolean isRetweet) {
		this.isRetweet = isRetweet;
	}

}
	