package com.revature.project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeDBview
 */
public class EmployeeDBview extends HttpServlet {

       
  
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


		PrintWriter out = response.getWriter();

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String pass = "password";
		try (Connection connection = DriverManager.getConnection(url, username, pass)) {
			Statement statement = connection.createStatement();

			String sql = "SET search_path to ers, employee";
			statement.execute(sql);

			ResultSet rs = statement.executeQuery("select * from ers.employee");
			while (rs.next()) {
				out.print(("<p>Employee ID: ")+(rs.getString( "id")+ "</p>"));
				out.println(("<p>Employee Login: ")+(rs.getString( "login")+ "</p>"));
				out.println(("<p>Employee Title: ")+(rs.getString( "title")+ "</p>"));
				out.println(("<p>Employee Email: ")+(rs.getString( "email")+ "</p>"));
				out.println(("<p>Employee First Name: ")+(rs.getString( "firstName")+ "</p>"));
				out.println(("<p>Employee Last Name: ")+(rs.getString( "LastName")+ "</p>"));
				out.println("<p>----------------------------------------------------------------</p>");

			}
			rs.close();
			out.println("<a href='http://localhost:8080/ER/new.html'><button>Return to manager Page</button></a>");
		} catch (Exception e) {
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
