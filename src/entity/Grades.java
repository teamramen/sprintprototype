package entity;

public class Grades {
	private char grades;
	//constant for grades
	public static final char A = 'A';
	public static final char B = 'B';
	public static final char C = 'C';
	public static final char D = 'D';
	public static final char F = 'F';
	
	public Grades(char grades) {
		this.grades = grades;
	}
	
	//set to constant
	public void setgrades(char grades)
	{
		this.grades = grades;
	}
	
	//return constant as grades
	public char getgrade() {
		return grades;
	}
}