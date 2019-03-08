package com.revature.project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


public class CreateReb extends HttpServlet {
	
	
	String url = "jdbc:postgresql://localhost:5432/postgres";
    String username = "postgres";
    String pass= "password";
	
	public int create(int employeeId, int amount ) {
		try (Connection connection = DriverManager.getConnection(url, username, pass);
				PreparedStatement preparedStatement = connection
						.prepareStatement("INSERT INTO ers.reinbursmentRequest (amount, Id_employee_requester ) VALUES (?, ?)");) {
			if (amount <= 0) {
				return -1;
			}
			preparedStatement.setInt(1, amount);
			preparedStatement.setInt(2, employeeId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			return -1;
		}
		return 0;
	}
		
		//CreateReb cr = new CreateReb();
		
	//public void canCreateReimbursmentRequests() {
	//assertEquals(cr.create(15.34, 3), 0);
//}
		
		
		
	
	
}