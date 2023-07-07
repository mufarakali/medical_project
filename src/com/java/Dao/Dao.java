package com.java.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import com.java.conn.Cont;
import com.java.model.Employee;
import com.java.model.Medicine;

public class Dao {

	PreparedStatement pr;
	ResultSet rs;
	Connection con;
	Scanner sc,sc1;
	
	public Dao()
	{
		con=Cont.getCont();
		sc=new Scanner(System.in);
		sc1=new Scanner(System.in);
	}
	
	public boolean addEmp(Employee e) {
		try 
		{
			pr=con.prepareStatement("insert into Employee (name,username,password) values(?,?,?)");
			pr.setString(1, e.getName());
			pr.setString(2, e.getUsername());
			pr.setString(3, e.getPass());
			pr.executeUpdate();
			
			return true;
			
		} 
		catch (Exception e2)
		{
			System.out.println(e2.getMessage());
			return false;
		}
		
		
	}

	public boolean removeEmp(Employee e) {
		try
		{
			pr=con.prepareStatement("select name from Employee");
			rs=pr.executeQuery();
			boolean f=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(e.getName()))
				{
					f=true;
					pr=con.prepareStatement("delete from Employee where name=?");
					pr.setString(1, e.getName());
					pr.executeUpdate();
					
				}
			}
			
			return f;
		}
		catch (Exception e1) {
			System.out.println(e1.getMessage());
			return false;
		}
	}

	public void showEmp() {
		
		try
		{
			pr=con.prepareStatement("select * from Employee");
			rs=pr.executeQuery();
			
			while(rs.next())
			{
				System.out.print("Name: "+rs.getString(1));
				System.out.print(" | User Name: "+rs.getString(2));
				System.out.print(" | Password: "+rs.getString(3));
				System.out.println();
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}

	public boolean empLogin(Employee e) 
	{

		try
		{
			boolean f=false;
			pr=con.prepareStatement("select username from Employee");
			rs=pr.executeQuery();
			boolean flag=false;
			while(rs.next())
			{
				if(e.getUsername().equals(rs.getString(1)))
				{
					flag=true;
					pr=con.prepareStatement("select password from Employee where username=?");
					pr.setString(1, e.getUsername());
					rs=pr.executeQuery();
					
					while(rs.next())
					{
						if(e.getPass().equals(rs.getString(1)))
						{
							f=true;
							
						}
					}
					if(f==false)
					{
						System.out.println("Incorrect Password");
					}
					
				}
			}
			if(flag==false)
			{
				System.out.println("Incorrect Username");
			}
			return f;
		}
		catch(Exception e2)
		{
			System.out.println(e2.getMessage());
			return false;
			
		}
		
	}

	public boolean addMedDetails(Medicine m) {
	
		try
		{
			pr=con.prepareStatement("insert into medicine (name,price,qty) values (?,?,?)");
			pr.setString(1, m.getName());
			pr.setDouble(2, m.getPrice());
			pr.setInt(3, m.getQty());
			
			pr.executeUpdate();
			return true;
		}

		catch (Exception e) 
		{
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean showAllMed() {
		
		try
		{
			pr=con.prepareStatement("select * from medicine");
			rs=pr.executeQuery();
			while(rs.next())
			{
				System.out.print("Name: "+rs.getString(1));
				System.out.print(" | Price : "+rs.getDouble(2));
				System.out.print(" | Quantity : "+rs.getInt(3));
				System.out.println();
			}
			return true;
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
			return false;
		}
	}

	public boolean removeMed(Medicine m) {

		try
		{
			pr=con.prepareStatement("select name from medicine");
			rs=pr.executeQuery();
			boolean f=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(m.getName()))
				{
					f=true;
					pr=con.prepareStatement("delete from medicine where name=?");
					pr.setString(1, m.getName());
					
					pr.executeUpdate();
					
				}
			}
			if(f==false)
			{
				System.out.println("Record not found..Try Again");
			}
			return f;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean updateName(Medicine m) {
		try
		{
			pr=con.prepareStatement("select name from medicine");
			rs=pr.executeQuery();
			boolean f=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(m.getName()))
				{
					f=true;
					System.out.println("Enter new Name for medicine");
					String nm=sc1.nextLine();
					pr=con.prepareStatement("update medicine set name=? where name=?");
					pr.setString(1, nm);
					pr.setString(2, m.getName());
					
					pr.executeUpdate();
					
					System.out.println("Name successfully changed from '"+m.getName()+"' to '"+nm+"'");
					
				}
			}
			
			return f;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean updatePrice(Medicine m) {
		try
		{
			pr=con.prepareStatement("select name from medicine");
			rs=pr.executeQuery();
			boolean f=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(m.getName()))
				{
					f=true;
					System.out.println("Enter new Price");
					Double p=sc.nextDouble();
					pr=con.prepareStatement("update medicine set price=? where name=?");
					pr.setDouble(1, p);
					pr.setString(2, m.getName());
					
					pr.executeUpdate();
					
				}
			}
			
			return f;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean updateStock(Medicine m) {
		try
		{
			pr=con.prepareStatement("select name from medicine");
			rs=pr.executeQuery();
			boolean f=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(m.getName()))
				{
					f=true;
					System.out.println("Enter quantity ");
					int q=sc.nextInt();
					pr=con.prepareStatement("update medicine set qty=qty+? where name=?");
					pr.setDouble(1, q);
					pr.setString(2, m.getName());
					
					pr.executeUpdate();
					
				}
			}
			
			return f;
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

	public boolean placeOrd(Medicine m) {
		try
		{
			pr=con.prepareStatement("select name from medicine");
			rs=pr.executeQuery();
			boolean f=false;
			while(rs.next())
			{
				if(rs.getString(1).equals(m.getName()))
				{
					f=true;
					System.out.println("Enter quantity ");
					int q=sc.nextInt();
					
					pr=con.prepareStatement("select qty from medicine where name=?");
					pr.setString(1, m.getName());
					rs=pr.executeQuery();
					boolean f1=false;
					while(rs.next())
					{
						if(rs.getInt(1)>=q)
						{
							f1=true;
							while(true)
							{
								System.out.println("Medicine available Press 1 to proceed and Press 2 to cancel");
								int c=sc.nextInt();
								if(c==1)
								{
									System.out.println("Enter customer name:");
									String cnm=sc1.nextLine();
									
									
									pr=con.prepareStatement("select price from medicine where name=?");
									pr.setString(1, m.getName());
									rs=pr.executeQuery();
									Double price=0.0;
									while(rs.next())
									{
										price=rs.getDouble(1);
									}
									
									Double totalBill=price*q;
									pr=con.prepareStatement("insert into myorder (medname,custname,price,qty,totalbill) values (?,?,?,?,?)");
									pr.setString(1, m.getName());
									pr.setString(2, cnm);
									pr.setDouble(3, price);
									pr.setInt(4, q);
									pr.setDouble(5, totalBill);
									
									pr.executeUpdate();
									
									pr=con.prepareStatement("update medicine set qty=qty-? where name=?");
									pr.setInt(1, q);
									pr.setString(2, m.getName());
									pr.executeUpdate();
									
									pr=con.prepareStatement("select * from myorder where custname=?");
									pr.setString(1, cnm);
									rs=pr.executeQuery();
									
									while(rs.next())
									{
										System.out.println("MY CHEMIST SHOP");
										System.out.println("Name: "+rs.getString(2));
										System.out.print("Medicine : "+rs.getString(1));
										System.out.print(" | Price : "+rs.getDouble(3));
										System.out.print(" | Quantity : "+rs.getInt(4));
										System.out.print(" | Total: "+rs.getDouble(5));
										System.out.println("");
										
									}
									break;
									
									
									
								}
								else if(c==2)
								{
									break;
								}
								else
								{
									continue;
								}
							}
							
						}
					}
					if(f1==false)
					{
						System.out.println("Medicine out of stock");
					}
					
				}
			}
			return f;
			
			
			
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		
	}

}




















