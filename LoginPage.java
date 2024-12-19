package com.RegisterServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Loginform")
public class LoginPage extends HttpServlet
{
   @Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	   String Email = req.getParameter("email");
	   String Password = req.getParameter("pass");
	   try {
		   Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197?useSSL=false", "root",
					"root");
			PreparedStatement ps = c.prepareStatement("select * from register email=? and passwoed=?");
			ps.setString(1, Email);	
			ps.setString(2, Password);		
            ResultSet rs=ps.executeQuery();
            if(rs.next()) {
            	System.out.println("Login Successfully....");
            	PrintWriter out=resp.getWriter();
            	out.print("Login Successfully....");
            	}else {
            	System.out.println("Username and password does not match....");
            }
	} catch (Exception e) {
		
	}
}

}
