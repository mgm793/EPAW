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
import models.BeanUser;

/**
 * Servlet implementation class AppController
 */
@WebServlet("/App")
public class AppController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AppController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		
		if( session.getAttribute("check") != null && !session.getAttribute("check").toString().equalsIgnoreCase("true")){
			session.invalidate();
			request.setAttribute("page", "Home");
		}
		else if (session.getAttribute("user")!=null && session.getAttribute("admin")==null){
			BeanTweet tweet = new BeanTweet();
			List<BeanTweet> tweets = tweet.getTweets();
			request.setAttribute("tweets", tweets);
			request.setAttribute("page", "Time");
		}
		else if(session.getAttribute("admin")!=null){
			BeanUser users = new BeanUser();
			request.setAttribute("users", users.getUsers());
			request.setAttribute("page", "succes");
		}
		else{
			request.setAttribute("page", "Home");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/App.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
