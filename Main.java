import java.util.ArrayList;


public class Main {
	private static Student s;
	private static Grades a;
	public static void Main(String[] args){
		ArrayList<Student> student = new ArrayList<Student>();
		ArrayList<Grades> grades = new ArrayList<Grades>();
		//s =new Student("Gene","214123Y", "Male",22);
		student.add(s);
		//a=new Grades("A","A","A","A");
		
		grades.add(a);
		for (int i=0; i<student.size(); i++){
			Student b= student.get(i);
			 Grades g = grades.get(i);
			 
			//System.out.println("Name :"+b.getname()+"\nAge : "+b.age()+"\nGender : "+b.gender()+"\nMatri : "+b.matri());
			//System.out.println("ALG3 :"+g.getalg3() + "\nAP3 :"+g.getap3()+"\nIS3 "+g.getis3()+"\nPSD3 :" +g.getpsd3() );
		}
		
	}
}
