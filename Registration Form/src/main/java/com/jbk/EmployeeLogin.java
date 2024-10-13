package com.jbk;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/emplogin")
public class EmployeeLogin extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email=req.getParameter("name1");
		String password=req.getParameter("pass1");
		
		PrintWriter out=resp.getWriter();
		
	try
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection c=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo1184","root","suraj");
	    String query="select * from users where email=? and password=?";
	    PreparedStatement ps=c.prepareStatement(query);
	    ps.setString(1, email);
	    ps.setString(2, password);
	    
	    ResultSet rs=ps.executeQuery();
	    if(rs.next())
	    	out.println("successfully login");
	    else
	    	out.println("filds did not match Try Again");
	}
	    catch(Exception e)
	{
	    	e.printStackTrace();
	}
	    
	
	}
	
}
