package controllers;

import java.io.IOException;
//import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import database.DataBase;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("FUNKA");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String user = request.getParameter("username");
		String mail = request.getParameter("mail");
		String password = request.getParameter("pass1");
		String date = request.getParameter("birthday");
		String team = request.getParameter("team");
		String query = "INSERT into users VALUES ('" + user + "','"+ mail + "','" + password + "','" + date + "','" + team + "');";
		DataBase DB;
		try {
			DB = new DataBase();
			DB.insertSQL(query);	
		}catch (Exception e) {
			e.printStackTrace();
			
		}
		doGet(request, response);
	}

}
