import java.util.ArrayList;

public class Student {
	private String name;
	private String matric;
	private String gender;

	ArrayList<Grades> grade = new ArrayList<Grades>();

	public Student(String name, String matric, String gender) {
		this.name = name;
		this.matric = matric;
		this.gender = gender;

	}

	public ArrayList<Grades> getGrades() {
		return grade;
	}

	public String getName() {
		return name;
	}

	public String getMatric() {
		return matric;
	}

	public String getGender() {
		return gender;
	}
}
