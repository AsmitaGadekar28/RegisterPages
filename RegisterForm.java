package com.RegisterServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/regform")

public class RegisterForm extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String fname = request.getParameter("fname");
		String Lname = request.getParameter("lname");
		String Email = request.getParameter("email");
		String MobNum = request.getParameter("Number");
		String Address = request.getParameter("address");
		String Gender = request.getParameter("gender");
		String DateOfBirth = request.getParameter("DOB");
		String City = request.getParameter("city");
		String State = request.getParameter("state");
		String Country = request.getParameter("country");
		String Age = request.getParameter("age");
		String Degree = request.getParameter("degree");
		String PassingYear = request.getParameter("Passyear");
		String Password = request.getParameter("pass");

		System.out.println(fname);
		System.out.println(Lname);
		System.out.println(Email);
		System.out.println(MobNum);
		System.out.println(Address);
		System.out.println(Gender);
		System.out.println(DateOfBirth);
		System.out.println(City);
		System.out.println(State);
		System.out.println(Country);
		System.out.println(Age);
		System.out.println(Degree);
		System.out.println(PassingYear);
		System.out.println(Password);

		PrintWriter out = response.getWriter();
		out.print(fname);
		out.print(Lname);
		out.print(Email);
		out.print(MobNum);
		out.print(Address);
		out.print(Gender);
		out.print(DateOfBirth);
		out.print(City);
		out.print(State);
		out.print(Country);
		out.print(Age);
		out.print(Degree);
		out.print(PassingYear);
		out.print(Password);

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection c = DriverManager.getConnection("jdbc:mysql://localhost:3306/batch197?useSSL=false", "root",
					"root");
			PreparedStatement ps = c.prepareStatement(
					"insert into register(fname,Lname,Email,MobNum,Address,Gender,DateOfBirth,City,State,Country,Age,Degree,PassingYear,Password) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1, fname);
			ps.setString(2, Lname);
			ps.setString(3, Email);
			ps.setString(4, MobNum);
			ps.setString(5, Address);
			ps.setString(6, Gender);
			ps.setString(7, DateOfBirth);
			ps.setString(8, City);
			ps.setString(9, State);
			ps.setString(10, Country);
			ps.setString(11, Age);
			ps.setString(12, Degree);
			ps.setString(13, PassingYear);
			ps.setString(14, Password);
			ps.executeUpdate();
			System.out.println("Data is inserted Successfully...");
			c.close();
		} catch (Exception e) {
			e.printStackTrace();

		}
	}

}
