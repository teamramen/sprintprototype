package entity;

import java.util.ArrayList;

public class Session {
	
	private String sessionName;
	
	private ArrayList<Student> listOfStudent = new ArrayList<Student>();
	
	public String getSessionName()
	{
		return this.sessionName;
	}
	
	public void setSessionName(String sessionName)
	{
		this.sessionName = sessionName;
	}
	
	public ArrayList<Student> getStudents()
	{
		return listOfStudent;
	}
	
	public void setStudents(ArrayList<Student> students)
	{
		listOfStudent = students;
	}

}
