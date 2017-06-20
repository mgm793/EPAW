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
import models.BeanUserInfo;

/**
 * Servlet implementation class ProfileController
 */
@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProfileController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeanTweet tweet = new BeanTweet();
		BeanUserInfo user = new BeanUserInfo();
		List<BeanTweet> tweets = tweet.getOwnTweets(request.getParameter("user"));
		BeanUserInfo info = user.getAllInfoById(Integer.parseInt(request.getParameter("user")));
		request.setAttribute("tweets", tweets);
		request.setAttribute("MVP", tweet.getMVP());
		request.setAttribute("userInfo", info);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Profile.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		if(request.getParameter("type").equals("follow")){
			BeanUserInfo user = new BeanUserInfo();
			user = (BeanUserInfo) request.getSession().getAttribute("user");
			user.setFollowing(user.getFollowing() + 1);
			user.follow(request.getParameter("id1"), request.getParameter("id2"));
		}
		else if(request.getParameter("type").equals("unfollow")){
			BeanUserInfo user = new BeanUserInfo();
			user = (BeanUserInfo) request.getSession().getAttribute("user");
			user.setFollowing(user.getFollowing() - 1);
			user.unfollow(request.getParameter("id1"), request.getParameter("id2"));
		}
		else{
			doGet(request, response);
		}
	}

}
