package com.Planon;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class StudentDetails
 */
@WebServlet("/UserDetails")
public class UserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	 	Connection con;
	    Statement stmt;
		String firstName,middleName,lastName,gender,dob,email,address,phoneNo,subject;
		String dburl = "jdbc:sqlserver://localhost:1433;databaseName=HelloWorld;user=sa;password=1234";
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
//	       out.print("welcome to StudentDetails servlet from signup.jsp");
	       try{
	    	   firstName = request.getParameter("firstName");
	    	   middleName = request.getParameter("middleName");
	    	   lastName = request.getParameter("lastName");
	    	   gender = request.getParameter("gender");
	    	   dob = request.getParameter("dob");
	    	   email = request.getParameter("email");
	    	   address = request.getParameter("address");
	    	   phoneNo = request.getParameter("phoneNo");
	    	   subject = request.getParameter("subject");
//	    	   out.println(phoneNo);
//	    	   com.microsoft.sqlserver.jdbc.SQLServerDriver
	    	   Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
	    	   con = DriverManager.getConnection(dburl);
	    	   stmt = con.createStatement();
	    	   String query = "insert into UserDetails(FirstName,MiddleName,LastName,Gender,DateOfBirth,Email,Address,PhoneNumber,Subject) values('"+firstName+"','"+middleName+"','"+lastName+"','"+gender+"','"+dob+"','"+email+"','"+address+"','"+phoneNo+"','"+subject+"')";
	    	   stmt.execute(query);
	    	   out.print("interested successfully");
	    	   
	       }
	       catch(Exception e) {
	    	   e.printStackTrace();
	       }
		
	}

	

}
