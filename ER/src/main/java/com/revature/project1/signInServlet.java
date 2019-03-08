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

public class signInServlet extends HttpServlet {
	@Override
	public void init() {
		System.out.println("Starting up");
	}
	
	

		
	
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
            Class.forName("org.postgresql.Driver");
        }catch (Exception e)
        {
            e.printStackTrace();
        }
		
		
		HttpSession session = request.getSession();
//		String user = (String) session.getAttribute("user");
		String user = request.getParameter("user");
		String password = request.getParameter("password");
		session.setAttribute("user", user);
		session.setAttribute("password", password);
		PrintWriter out = response.getWriter();
		
		 String url = "jdbc:postgresql://localhost:5432/postgres";
		    String username = "postgres";
		    String pass= "password";
		try (Connection connection = DriverManager.getConnection(url, username, pass)){
	        Statement statement = connection.createStatement();
	       
	        String sql = "SET search_path to ers, employee";
		    statement.execute(sql);
		    
		    ResultSet rs = statement.executeQuery("select * from ers.employee");
            while(rs.next()){
//                System.out.println(rs.getString("id"));
//            	System.out.println(rs.getString("password"));
//                System.out.println(rs.getString("login"));
//                System.out.println(rs.getString("title"));
//                System.out.println(rs.getString("email"));
//                System.out.println(rs.getString("firstname"));
//                System.out.println(rs.getString("lastname"));


           if (user.equals(rs.getString("login")) && password.equals(rs.getString("password"))) {
			request.getRequestDispatcher("employee.html").forward(request, response);

		}
            } 
          sql = "SET search_path to ers, manager";
		    statement.execute(sql);
		    
		 rs = statement.executeQuery("select * from ers.manager");
           while(rs.next()){
//               System.out.println(rs.getString("id"));
//           	   System.out.println(rs.getString("password"));
//               System.out.println(rs.getString("login"));
//               System.out.println(rs.getString("title"));
//               System.out.println(rs.getString("email"));
//               System.out.println(rs.getString("firstname"));
//               System.out.println(rs.getString("lastname"));
               
		if (user.equals(rs.getString("login")) && password.equals(rs.getString("password"))) {
			request.getRequestDispatcher("new.html").forward(request, response);
			
		}}
			//response.sendRedirect("http://localhost:8080/ER/");
			
//			out.println("<h1>Hello there, " + user + "</h1>");
//			out.println("<a href='logout'>Logout</a>");
			out.println("<h1> That ain't it chief, Try again</h1>");
			out.println("<a href='http://localhost:8080/ER/'>Return to signIn Page</a>");
			out.close();
		
             
           
   			
   			
   		
            rs.close();
		}catch(Exception e) {
	        //TODO: handle exception
	        e.printStackTrace();
	    }
	
		}
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	@Override
	public void destroy() {
		System.out.println("Shutting down");
	}
}