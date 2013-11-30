import java.io.File;
import java.util.Scanner;

public class testClass {
	
	public static void main(String [] args)
	{
		showMenu();
	}
	
	public static void showMenu()
	{
		System.out.println("Please select an item:\n1. Show student\n2. Mark Attendance");
		Scanner sc = new Scanner(System.in);
		
		int option = sc.nextInt();
		if(option<1 || option>4)
		{
			System.out.println("No such option");
		}
		
		switch(option)
		{
		case 1: viewListOfStudent();
			break;
		case 2: //do smth
			break;
		}
	}
	
	public static void viewListOfStudent()
	{
		System.out.println("To view students, please select an option below:\n1. Enter Module Name\2. Enter Module Name");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		String moduleName;
		
		switch(option)
		{
		case 1: 
			System.out.println("Please enter a module to view");
			moduleName = sc.nextLine();
			
			break;
		case 2:
			break;
		}
		//validate module name
		//Scanner fsc = new Scanner(new File());
		
		
	}
}
