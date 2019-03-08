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
import javax.servlet.http.HttpSession;

public class ManagerDBView extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

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

			String sql = "SET search_path to ers, reinbursmentRequest";
			statement.execute(sql);

			ResultSet rs = statement.executeQuery("select * from ers.reinbursmentRequest");
			while (rs.next()) {
				out.print(("<p>Reinbursment ID: ")+(rs.getString( "reinburse_id")+ "</p>"));
				out.println(("<p>Reinbursment Employee ID: ")+(rs.getString( "Id_employee_requester")+ "</p>"));
				out.println(("<p>Reinbursment Amount $: ")+(rs.getString( "reinburse_amount")+ "</p>"));
				out.println(("<p>Reinbursment Pending: ")+(rs.getString( "reinburse_Request_Pending")+ "</p>"));
				out.println(("<p>Reinbursment Complete: ")+(rs.getString( "reinburse_Complete")+ "</p>"));
				out.println(("<p>Reinbursment Approved: ")+(rs.getString( "reinbure_Approved")+ "</p>"));
				out.println(("<p>Reinbursment Completed by Manager ID: ")+(rs.getString( "Completed_By")+ "</p>"));
				out.println("<p>----------------------------------------------------------------</p>");

			}
			rs.close();
			out.println("<a href='http://localhost:8080/ER/new.html'><button>Return to manager Page</button></a>");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}