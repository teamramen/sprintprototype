package entity;

public class Assignment {
	String assignment;
	String grade;

	public Assignment(String assignment, String grade) {
		this.assignment = assignment;
		this.grade = grade;
	}

	public String getAssignment() {
		return assignment;
	}

	public void setAssignment(String assignment) {
		this.assignment = assignment;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}


}
