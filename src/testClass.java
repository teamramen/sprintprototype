import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entity.Course;
import entity.Session;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import entity.Function;
import entity.Student;

public class testClass {
	static Function f;
	public static void main(String [] args) throws IOException
	{
		int count=0;
		String username = "admin";
		String password = "password";

		String username1 = "lecturer";
		String password1 = "password";

		Scanner sc = new Scanner(System.in);

		System.out.println("Please enter username:");
		String un = sc.next();

		System.out.println("Please enter password:");
		String pwd = sc.next();

		if (un.equals(username)&& pwd.equals(password)) {
			count =1;
			System.out.println("You have login as Administrator");
		} 		
		else if(un.equals(username1)&& pwd.equals(password1)){
			System.out.println("You have logged as Lecturer");
			count =2;
		}
		else {
			System.out.println("Wrong Password");
		}


		

		if(count ==1)
		{
			int option = -1;
			do
				option = showMenu();
			while(option!=0);
		}
		
		if(count ==2)
		{
			int option = -1;
			do
				option = showMenu1();
			while(option!=0);
		}

	}

	public static int showMenu() throws IOException
	{
		System.out.println("Administrator Menu");
		System.out.println("=============================================");
		System.out.println("Please select an item:\n1. Export Transcript & Grades\n2. Mark Attendance\n3. Import Attendance \n4. View Attendance \n5. Edit Option \n0. To exit");
		Scanner sc = new Scanner(System.in);
		f.importData();
		int option = sc.nextInt();
		if(option<0 || option>5)
		{
			System.out.println("No such option");
		}

		switch(option)
		{
		case 0: System.out.println("Good Bye");
		return option;
		case 1:f.showMenu();
		break;
		case 2: 
			new Attendance(f.student).markAttendance();
			break;
		case 3: 
			new Attendance(f.student).importAttendance();
			break;
		case 4: f.viewListOfStudent();
		break;
		case 5: f.editOption();
		break;
		}

		return option;
	}
	
	public static int showMenu1() throws IOException
	{	
		System.out.println("Lecturer Menu");
		System.out.println("=============================================");
		System.out.println("Please select an item:\n1. Mark Attendance\n2. View Attendance \n3. Edit Option \n0. To exit");
		Scanner sc = new Scanner(System.in);
		f.importData();
		int option = sc.nextInt();
		if(option<0 || option>3)
		{
			System.out.println("No such option");
		}

		switch(option)
		{
		case 0: System.out.println("Good Bye");
		return option;
		case 1:
			new Attendance(f.student).markAttendance();
		break;
		case 2: 
			f.viewListOfStudent();
			break;
		case 3: 
			f.editOption();
			break;
		}

		return option;
	}

}