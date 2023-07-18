package com.resource;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBResource
{
	static Connection connection = null;
	
	public static Connection createConnection() 
	{
		String username = System.getenv("DBUN");
		String password = System.getenv("DBPW");
		String url = System.getenv("BASEURL") + "fitness_schedule";
		
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
			
		    connection = DriverManager.getConnection(url, username, password);
			System.out.println("Connection created.");
		} 
		catch (Exception e)
		{
			System.out.println(e);
		} 
		
		return connection;
		
	}
	
	public void closeConnection() 
	{
		try 
		{
			final String TAG = getClass().getSimpleName();
			connection.close();
			System.out.println(TAG + "Connection closed with status : " + connection.isClosed());
		} 
		catch (Exception e) 
		{
			System.out.println("Exception occured : " + e);
		}
	}
}