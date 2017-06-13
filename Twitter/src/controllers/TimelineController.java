package controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
		List<BeanTweet> tweets = tweet.getTweets();
		request.setAttribute("tweets", tweets);
		if(request.getSession().getAttribute("user") != null){
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
			BeanTweet tweet = new BeanTweet();
			tweet.newTweet(text, id);
		}
		doGet(request, response);
	}

}
