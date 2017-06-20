package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.BeanTweet;

/**
 * Servlet implementation class TimelineController
 */
@WebServlet("/timeline")
public class TimelineController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TimelineController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeanTweet tweet = new BeanTweet();
		RequestDispatcher dispatcher;
		if(request.getSession().getAttribute("user") != null){
			List<BeanTweet> tweets = tweet.getTweets();
			request.setAttribute("tweets", tweets);
			request.setAttribute("TT", tweet.getTT());
			request.setAttribute("MVP", tweet.getMVP());
			dispatcher = request.getRequestDispatcher("/Time.jsp");
		}
		else{
			dispatcher = request.getRequestDispatcher("/Login.jsp");
		}
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("postBody") != null){
			String text = (String) request.getParameter("postBody");
			int id =  Integer.parseInt(request.getParameter("postId"));
			String hash = request.getParameter("postHash");
			BeanTweet tweet = new BeanTweet();
			tweet.newTweet(text, id, hash);
		}
		else if(request.getParameter("type") != null){
			String userId = request.getParameter("userId");
			String tweetId = request.getParameter("tweetId");
			BeanTweet tweet = new BeanTweet();
			if(request.getParameter("type").equals("addfav")){
				tweet.love(userId, tweetId);
			}
			else if(request.getParameter("type").equals("delfav")){
				tweet.unlove(userId, tweetId);
			}
		}
		doGet(request, response);
	}

}
