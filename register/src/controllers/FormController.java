package controllers;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.beanutils.BeanUtils;


import database.DataBase;
import models.BeanUser;

/**
 * Servlet implementation class FormController
 */
@WebServlet("/FormController")
public class FormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		if (request.getParameter("register") != null) {
			request.setAttribute("users", getUsers());
			RequestDispatcher dispatcher = request.getRequestDispatcher("/succes.jsp");
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/Register.jsp");
			dispatcher.forward(request, response);
		}  
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		DataBase DB;
		if (request.getParameter("register") != null) {
			BeanUser user = new BeanUser();
			Map<String, String[]> params = new HashMap<>(request.getParameterMap());
			params.remove("register");
			try {
				BeanUtils.populate(user, params);
			} catch (IllegalAccessException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			String usern = user.getUser();
			String mail = user.getMail();
			String password = user.getPass();
			String date = user.getBirthD();
			String team = user.getTeam();
			String query = "INSERT into users VALUES ('" + usern + "','"+ mail + "','" + password + "','" + date + "','" + team + "');";
			try {
				DB = new DataBase();
				DB.insertSQL(query);	
			}catch (Exception e) {
				e.printStackTrace();
			}
		}
		// else if(request.getAttribute("checkUser") != null){
		// 	String user = request.getParameter("username");
		// 	String query = "";
		// 	try {
		// 		DB = new DataBase();
		// 		DB.insertSQL(query);	
		// 	}catch (Exception e) {
		// 		e.printStackTrace();
		// 	}
			
		// }
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
