package com.java.service;

import java.util.Scanner;

import com.java.Dao.Dao;
import com.java.model.Employee;
import com.java.model.Medicine;

public class Service {

	Scanner sc,sc1;
	Dao d;
	public Service()
	{
		d=new Dao();
		sc1=new Scanner(System.in);
		sc=new Scanner(System.in);
	}
/* FOR ADMIN PURPOSE */
	
	public boolean addEmployee() {
		System.out.print("Enter Employee Name: ");
		String name=sc1.nextLine();
		System.out.print("Enter New User Name: ");
		String uname=sc1.nextLine();
		System.out.print("Enter a strong Password: ");
		String pass=sc1.nextLine();
		
		Employee e=new Employee(name,uname,pass);
		
		boolean r=d.addEmp(e);
		return(r);
	}

	public boolean removeEmployee() {
		
		System.out.print("Enter Employee Name: ");
		String name=sc1.nextLine();
		
		Employee e=new Employee();
		e.setName(name);
		
		return(d.removeEmp(e));
		
	}

	public void showEmployess() {
		
		d.showEmp();
		
		
	}

	
	/* FOR EMPLOYEE PURPOSE */
	
	
	public boolean EmployeeLogin() {
		
		System.out.println("Username: " );
		String uname=sc1.nextLine();
		System.out.println("Password: " );
		String pass=sc1.nextLine();
		
		Employee e=new Employee();
		e.setUsername(uname);
		e.setPass(pass);
		
		return(d.empLogin(e));
		
	}

	public boolean addMed() {
		System.out.print("Enter Medicine Name: ");
		String nm=sc1.nextLine();
		System.out.print("Enter Price: ");
		Double p=sc.nextDouble();
		System.out.print("Enter Quantity: ");
		int qty=sc.nextInt();
		
		Medicine m=new Medicine(nm,p,qty);
		
		return(d.addMedDetails(m));
		
	}

	public boolean showMed() {

		return d.showAllMed();
		
	}

	public boolean removeMed() {
		System.out.print("Enter Medicine name to remove: ");
		String nm=sc1.nextLine();
		Medicine m=new Medicine();
		m.setName(nm);
		return d.removeMed(m);
		
	}

	public boolean updateName() {
		System.out.print("Enter Medicine name to upadte name: ");
		String nm=sc1.nextLine();
		Medicine m=new Medicine();
		m.setName(nm);
		
		return d.updateName(m);
		
	}

	public boolean updatePrice() {
		System.out.print("Enter Medicine name to upadte its price: ");
		String nm=sc1.nextLine();
		Medicine m=new Medicine();
		m.setName(nm);
		
		return d.updatePrice(m);
	}

	public boolean updateStock() {
		System.out.print("Enter Medicine name to upadte its stock: ");
		String nm=sc1.nextLine();
		Medicine m=new Medicine();
		m.setName(nm);
		
		return d.updateStock(m);
		
	}

	public boolean placeOrder() {
		System.out.print("Enter Medicine name: ");
		String nm=sc1.nextLine();
		Medicine m=new Medicine();
		m.setName(nm);
		
		return d.placeOrd(m);
	}

}



























