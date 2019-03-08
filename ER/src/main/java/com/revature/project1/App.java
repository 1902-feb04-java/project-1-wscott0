package com.revature.project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.NoSuchElementException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

        // try( 
        //     InputStreamReader isr = new InputStreamReader(System.in);
        //     BufferedReader br = new BufferedReader(isr);
        // )
        // {
            //takes int the input 
                // System.out.println("please input your employee information: email, username, password( space between each ) ");
                // String input = br.readLine();
            
            //seperates the input 
            // Scanner scan = new Scanner(input);
            // String email = scan.next();
            // String username= scan.next();
            // String password =  scan.next();

            String url = "jdbc:postgresql://localhost:5432/postgres";
		    String username = "postgres";
		    String password= "password";
		    
//inside connection 
//		    String sql = "SET search_path to proj1, public";
//		    statement.execute(sql);
//
//		    sql = "INSERT INTO ers.employee( id, password, login, title, email, firstname, lastname)"  +
//		    		"VALUES (1, 'password', 'login', 'title', 'email@email', 'will', 'scott')";
            try (Connection connection = DriverManager.getConnection(url, username, password)){
                Statement statement = connection.createStatement();
                //ResultSet rs = statement.executeQuery("select * from ers.employee");
    		    
                String sql = "SET search_path to ers, employee";
    		    statement.execute(sql);
//    
//    		    sql = "INSERT INTO ers.employee( id, password, login, title, email, firstname, lastname)"  +
//    		    		"VALUES (3, 'password3', 'login3', 'title3', 'email@emial3', 'will3', 'scott3')";
   		    
                ResultSet rs = statement.executeQuery("select * from ers.employee");
                while(rs.next()){
                    System.out.println(rs.getString("id"));
                	System.out.println(rs.getString("password"));
                    System.out.println(rs.getString("login"));
                    System.out.println(rs.getString("title"));
                    System.out.println(rs.getString("email"));
                    System.out.println(rs.getString("firstname"));
                    System.out.println(rs.getString("lastname"));


                }
                rs.close();
                
            } catch (Exception e) {
                //TODO: handle exception
                e.printStackTrace();
            }
            //testing 
            // System.out.println(email);
            // System.out.println(username);
            // System.out.println(password);

            


            
        
        //}

        // catch (Exception e) {
        //     //TODO: handle exception
        //     e.printStackTrace();
        // }
       
        }
    }

