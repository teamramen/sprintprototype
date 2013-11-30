import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

import entity.Function;
import entity.Session;
import entity.Student;


public class Attendance {
	ArrayList<Student> student;

	public Attendance(ArrayList<Student> student) {
		this.student = student;
	}

	public void markAttendance() {
		Scanner s = new Scanner(System.in);

		System.out.println("Enter session name:");
		String sessionName = s.next();

		System.out.println("Enter session type:");
		String sessionType = s.next();

		manualAttendance(s, sessionName, sessionType);
	}

	private void manualAttendance(Scanner s, String sessionName, String sessionType) {
		boolean added = false;
		String output = "";

		System.out.println("Enter student matriculation number to mark attendance:");
		String studentId = s.next();

		for (Student stu : student) {
			if (stu.getMatric().equals(studentId)) {
				if (!isMarked(stu.getSession(), sessionName)) {
					stu.getSession().add(new Session(sessionName, sessionType, true));
					added = true;
				}
				else {
					output += "Attendance for this student has been marked already!";
				}

				break;
			}
		}

		if (added) {
			System.out.println("Attendance successfully added!");
		}
		else {
			if (output.equals("")) {
				System.out.println("\nNo student found!");	
			}
			else {
				System.out.println(output);
			}
		}

		printAttendance(sessionName);

		System.out.println("Do you want to add another attendance? (Enter \"Y\" to continue)");
		String addAgain = s.next();

		if (addAgain.equalsIgnoreCase("Y")) {
			manualAttendance(s, sessionName, sessionType);
		}
	}

	public void importAttendance() {
		try {
			Scanner s = new Scanner(System.in);

			System.out.println("Enter session type:");
			String sessionType = s.next();

			String inputFileName =Function.importDialog();
			FileReader reader = new FileReader(inputFileName);
			Scanner in = new Scanner(reader);

			ArrayList<String> sessionNameArray = new ArrayList<String> ();

			while (in.hasNext()) {
				String input = in.nextLine();
				String [] inputArray = input.split(",");

				String sessionName = inputArray[0];
				sessionNameArray.add(sessionName);

				for (int i = 1; i < inputArray.length; i++) {
					Student stu = getStudent(inputArray[i]);

					if (stu != null) {
						if (!isMarked(stu.getSession(), sessionName)) {
							stu.getSession().add(new Session(sessionName, sessionType, true));
						}
					}
				}
			}

			System.out.println("Attendance has been imported!\n");

			for (int i = 0; i < sessionNameArray.size(); i++) {
				printAttendance(sessionNameArray.get(i));
			}
		}
		catch (FileNotFoundException e) {e.printStackTrace();}
	}

	private void printAttendance(String sessionName) {
		System.out.println("\n==== Student who attended (" + sessionName + ") ====");

		for (int i = 0; i < student.size(); i++) {
			ArrayList<Session> session = student.get(i).getSession();

			for (Session sess : session) {
				if (sess.getSessionName().equals(sessionName)) {
					System.out.println(student.get(i).getName());
				}
			}
		}

		System.out.println("========");
	}

	private boolean isMarked(ArrayList<Session> session, String sessionName) {
		for (Session s : session) {
			if (s.getSessionName().equals(sessionName)) {
				return true;
			}
		}

		return false;
	}

	private Student getStudent(String matricNo) {
		for (Student s : student) {
			if (s.getMatric().equals(matricNo)) {
				return s;
			}
		}

		return null;
	}
}
