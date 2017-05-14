package controllers;

import java.io.IOException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import database.DataBase;
import models.BeanUser;

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
		
		if(request.getAttribute("acces") == "true"){
			request.setAttribute("users", getUsers());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/succes.jsp");
			dispatcher.forward(request, response);
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher("/Login.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataBase DB = null;
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String query = "SELECT COUNT(*) FROM users WHERE username = '"+ user +"' and passwd = '" + pass + "'";
		try {
			DB = new DataBase();
			ResultSet res = DB.executeSQL(query);
			res.next();
			if(res.getInt(1) > 0) {
				request.setAttribute("acces", "true");
			}
			else request.setAttribute("acces", "false");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		doGet(request, response);
	}
	protected List<BeanUser> getUsers(){
		String query = "SELECT * FROM users";
		DataBase DB;
		try {
			DB = new DataBase();
			List<BeanUser> list = new ArrayList<BeanUser>();
			ResultSet users = DB.executeSQL(query);
			while (users.next()){
				BeanUser user = new BeanUser();
				user.setUser(users.getString("username"));
				user.setPass(users.getString("passwd"));
				user.setMail(users.getString("email"));
				user.setBirthD(users.getString("birthday"));
				user.setTeam(users.getString("team"));
				list.add(user);
			}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
		
	}

}
