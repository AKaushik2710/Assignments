package educationalInstitute;

public class Main {
	public static void main(String[] args) {
		Student s1 = new Student(1001, 12, "A");
		Student s2 = new Student(1002, 11, "B");
		Teacher t1 = new Teacher(1003, 28, "C");
		s1.calculateGrade(47);
		s2.calculateGrade(87);
		t1.calculateSalary(38, 500);
	}
}
