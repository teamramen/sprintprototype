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
		String username = "maoxiong";
		System.out.println("Please Login:");
		Scanner sc = new Scanner(System.in);
		if (sc.next().equals(username)) {
			count =1;
			System.out.println("You have login as Administrator");
		} else {
			System.out.println("Wrong Password");
		}
		
		if(count ==1)
		{
			int option = -1;
			do
				option = showMenu();
			while(option!=0);
		}
		
	}

	public static int showMenu() throws IOException
	{
		
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

}