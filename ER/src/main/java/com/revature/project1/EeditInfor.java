package com.revature.project1;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class EeditInfor
 */
public class EeditInfor extends HttpServlet {

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
		
		String password = request.getParameter("password");
		String login = request.getParameter("login");
		String email = request.getParameter("email");
		String FN = request.getParameter("FirstName");
		String LN = request.getParameter("LastName");
		PrintWriter out = response.getWriter();
		
		
		String url = "jdbc:postgresql://localhost:5432/postgres";
		String username = "postgres";
		String pass = "password";
		try(Connection connection = DriverManager.getConnection(url, username, pass)){
			 Statement statement = connection.createStatement();
			
			if(password != null &&  !password.isEmpty()) {
			statement.execute("UPDATE ers.employee set password=' "+ password +" 'where id="+ id);
		
			}
			if(login != null &&  !login.isEmpty()) {
				statement.execute("UPDATE ers.employee set login=' "+login+" ' where id="+ id);
			
			}
			if(email != null &&  !email.isEmpty()) {
				statement.execute("UPDATE ers.employee set email=' "+email+"'  where id="+id);
						
				}
			if(FN != null &&  !FN.isEmpty()) {
				statement.execute("UPDATE ers.employee set firstName=' "+FN+" ' where id="+id);
				
			}
			if(LN != null &&  !LN.isEmpty()) {
				statement.execute("UPDATE ers.employee set LastName=' "+LN+" ' where id="+id);
				
			}
//			preparedStatement.setInt(6, id);
//			preparedStatement.executeUpdate();
			 
			
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
