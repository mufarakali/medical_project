package com.java.main;
import java.util.Scanner;
import com.java.service.Service;

	public class Main {

		public static void main(String[] args) {
			
		    Scanner sca=new Scanner(System.in);
			Scanner sc=new Scanner(System.in);
			Service s=new Service();
			System.out.println("!! My Chemist Shop !!");
			System.out.println("`````````````````````");
			
			while(true)
			{
				System.out.println("1. Admin");
				System.out.println("2. Employee");
				System.out.println("3. Exit");
				int ch=sca.nextInt();
				if(ch==1)
				{
					System.out.print("Enter Password: ");
					String pass1=sc.nextLine();
					if(pass1.equals("admin123"))
					{
						while(true)
						{
							System.out.println("1. Add Employee");
							System.out.println("2. Remove Employee");
							System.out.println("3. Show All Employees");
							System.out.println("4. Exit");
							
							int ch1=sca.nextInt();
							
							if(ch1==1)
							{
								if(s.addEmployee())
								{
									System.out.println("Employee Added Successfully !!");
								}
								else
								{
									System.out.println("Something Went Wrong !!!");
								}
							}
							else if(ch1==2)
							{
								if(s.removeEmployee())
								{
									System.out.println("Employee removed Successfuly !!");
								}
								else
								{
									System.out.println("Record not Found OR Something Went Wrong !!");
								}
							}
							
							else if(ch1==3)
							{
								s.showEmployess();
							}
							else if(ch1==4)
							{
								break;
							}
							
							else 
							{
								continue;
							}
						}
					}
					else
					{
						System.out.println("Incorrect Username or Password");
					}
					
				}
				else if(ch==2)
				{
					boolean a=s.EmployeeLogin();
					
					while(a)
					{
						
						System.out.println("1. Add Medicine");
						System.out.println("2. Show All Medicine");
						System.out.println("3. Remove a Medicine");
						System.out.println("4. Alter Medicine name ");
						System.out.println("5. Alter Medicine Price");
						System.out.println("6. Update Medicine Stock");
						System.out.println("7. To Place an order");
						System.out.println("8. To Exit");
						
						int ch1=sca.nextInt();
						
						if(ch1==1)
						{
							if(s.addMed())
							{
								System.out.println("Detail inserted Successfully !!");
							}
							else
							{
								System.out.println("Something went wrong......Try Again !!");
							}
						}
						else if(ch1==2)
						{
							if(!s.showMed())
							{
								System.out.println("Something went wrong......Try Again !!");
							}
						}
						
						else if(ch1==3)
						{
							if(s.removeMed())
							{
								System.out.println("Medicine removed successfully !!");
								
							}
							
						}
						else if(ch1==4)
						{
							if(!s.updateName())
							{
								System.out.println("Record not found..Try Again");
							}
						}
						else if(ch1==5)
						{
							if(s.updatePrice())
							{
								System.out.println("Price updated Successfully !!");
							}
							else
							{
								System.out.println("Something went wrong .... Try Again !!");
							}
						}
						else if(ch1==6)
						{
							if(s.updateStock())
							{
								System.out.println("Stock updated Successfully !!");
							}
							else
							{
								System.out.println("Something went wrong .... Try Again !!");
							}
						}
						else if(ch1==7)
						{
							if(!s.placeOrder())
							{
								System.out.println("Record not found..Try Again");
			}
						}
						else if(ch1==8)
						{
							break;
						}
						else
						{
							continue;
						}
						
					}
				}
				else if(ch==3)
				{
					break;
				}
				else
				{
					continue;
				}

			}
			sca.close();
			
			
		}

	}


