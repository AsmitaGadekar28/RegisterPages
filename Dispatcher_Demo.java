package com.dispatcher;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/submit")
public class Dispatcher_Demo extends HttpServlet
{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	String email=req.getParameter("email");//(.dot)is know is static method
    	String pass=req.getParameter("pass");
    	
    	System.out.println(email);
    	System.out.println(pass);
    	
    	if(email.equals("asmitag9232@gmail.com")&& pass.equals("asmita@123"))
    	{
    		System.out.println("Login Successfully...");
    		PrintWriter out=resp.getWriter();
    		out.print("Login Successfully...");
    		RequestDispatcher rd= req.getRequestDispatcher("/Profile_Dispatcher.jsp");
    		rd.forward(req, resp);
    	}else
    	{
    		System.out.println("Username and password did not match...");
    		PrintWriter out=resp.getWriter();
    		out.print("Username and password did not match...");
    		RequestDispatcher rd= req.getRequestDispatcher("/index_Dispatcher.html");
    		rd.forward(req, resp);
    	}
    	
    }
}
