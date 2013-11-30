package entity;

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
				.getName() + "_" + student.get(id).getMatric()));

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

		String csvFile = "C:/Users/IanYeo/Documents/student.csv";
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
			exportData();
			break;
		case 4:
			showMenu = false;
			break;
		}

		if (showMenu) {
			showMenu();
		}
	}

}
