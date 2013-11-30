import java.io.File;
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
		int option = -1;
		do
			option = showMenu();
		while(option!=0);
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
		case 4: viewListOfStudent();
			break;
		case 5: editOption();
			break;
		}

		return option;
	}

	public static void editOption()
	{
		System.out.println("Please select an edit option :\n1. Edit Module Information\n2. Edit Session Information\n3. Edit Student Information");
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();

		if(option<1 || option>5)
		{
			System.out.println("No such option");
		}
		
		switch(option)
		{
		case 1:editModule(); //edit module
			break;
		case 2:editSession(); //edit session
			break;
		case 3:editStudent();//edit student
			break;
		}
	}

	public static void editModule()
	{
		ArrayList<String> modules = new ArrayList<String>();
		System.out.println("Enter Module Code / Name to edit:");
		Scanner sc = new Scanner(System.in);
		String mn = sc.nextLine().toLowerCase();
		
		File file = new File("C:/Users/acer/workspace/PSD/src/moduleMapping.txt");
		Scanner fsc = getFileScanner(file);
		while(fsc.hasNextLine())
		{
			String line = fsc.nextLine();
			Scanner lsc = getLineScanner(line);
			lsc.useDelimiter(",");
			while(lsc.hasNext())
			{
				String token = lsc.next().toLowerCase();
				modules.add(token);
			}
		}
		
		if(modules.contains(mn))
		{
			
		}
		else
		{
			System.out.println("Invalid Module code / name");
		}
	}
	
	public static void editSession()
	{
		System.out.println("session");
	}
	
	public static void editStudent()
	{
		System.out.println("student");
	}
	
	public static void viewListOfStudent()
	{
		System.out.println("Please enter a session name to view");
		Scanner sc = new Scanner(System.in);
		String session = sc.nextLine();
		String line ="";
		int col = 0, row =0;
		int position= 0;
		ArrayList<String> names = new ArrayList<String>();
		ArrayList<String> lines = new ArrayList<String>(); 

		File file = new File("C:/Users/IanYeo/Dropbox/Team Ramen/PSD Code v5/src/student.txt");
		Scanner fsc = getFileScanner(file);
		while(fsc.hasNextLine())
		{
			row++;
			line = fsc.nextLine();
			lines.add(line);
		}
		String [] arr = line.split(",");
		List<String> list = Arrays.asList(arr);

		col = list.size();
		if(list.contains(session))
		{
			position =1;
		}

		String [][] data = new String [row][col];

		if(position==1)
		{
			//add data
			for(int i = 0; i<lines.size(); i++)
			{
				String sentence = lines.get(i);
				Scanner lsc = getLineScanner(sentence);
				for(int j = 0; j<col; j++)
				{
					lsc.useDelimiter(",");

					if(lsc.hasNext())
					{
						String item = lsc.next();
						data[i][j] = item;
						//System.out.println("data item ["+i+"]["+j+"]: "+data[i][j]);
					}
				}	
			}

			//get all student
			for(int i =0; i<row; i++)
			{
				names.add(data[i][0]);

				if(data[i][position+1].equals("absent")|| data[i][position+1].equals("mv"))
				{
					names.remove(data[i][0]);
				}
			}

			System.out.println(" ");
			System.out.println("Student(s) attended: ");
			for(int i =0; i<names.size(); i++)
			{
				System.out.println(names.get(i));
			}

			System.out.println("==============================================================");
		}
		else
		{
			System.out.println("Wrong Input\n");
			System.out.println("==============================================================");
		}
	}

	public static Scanner getFileScanner(File file)
	{
		Scanner sc = null;
		try {
			sc = new Scanner(file);
		} catch (FileNotFoundException e) {
			System.out.println("Unable to lcoate file");
			e.printStackTrace();
		}
		return sc;
	}
	
	public static Scanner getLineScanner(String sentence)
	{
		Scanner sc = new Scanner(sentence);
		return sc;
	}
}
