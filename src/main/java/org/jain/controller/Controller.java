package org.jain.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	private  String url="jdbc:mysql://localhost:3306/managment";
	private  String password="Payal@j9067";
	private  String username="root";
	
	
	@GetMapping("/username")                             //creating endpoint /username that can be accessed as http://localhost:8080/username
	public String username()
	{
		try 
		{
			Connection con=DriverManager.getConnection(url,username,password);
			Statement stmt=con.createStatement();
			ResultSet rs=stmt.executeQuery("select username from login where password='"+123+"'");
			if(rs.next())
			{
				return "UserName: "+rs.getString("username");
			}
			return "UserName not found with mentioned password..!";
		} 
		catch (SQLException e) 
		{
			return "Got error while establishing connection with db..!"+e.getMessage();
		}
	}
}
