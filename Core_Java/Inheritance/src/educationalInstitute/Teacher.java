package educationalInstitute;

public class Teacher extends Person{
	Teacher(int id, int age, String name){
		super(id, age, name);
	}
	
	void calculateSalary(int hoursWorked, int ratePerHour) {
		System.out.println("Salary is "+hoursWorked*ratePerHour);
	}
}
