package educationalInstitute;

public class Student extends Person{
	Student(int id, int age, String name){
		super(id, age, name);
	}
	
	void calculateGrade(int marks) {
		if(marks>90) {
			System.out.println("Student got A grade");
		}
		else if(marks>80) {
			System.out.println("Student got B grade");
		}
		else if(marks>70) {
			System.out.println("Student got C grade");
		}
		else if(marks>60) {
			System.out.println("Student got D grade");
		}
		else if(marks>40) {
			System.out.println("Student got E grade");
		}
		else {
			System.out.println("Student got F grade");
		}
	}
}
