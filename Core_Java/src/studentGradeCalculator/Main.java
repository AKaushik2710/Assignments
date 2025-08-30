package studentGradeCalculator;

import java.util.Scanner;
public class Main {
	
	static void calculateGrade(int marks) {
		if(marks>=90) {
			System.out.println("Student got A grade");
		}
		else if(marks>=80) System.out.println("Student got B grade");
		else if(marks>=70) System.out.println("Student got C grade");
		else if(marks>=40) System.out.println("Student got D grade");
		else System.out.println("Student got F grade");
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter marks of the student:- ");
		int marks = sc.nextInt();
		sc.close();
		calculateGrade(marks);
	}
}
