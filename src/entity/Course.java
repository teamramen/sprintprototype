package entity;

import java.util.ArrayList;
import entity.Student;

public class Course {
	private String courseName;
	private String moduleCode;
	private String alias;
	
	//need to include the student in a module, and the number of session each module has
	private ArrayList<Student> listOfStudent = new ArrayList<Student>();
	private ArrayList<Session> sessions = new ArrayList<Session>();
	// 
	
	public Course(String courseName, String moduleCode, String alias) {
		this.courseName = courseName;
		this.moduleCode = moduleCode;
		this.alias = alias;
	}
	
	public void setListOfStudent(ArrayList<Student> student)
	{
		listOfStudent = student;
	}
	
	public ArrayList<Student> getStudents()
	{
		return this.listOfStudent;
	}
	
	public void setSessions(ArrayList<Session> session)
	{
		this.sessions = session;
	}
	
	public ArrayList<Session> getSessions()
	{
		return this.sessions;
	}
	
	public String getCoursename() {
		return courseName;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getModuleCode() {
		return moduleCode;
	}

	public void setModuleCode(String moduleCode) {
		this.moduleCode = moduleCode;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

}