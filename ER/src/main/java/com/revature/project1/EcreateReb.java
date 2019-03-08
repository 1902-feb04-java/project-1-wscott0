package com.revature.project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EcreateReb
 */
public class EcreateReb extends HttpServlet {

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			Class.forName("org.postgresql.Driver");
		} catch (Exception e) {
			e.printStackTrace();
		}
		HttpSession session = request.getSession();
		Integer id = (Integer) session.getAttribute("id");
		int amount = Integer.parseInt(request.getParameter("amount"));
		PrintWriter out = response.getWriter();
		
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String pass = "password";
		try(Connection connection = DriverManager.getConnection(url, username, pass)){
			Statement statement = connection.createStatement();
				
				String sql = "INSERT INTO ers.reinbursmentRequest(Id_employee_requester,reinburse_amount ) " +
	                    "VALUES ( "+id+","+amount+")";
				
				statement.executeUpdate(sql);
				
			 
			out.println("<p> Created a new Reinburments!  </p> ");
			out.println("<a href='http://localhost:8080/ER/employee.html'><button>Return to Employee Page</button></a>");
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
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
