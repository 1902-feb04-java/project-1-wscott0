package com.revature.project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ManagerDeny
 */
public class ManagerDeny extends HttpServlet {
	

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
		int Mid = Integer.parseInt(request.getParameter("ManagerID"));
		int id = Integer.parseInt(request.getParameter("employeeID"));
		int Rid = Integer.parseInt(request.getParameter("ReinbursementID"));
		

		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String pass = "password";
		try(Connection connection = DriverManager.getConnection(url, username, pass);
				PreparedStatement preparedStatement = connection
						.prepareStatement("UPDATE ers.reinbursmentRequest set reinburse_Request_Pending =?, reinburse_Complete =?, reinbure_Approved=?, Completed_By=? where Id_employee_requester=? AND reinburse_id=?  ");) {

			
			preparedStatement.setBoolean(1,false);
			preparedStatement.setBoolean(2, true);
			preparedStatement.setBoolean(3, false);
			preparedStatement.setInt(4, Mid);
			preparedStatement.setInt(5, id);
			preparedStatement.setInt(6, Rid);
			preparedStatement.executeUpdate();
			
			out.println("<p> updated Reinburments! to Denied! </p> ");
			out.println("<a href='http://localhost:8080/ER/new.html'><button>Return to manager Page</button></a>");
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
