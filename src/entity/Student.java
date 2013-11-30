package entity;

import java.util.ArrayList;

public class Student {
	private String name;
	private String matric;
	private String gender;
	private String age;

	ArrayList<Grades> grade = new ArrayList<Grades>();
	ArrayList<Course> course = new ArrayList<Course>();
	ArrayList<Session> session = new ArrayList<Session>();
	
	public Student(String name, String matric, String gender, String age) {
		this.name = name;
		this.matric = matric;
		this.gender = gender;
		this.age = age;
	}
	
	public void setAge(String age)
	{
		this.age = age;
	}
	
	public String getAge()
	{
		return age;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public void setMatric(String matric)
	{
		this.matric = matric;
	}
	
	public void setGender(String gender)
	{
		this.gender = gender;
	}
	
	public ArrayList<Grades> getGrades() {
		return grade;
	}
	
	public void setGrades(ArrayList<Grades> grades)
	{
		this.grade = grades;
	}
	
	public ArrayList<Course> getCourse()
	{
		return course;
	}

	public void setCourse(ArrayList<Course> course)
	{
		this.course = course;
	}
	
	public ArrayList<Session> getSession()
	{
		return this.session;
	}

	public void setSession(ArrayList<Session> session)
	{
		this.session = session;
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
