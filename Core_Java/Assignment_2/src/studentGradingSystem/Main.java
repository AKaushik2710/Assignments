package studentGradingSystem;

class Student{
	String name;
	int marks;
	
	void showDetails() {
		System.out.println("Student's name:- "+name);
		System.out.println("Student's marks:- "+marks);
	}
}

class GraduateStudent extends Student{
	String specialization;
	
	GraduateStudent(String name, int marks, String specialization){
		this.name = name;
		this.marks = marks;
		this.specialization = specialization;
	}
	
	void checkPass() {
		if(marks>=50) {
			System.out.println("Student is Pass");
		}
		else {
			System.out.println("Student is Fail");
		}
	}
}
public class Main {
	
	public static void main(String[] args) {
		GraduateStudent gs = new GraduateStudent("Aman", 98, "DAC");
		gs.showDetails();
		gs.checkPass();
	}
}

