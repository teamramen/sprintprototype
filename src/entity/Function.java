package entity;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Function {
	private static Student s;
	private static Course c;
	public static ArrayList<Student> student;
	public static ArrayList<Grades> alJ;

	public static int selectStudentTranscript() throws IOException {
		int option = -1;
		System.out.println("Select Student to print Transcript");
		System.out.println(0 + " Print All Student Transcript");

		try {
			for (int i = 1; i < student.size(); i++) {
				System.out.println(i + " " + student.get(i).getName());

			}

		} catch (NullPointerException e) {
			System.out.println("No Data input!\n");
			showMenu();
		}

		Scanner s = new Scanner(System.in);

		try {
			option = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Only numbers are allowed!\n");
		}

		System.out.println(option);
		if (option > student.size()) {
			System.out.println("Invalid ID key in again");
			selectStudentTranscript();
		}
		return option;
	}

	public static void tranScript(int id) throws IOException {

		BufferedWriter f = new BufferedWriter(new FileWriter(student.get(id)
				.getName() + "_" + student.get(id).getMatric()+".txt"));

		f.write("===================================================================");
		f.newLine();
		f.write("||                      "
				+ "UNIVERSITY OF GLASGOW                    " + "||");
		f.newLine();
		for (int i = 0; i < 3; i++) {

			f.write("||                           "
					+ "                                    " + "||");
			f.newLine();
		}
		int nameLength = student.get(id).getName().length();
		int computeLength = 19 - nameLength;

		f.write("||Student Id Number: " + student.get(id).getMatric()
				+ "     Student Name:" + student.get(id).getName());
		for (int i = 0; i < computeLength; i++) {
			f.write(" ");
		}
		f.write("||");
		f.newLine();
		f.write("||Degree in Computer Science "
				+ "                                    " + "||");
		f.newLine();
		f.write("||Module Code             Module title          Grade            "
				+ "||");
		f.newLine();
		ArrayList<String> module = new ArrayList<String>();
		module.add("1");
		module.add("2");
		module.add("3");
		module.add("4");
		ArrayList<String> modulename = new ArrayList<String>();
		modulename.add("AP3");
		modulename.add("AL3");
		modulename.add("PSD");
		modulename.add("IS3");
		for (int i = 0; i < student.get(id).getGrades().size(); i++) {
			f.write("||" + module.get(i) + "                       "
					+ modulename.get(i) + "                   "
					+ student.get(id).getGrades().get(i).getgrade() + " "
					+ "               ||");
			f.newLine();
		}
		for (int i = 0; i < 10; i++) {
			f.write("||"
					+ "                                                               "
					+ "||");
			f.newLine();
		}

		f.write("===================================================================");

		f.flush();
		f.close();
		
	}

	public static void importData() {
		
		student = new ArrayList<Student>();

		String csvFile = "src/student.csv";
		// importDialog();
		if (csvFile != null) {
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";

			try {

				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] user = line.split(cvsSplitBy);
					s = new Student(user[0], user[1], user[2], user[3]);

					// c = new Course(user[4],user[5],user[6]);
					ArrayList<Grades> g = new ArrayList<Grades>();
					g.add(new Grades(user[4].charAt(0)));
					g.add(new Grades(user[5].charAt(0)));
					g.add(new Grades(user[6].charAt(0)));
					g.add(new Grades(user[7].charAt(0)));

					s.setGrades(g);

					student.add(s);
				}
				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] user = line.split(cvsSplitBy);
					for (int i = 0; i < student.size(); i++) {
						c = new Course(user[4], user[5], user[6]);
						student.get(i).getCourse().add(c);
					}
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} finally {
				if (br != null) {
					try {
						br.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
//			System.out.println("Name" + "		Matric" + "		Age" + "		Gender"
//					+ "	AP3" + "	ALG3" + "	PSD" + "	IS");
//			for (int i = 1; i < student.size(); i++) {
//
//				System.out.print(student.get(i).getName() + "		");
//				System.out.print(student.get(i).getMatric() + "		");
//				System.out.print(student.get(i).getGender() + "		");
//				System.out.print(student.get(i).getAge() + "	");
//
//				alJ = student.get(i).getGrades();
//
//				for (int j = 0; j < alJ.size(); j++) {
//					System.out.print(alJ.get(j).getgrade() + "	");
//				}
//
//				System.out.println("");
//			}

		}

	}

	public static void exportData() {

		// ArrayList<Student> student = new ArrayList<Student>();

		String path = exportDialog();

		if (path != null) {
			File file = new File(path);
			// creates the file
			try {
				file.createNewFile();

				// creates a FileWriter Object
				FileWriter writer = new FileWriter(file);
				// Writes the content to the file
				// "Name" + "		Matric" + "		Age" + "		Gender"
				// + "	AP3" + "	ALG3" + "	PSD" + "	IS");
				writer.write("Name," + "Matric," + "Age," + "Gender," + "AP3,"
						+ "ALG3," + "PSD," + "IS," + "\r\n");
				for (int i = 1; i < student.size(); i++) {
					// System.out.println(student.get(i).getName());
					writer.write(student.get(i).getName() + ",");
					writer.write(student.get(i).getMatric() + ",");
					writer.write(student.get(i).getGender() + ",");
					writer.write(student.get(i).getAge() + ",");
					for (int j = 0; j < alJ.size(); j++) {
						writer.write(alJ.get(j).getgrade() + ",");

					}
					writer.write("\r\n");

				}

				writer.flush();
				writer.close();
				// Creates a FileReader Object
				FileReader fr = new FileReader(file);
				char[] a = new char[9999];
				fr.read(a); // reads the content to the array
				for (char c : a)
					System.out.print(c); // prints the characters one by one
				fr.close();

				/*
				 * for (int i=0; i<student.size(); i++){ Student b=
				 * student.get(i); Grades g = grades.get(i); }
				 */

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static String importDialog() {
		boolean cont = true;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV",
				"csv");
		chooser.setFileFilter(filter);

		int returnVal = chooser.showOpenDialog(chooser);
		chooser.requestFocusInWindow();
		// String path = chooser.getSelectedFile().getAbsolutePath();
		String path = null;
		try {
			path = chooser.getSelectedFile().getAbsolutePath();
		} catch (NullPointerException e) {
			System.out.println("No Input File");
			cont = false;
		}
		if (cont) {
			if (!path.contains(".csv")) {
				return path + ".csv";
			} else {
				return path;
			}
		}
		return null;
	}

	public static String exportDialog() {
		boolean cont = true;
		JFileChooser chooser = new JFileChooser();
		FileNameExtensionFilter filter = new FileNameExtensionFilter("CSV",
				"csv");
		chooser.setFileFilter(filter);
		int rVal = chooser.showSaveDialog(null);
		String path = null;
		try {
			path = chooser.getSelectedFile().getAbsolutePath();
		} catch (NullPointerException e) {
			System.out.println("No Input File");
			cont = false;
		}
		if (cont) {
			if (!path.contains(".csv")) {
				return path + ".csv";
			} else {
				return path;
			}
		}
		return null;
	}

	public static void markAttendance() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter student id to mark attendance:");

		String studentId = s.nextLine();

		/*
		 * TO-DO: 1. Do a check on student exist 2. Get the student if it exist
		 * 3. Set the attendance
		 */
		System.out.println(studentId);
		//
	}
	

	public static void showMenu() throws IOException {
		boolean showMenu = true;
		int option = -1;

		Scanner s = new Scanner(System.in);
		System.out
				.println("Menu:\n1. Export Transcript \n2. Export Data \n3. Export Assignment Grade  \n4. Exit\nChoose your options:");

		try {
			option = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Only numbers are allowed!\n");
		}

		switch (option) {
		case 1:
			importData();
			int id = selectStudentTranscript();
			if (id == 0) {
				for (int g = 1; g < student.size(); g++) {
					tranScript(g);
				}
			} else {
				tranScript(id);
			}
			break;
		case 2:
			exportData();
			break;
		case 3:
			exportCourseGrade(student);
			break;
		case 4:
			showMenu = false;
			break;
		}

		if (showMenu) {
			showMenu();
		}
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

	Scanner fsc = getFileScanner("/src/student.txt");
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

public static void exportCourseGrade(ArrayList<Student> student) {
	/*s.getCourse().add(new Course("Algorithm", "AL3", "alg"));
	s.getCourse().add(new Course("Advance Programming", "AP3", "ap"));
	s.getCourse().add(new Course("Programming language", "PL3", "pl"));

	student.add(s);*/
	int size = student.get(0).getCourse().size();
	System.out.println(size);

	Scanner s = new Scanner(System.in);

	System.out.println("Enter student matriculation number: ");
	String matriculationNo = s.next();

	for (Student stu : student) {
		if (stu.getMatric().equals(matriculationNo)) {
			//
			stu.getCourse().add(new Course("Algorithm", "ALG3", "alg"));
			stu.getCourse().add(new Course("Advance Programming", "AP3", "ap"));
			stu.getCourse().add(new Course("Programming language", "PL3", "pl"));

			stu.setAssignment(0, "Assignment 1", "A");
			stu.setAssignment(0, "Assignment 2", "B");

			stu.setAssignment(1, "Assignment 3", "F");

			stu.setAssignment(2, "Assignment 4", "C");
			//
			
			ArrayList<Course> course = stu.getCourse();

			System.out.println("Select course to export the grades: ");

			for (int i = 0; i < course.size(); i++) {
				System.out.println((i+1) + ". " + course.get(i).getCoursename());
			}

			int input = s.nextInt() - 1;

			if (input < course.size() && input >= 0) {
				//Export the grades as CSV
				try {
					ArrayList<Assignment> assignment = stu.getAssignment(input);

					BufferedWriter f = null;

					f = new BufferedWriter(new FileWriter(stu.getMatric() + "-" + course.get(input).getCoursename() + ".csv"));

					if (assignment != null) {
						for (int i = 0; i < assignment.size(); i++) {
							f.write(assignment.get(i).getAssignment() + "," + assignment.get(i).getGrade()+ "\n");
						}

						f.close();
					}
					else {
						System.out.println("No assignment found.");
					}
				}
				catch(Exception e) {
					System.out.println(e.getMessage());
				}
			}
			else {
				System.out.println("Error");
			}

			break;
		}
	}
}
public static void editOption()
{
	System.out.println("Please select an edit option :\n1. Edit Module Information\n2. Edit Session Information");
	Scanner sc = new Scanner(System.in);
	int option = sc.nextInt();

	if(option<1 || option>2)
	{
		System.out.println("No such option");
	}

	switch(option)
	{
	case 1:editModule(); //edit module
	break;
	case 2:editSession(); //edit session
	break;
	}
}

public static void editModule()
{
	ArrayList<String> modules = new ArrayList<String>();
	ArrayList<Course> course = new ArrayList<Course>();
	ArrayList<String> moduleSession = new ArrayList<String>();
	ArrayList<Session> sessionList = new ArrayList<Session>();
	System.out.println("Enter Module Code / Name to edit:");
	Scanner sc = new Scanner(System.in);
	String mn = sc.nextLine().toLowerCase();
	Course c1 = null;

	Scanner fsc = getFileScanner("/src/moduleMapping.txt");
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

	int position =0;
	boolean found = false;
	for(int i =0; i<modules.size(); i++)
	{
		if(modules.get(i).equals(mn))
		{
			position = i;
			found = true;
		}
	}

	if(found)
	{
		Scanner fsc2 = getFileScanner("/src/module.txt");
		while(fsc2.hasNextLine())
		{
			String line = fsc2.nextLine();
			//System.out.println(line);
			moduleSession.add(line);
		}

		for(int i=0; i<moduleSession.size();i++)
		{
			String sentence = moduleSession.get(i);
			Scanner lsc2 = getLineScanner(sentence);
			lsc2.useDelimiter(",");
			//get module
			if(position ==1)
			{
				String name = lsc2.next();
				//System.out.println(name);
				c1 = new Course(null,name, null);

				//remove edited sentence
				if(moduleSession.get(i).substring(0, name.length()).equals(name))
				{
					moduleSession.remove(i);
				}

				course.add(c1);
			}
			else if(position == 0)
			{
				c1 = new Course(lsc2.next(), null, null);
				course.add(c1);
			}

			//get session
			while(lsc2.hasNext())
			{
				Session session = new Session(lsc2.next(),null,false);
				sessionList.add(session);
			}
			c1.setSessions(sessionList);

			System.out.println(" ");
			System.out.println("Please select an option below:\n1. Add Session\n2. Remove Session\n0. Exit");
			Scanner sc2 = new Scanner(System.in);
			int option2 = sc2.nextInt();

			switch(option2)
			{
			case 1:
				c1.getSessions().add(addSession());
				c1.setSessions(c1.getSessions());
				moduleSession = getModuleList(c1,moduleSession);
				writeToFile(moduleSession,"/src/module.txt");
				showSession(c1.getSessions());
				moduleSession.clear();
				break;
			case 2:
				c1.setSessions(removeSession(c1.getSessions()));
				moduleSession = getModuleList(c1,moduleSession);
				writeToFile(moduleSession,"/src/module.txt");
				showSession(c1.getSessions());
				moduleSession.clear();
				break;
			case 0:
				break;
			}
		}
	}
	else
	{
		System.out.println("Invalid Module name / code");
	}
}

public static void writeToFile(ArrayList<String>moduleSession, String path)
{
	FileWriter writer;

	File file = new File(getPath(path));
	try {
		writer = new FileWriter(file);
		for(int i=moduleSession.size()-1; i>=0; i--)
		{
			writer.write(moduleSession.get(i)+ System.getProperty("line.separator"));
		}

		writer.close();

	} catch (IOException e) {
		System.out.println("Unable to locate file");
		//e.printStackTrace();
	}
}

public static void writeStudentToFile(ArrayList<String>sl, String path)
{
	FileWriter writer;

	File file = new File(getPath(path));
	try {
		writer = new FileWriter(file);
		for(int i=0; i<sl.size(); i++)
		{
			writer.write(sl.get(i)+ System.getProperty("line.separator"));
		}

		writer.close();

	} catch (IOException e) {
		System.out.println("Unable to locate file");
		//e.printStackTrace();
	}
}

public static ArrayList<String> getModuleList(Course c1, ArrayList<String> list)
{
	StringBuilder sb = new StringBuilder();
	sb.append(c1.getModuleCode()+",");
	for(Session s : c1.getSessions())
	{
		sb.append(s.getSessionName()+",");
	}
	//clear the last comma
	String line = sb.substring(0, sb.length()-1);
	list.add(line);

	return list;
}

public static void showSession(ArrayList<Session> list)
{
	System.out.println("Changes has been committed");
	for(Session s : list)
	{
		System.out.print(s.getSessionName()+" | ");
	}
}

public static ArrayList<Session> removeSession(ArrayList<Session> list)
{
	System.out.println("Please enter the session name to remove");
	Scanner sc = new Scanner(System.in);
	String name = sc.next();

	System.out.println("\""+name+"\" has been removed");
	int index = 0;
	for(int i=0; i<list.size(); i++)
	{
		if(list.get(i).getSessionName().equals(name))
		{
			index = i;
		}
	}
	list.remove(index);
	return list;
}

public static Session addSession()
{
	System.out.println("Please enter the Session Name");
	Scanner sc = new Scanner(System.in);
	String name = sc.nextLine();

	System.out.println("Please enter the Session Type");
	String type = sc.nextLine();

	//System.out.println("You've entered : "+name+" "+type);
	Session session = new Session(name,type,false);

	return session;
}

public static String getPath(String path)
{
	String dir = System.getProperty("user.dir");
	StringBuilder sb = new StringBuilder(dir);

	for(int i=0; i<dir.length(); i++)
	{
		if(dir.charAt(i)=='\\')
		{
			sb.setCharAt(i, '/');
		}
	}

	return (sb.toString()+path);
}

public static void editSession()
{
	ArrayList<String> sl = new ArrayList<String>(); // sentence from file
	System.out.println("Enter Session name edit:");
	Scanner sc = new Scanner(System.in);
	String sm = sc.nextLine().toLowerCase();
	int position =0;
	boolean found = false;
	int universal = 0, indicator=0;
	
	Scanner fsc = getFileScanner("/src/session.txt");
	while(fsc.hasNextLine())
	{
		String line = fsc.nextLine();
		sl.add(line);
		universal++;
		if(line.substring(0, sm.length()).equals(sm))
		{
			position = 1;
			found = true;
			indicator = universal;
		}
	}

	if(found && position==1)
	{
		System.out.println(" ");
		System.out.println("Please select an option below:\n1. Add Student\n2. Remove Student\n3. Edit Session name\n0. Exit");
		Scanner sc2 = new Scanner(System.in);
		int option2 = sc2.nextInt();

		switch(option2)
		{
		case 1:
			sl = addStudent(sl,indicator);
			showStudent(sl,indicator);
			writeStudentToFile(sl,"/src/session.txt");
			sl.clear();
			break;
		case 2:
			sl = removeStudent(sl);
			showStudent(sl,indicator);
			writeStudentToFile(sl,"/src/session.txt");
			sl.clear();
			break;
		case 3:
			sl = changeSessionName(sl, sm);
			showStudent(sl,indicator);
			writeStudentToFile(sl,"/src/session.txt");
			sl.clear();
			break;
		case 0:
			break;
		}
	}
	else
	{
		System.out.println("Invalid Module name / code");
	}
}

public static ArrayList<String> changeSessionName(ArrayList<String>sl, String sm)
{
	ArrayList<String> temp = new ArrayList<String>();
	System.out.println("Please enter new session name: ");
	Scanner sc = new Scanner(System.in);
	String session = sc.nextLine();
	System.out.println("You've entered : "+session);
	int indicator = 0;
	
	for(int i=0; i<sl.size(); i++)
	{
		if(sl.get(i).contains(sm))
		{
			Scanner lsc = getLineScanner(sl.get(i));
			indicator = i;
			lsc.useDelimiter(",");
			while(lsc.hasNext())
			{
				temp.add(lsc.next());
			}
		}
	}
	
	temp.set(0, session);
	
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<temp.size()-1; i++)
	{
		sb.append(temp.get(i)+",");
	}
	sb.append(temp.get(temp.size()-1));
	
	sl.remove(indicator);
	String line = sb.toString();
	//System.out.println("new line : "+ line);
	sl.add(indicator, line);
	
	System.out.println("\""+session+"\" has been changed");

	return sl;
}

public static void showStudent(ArrayList<String>sl, int index)
{		
	String line = null;
	int j=0;
	if(index == 0)
	{
		line = sl.get(index);
		j=0;
	}
	else
	{
		j=index-1;
		line = sl.get(j);
	}
	
	Scanner lsc = new Scanner(line);
	lsc.useDelimiter(",");
	String token = lsc.next();
	System.out.println(token+" has the following students:");

	while(lsc.hasNext())
	{
		token = lsc.next();
		System.out.print(token+" | ");
	}
}

public static ArrayList<String> addStudent(ArrayList<String>sl, int index)
{
	System.out.println("Please enter student name" +index);
	Scanner sc = new Scanner(System.in);
	String name = sc.nextLine();
	String line = null;
	int j = 0;
	
	if(index == 0)
	{
		line = sl.get(index);
		j=0;
	}
	else
	{
		j=index-1;
		line = sl.get(j);
	}
	
	System.out.println("here "+line);
	
	Scanner lsc = new Scanner(line);
	lsc.useDelimiter(",");
	String token = null;
	StringBuilder sb = new StringBuilder();
	while(lsc.hasNext())
	{
		token = lsc.next();
		sb.append(token+",");
	}
	sb.append(name);
	System.out.println("\""+name+"\" has been added ");

	sl.set(j, sb.toString());
	return sl;
}

public static ArrayList<String> removeStudent(ArrayList<String>sl) //pass in sl
{
	ArrayList<String> temp = new ArrayList<String>();
	System.out.println("Please enter student name to remove");
	Scanner sc = new Scanner(System.in);

	String name = sc.nextLine();
	String waiting = null;
	int index = 0;
	for(int i=0; i<sl.size(); i++)
	{
		if(sl.get(i).contains(name))
		{
			waiting = sl.get(i);
			index = i;
		}
	}

	Scanner lsc = getLineScanner(waiting);
	lsc.useDelimiter(",");
	while(lsc.hasNext())
	{
		temp.add(lsc.next());
	}
	
	StringBuilder sb = new StringBuilder();
	for(int i=0; i<temp.size()-1; i++)
	{
		if(temp.get(i).equals(name))
		{
			temp.remove(i);
		}

		sb.append(temp.get(i)+",");
	}
	sb.append(temp.get(temp.size()-1));
	
	sl.remove(index);
	String line = sb.toString();
	sl.add(index, line);

	System.out.println("\""+name+"\" has been removed");

	return sl;
}

public static Scanner getFileScanner(String path)
{
	Scanner sc = null;
	File file = new File(getPath(path));

	try {
		sc = new Scanner(file);
	} catch (FileNotFoundException e) {
		System.out.println("Unable to locate file");
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

