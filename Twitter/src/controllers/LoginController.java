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

import models.BeanLogin;
import models.BeanTweet;
import models.BeanUser;
import models.BeanUserInfo;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/login")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generatedonstructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeanLogin login = new BeanLogin();
		BeanUserInfo userInfo = new BeanUserInfo();
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String check = request.getParameter("check");
		int acces = login.getAcces(user, pass);
		if(acces != 0){
			HttpSession session = request.getSession();
			session.setAttribute("check", check);
			session.setAttribute("user", userInfo.getAllInfo(user));
			if(acces == 1){
				BeanTweet tweet = new BeanTweet();
				List<BeanTweet> tweets = tweet.getTweets();
				request.setAttribute("tweets", tweets);
				RequestDispatcher dispatcher = request.getRequestDispatcher("/Time.jsp");
				dispatcher.forward(request, response);
			}
			else{
				BeanUser users = new BeanUser();
				session.setAttribute("admin", "1");
				request.setAttribute("users", users.getUsers());
				RequestDispatcher dispatcher = request.getRequestDispatcher("/succes.jsp");
				dispatcher.forward(request, response);
			}
		}
		else{
			if(user != null && pass != null) request.setAttribute("error", "true");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);	
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}
	
}
