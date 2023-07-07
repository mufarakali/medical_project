	package com.java.conn;

	import java.sql.Connection;
	import java.sql.DriverManager;

	public class Cont {

		private static Connection con;
		
		public Cont()
		{
			try
			{
				Class.forName("com.mysql.jdbc.Driver");
				con=DriverManager.getConnection("jdbc:mysql://localhost:3306/medical","root","Y1012Jqkhkp");
				
				
			}
			catch(Exception e)
			{
				
				System.out.println(e.getMessage());
			}
			
		}
		
		public static Connection getCont()
		{
			Cont c=new Cont();
			return con;
		}
		
	}


