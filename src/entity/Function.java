import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class Function {
	private static Student s;
	private static Grades g;
	private static Course c;

	public static void tranScript() throws IOException {

		BufferedWriter f = new BufferedWriter(new FileWriter("transcript.txt"));

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
		f.write("||Student Id Number: 214121Y"
				+ "                                     " + "||");
		f.newLine();
		f.write("||Degree in Computer Science "
				+ "                                    " + "||");
		f.newLine();
		f.write("||Module Code             Module title          Grade            "
				+ "||");
		f.newLine();
		ArrayList<String> module = new ArrayList<String>();
		module.add("XXXXXXX");
		ArrayList<String> grade = new ArrayList<String>();
		grade.add("A");
		ArrayList<String> modulename = new ArrayList<String>();
		modulename.add("ALG3");

		for (int i = 0; i < module.size(); i++) {
			f.write("||" + module.get(i) + " " + "" + modulename.get(i) + " "
					+ "" + grade.get(i) + " "
					+ "                                                ||");
			f.newLine();
		}
		for (int i = 0; i < 20; i++) {
			f.write("||"
					+ "                             hello                             "
					+ "||");
			f.newLine();
		}

		// f.write("===================================================================");

		f.flush();
		f.close();
	}

	public static void importData() {
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> matric = new ArrayList<String>();
		ArrayList<String> gender = new ArrayList<String>();
		ArrayList<String> age = new ArrayList<String>();

		String csvFile = importDialog();
		if (csvFile != null) {
			BufferedReader br = null;
			String line = "";
			String cvsSplitBy = ",";

			try {

				br = new BufferedReader(new FileReader(csvFile));
				while ((line = br.readLine()) != null) {

					// use comma as separator
					String[] user = line.split(cvsSplitBy);

					name.add(user[0]);
					matric.add(user[1]);
					gender.add(user[2]);
					age.add(user[3]);
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

			System.out.println("Done");
			for (int i = 0; i < name.size(); i++) {
				System.out.print(name.get(i) + "	");
				System.out.print(matric.get(i) + "	");
				System.out.print(gender.get(i) + "	");
				System.out.print(age.get(i) + "	\n");

			}
		}
	}

	public static void exportData() {
		
		ArrayList<Student> student = new ArrayList<Student>();
		ArrayList<Grades> grades = new ArrayList<Grades>();
		ArrayList<Course> course = new ArrayList<Course>();
		s = new Student("Name", "Matric", "Gender", "Age");
		student.add(s);
		s = new Student("Gene", "123456G", "Male", "22");
		student.add(s);
		s = new Student("Ian", "098765I", "Male", "22");
		student.add(s);
		s = new Student("Joe", "456789J", "Male", "22");
		student.add(s);
		s = new Student("WenBing", "346790W", "Female", "20");
		student.add(s);
		s = new Student("YuanHu111i", "124578Y", "Female", "21");
		student.add(s);
		//c =new Course("Advance Programming", "AP32013", "AP3");
		c =new Course("Information System", "IS32013", "IS3");
		g = new Grades("A");

		for (int i=0; i<student.size(); i++){
			student.get(i).getCourse().add(c);
			student.get(i).getGrades().add(g);
		}
		
		String path = exportDialog();

		if (path != null) {
			File file = new File(path);
			// creates the file
			try {
				file.createNewFile();

				// creates a FileWriter Object
				FileWriter writer = new FileWriter(file);
				// Writes the content to the file
				for (int i = 0; i < student.size(); i++) {
					// System.out.println(student.get(i).getName());
					writer.write(student.get(i).getName() + ",");
					writer.write(student.get(i).getMatric() + ",");
					writer.write(student.get(i).getGender() + ",");
					writer.write(student.get(i).getAge() + "\n");
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
				.println("Menu:\n1. Mark attendance\n2. Import Attendance \n3. Export Attendance \n4. Transcript\n5. Exit\n\nChoose your options:");

		try {
			option = s.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("Only numbers are allowed!\n");
		}

		switch (option) {
		case 1:
			markAttendance();
			break;
		case 2:
			importData();
			break;
		case 3:
			exportData();
			break;
		case 4:
			tranScript();
			break;
		case 5:
			showMenu = false;
			break;
		}

		if (showMenu) {
			showMenu();
		}
	}

}
