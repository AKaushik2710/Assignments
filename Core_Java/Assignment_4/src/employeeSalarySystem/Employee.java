package employeeSalarySystem;

public class Employee {
	String name;
	double basicSalary;
	Employee(String name, double basicSalary){
		this.name = name;
		this.basicSalary = basicSalary;
	}
	
	void calculateSalary() {
		System.out.println("Salary is "+this.basicSalary);
	}
}
