package emailapp;

import java.util.Scanner;

public class Email {
	private String firstName;
	private String lastName;
	private String password;
	private String department;
	private String email;
	private static int defaultPasswordLength = 10;
	private int mailboxCapacity = 500;
	private String alternateEmail;
	private String companySuffix = ".xyz.com";
	
	//Constructor to receive the firstName and lastName
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		System.out.println("Email Created for : "+this.firstName+" "+this.lastName);
		
		//Call a method asking for a department and then return the department
		this.department = setDepartment();
		System.out.println("Department is: "+this.department);
		
		//Call a method that returns a randomn password
		this.password = randomPassword(defaultPasswordLength);
		System.out.println("Generated Password is: "+this.password);
		
		//Combine elements to generate email
		email = this.firstName+"."+this.lastName+"@"+this.department+companySuffix;
		System.out.println("Email ID is: "+email);
	}
	
	//Ask for the department
	private String setDepartment() {
		System.out.print("Enter the department\n1 for Sales\n2 "
				+ "for Development\n3 for Accounting\n4 for none\n Enter Department Code: ");
		Scanner in = new Scanner(System.in);
		int departmentChoice = in.nextInt();
		
		switch(departmentChoice) {
		case 1: 
			return "sales";
		case 2:
			return "dev";
		case 3:
			return "acct";
		default:
			return "";
		}
	}
	
	//Generate a randomn password
	public String randomPassword(int length) {
		String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*()";
		char[] password = new char[length];
		for(int i=0;i<length;i++)
		{
			int rand = (int)(Math.random()*passwordSet.length());
			password[i] = passwordSet.charAt(rand);
		}
		return new String(password);
	}
	
	//Set the mailbox capacity
	public void setMailboxCapacity(int capacity) {
		mailboxCapacity = capacity;
	}
	//Set the alternate email
	public void setAlternateEmail(String email) {
		alternateEmail = email;
	}
	//Change the password
	public void changePassword(String password) {
		this.password = password;
	}
	
	public int getMailboxCapacity() { return this.mailboxCapacity; };
	public String getAlternateEmail() { return this.alternateEmail; };
	public String getPassword() { return this.password; };
	
	public String showInfo() {
		return  "DISPLAY NAME: "+this.firstName+" "+this.lastName+
				"\n Email: "+this.email+
				"\n Mailbox Capacity: "+this.mailboxCapacity;
	}
}
