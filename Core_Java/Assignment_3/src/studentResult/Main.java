package studentResult;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		Student[] myStudents = new Student[3];
		Random r = new Random();
		for(int i=0; i<myStudents.length; i++) {
			int sub1 = r.nextInt(100);
			int sub2 = r.nextInt(100);
			int sub3 = r.nextInt(100);
			myStudents[i] = new Student(i,sub1,sub2,sub3,"AK"+i+1);
		}
		for(int j=0; j<myStudents.length; j++) {
			System.out.println("Average marks of student "+ myStudents[j].name + " is " +myStudents[j].averageMarks());
			myStudents[j].gradeCalculator();
		}
	}

}
