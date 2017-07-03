package models;

import java.io.Serializable;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import database.DataBase;

public class BeanComment implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private int id;
	private int tweetId;
	private int userId;
	private String name;
	private String text;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTweetId() {
		return tweetId;
	}
	public void setTweetId(int tweetId) {
		this.tweetId = tweetId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public List<BeanComment> getComments(int tweetId){
		String query = "SELECT * FROM comments where tweetId="+ tweetId +" order by commId desc";
		DataBase DB;
		try {
			DB = new DataBase();
			BeanUserInfo user = new BeanUserInfo();
			List<BeanComment> list = new ArrayList<BeanComment>();
			ResultSet comments = DB.executeSQL(query);
			while (comments.next()){
				BeanComment comment = new BeanComment();
				comment.setId(comments.getInt("commId"));
				comment.setUserId(comments.getInt("userId"));
				comment.setText(comments.getString("commText"));
				comment.setName(user.getNameById(comment.getUserId()));
				list.add(comment);
			}
			DB.disconnectBD();
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}	
		return null;
	}
	public void newComment(String text, int userId, int tweetId){
		String query = "CALL addComment("+userId+","+tweetId+",'"+ text +"');";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);
			DB.disconnectBD();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void delComment(String text, int userId, int tweetId) {
		String query = "CALL deleteComment("+userId+","+tweetId+",'"+ text +"');";
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
