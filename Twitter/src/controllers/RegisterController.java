package controllers;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.DataBase;
import models.BeanUser;

/**
 * Servlet implementation class RegisterController
 */
@WebServlet("/register")
public class RegisterController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegisterController() {
    	super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		BeanUser user = new BeanUser();
		DataBase DB = null;
		if (request.getParameter("register") != null) {
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
			dispatcher.forward(request, response);
		}
		else if(request.getParameter("checkUser") != null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(user.checkUser(DB,request));		
		}
		else if(request.getParameter("checkMail") != null){
			response.setContentType("text/html;charset=UTF-8");
			response.getWriter().print(user.checkMail(DB,request));		
		}
		else{
			request.setAttribute("teams", user.getTeams());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
			dispatcher.forward(request, response);
		}  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataBase DB = null;
		BeanUser user = new BeanUser();
		if (request.getParameter("register") != null) {
			user.registerUser(DB,request);
		}
		doGet(request, response);

	}
}
	
	
