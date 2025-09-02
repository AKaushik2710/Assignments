package studentResult;

public class Student {
	int rollNo;
	String name;
	int eng,hindi,math;
	
	Student(int rollNo,int eng,int hindi,int math, String name){
		this.rollNo = rollNo;
		this.eng = eng;
		this.hindi = hindi;
		this.math = math;
		this.name =   name;
	}
	
	public float averageMarks() {
		return (this.eng+this.hindi+this.math)/3;
	}
	
	public void gradeCalculator() {
		float marks = this.averageMarks();
		if(marks>=90) {
			System.out.println("Student got \"A\" grade");
		}
		else if(marks >=70) {
			System.out.println("Student got \"B\" grade");
		}
		else if(marks > 40) {
			System.out.println("Student got \"C\" grade");
		}
		else {
			System.out.println("Student got \"F\" grade");
		}
	}
}
