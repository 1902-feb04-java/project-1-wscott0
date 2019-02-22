package com.revature.project1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
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

        try( 
            InputStreamReader isr = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(isr);
        )
        {
            System.out.println("please input your employee information: email, username, password( space between each ) ");
            String input = br.readLine();
            Scanner scan = new Scanner(input);

            String email = scan.next();
            String username= scan.next();
            String password =  scan.next();

            System.out.println(email);
            System.out.println(username);
            System.out.println(password);

            


            
        
        }

        catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }
       
        }
    }

