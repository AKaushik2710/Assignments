package employeeSalarySystem;

public class SoftwareEngineer extends Employee{
	SoftwareEngineer(String name, double basicSalary){
		super(name, basicSalary);
	}
	
	void calculateSalary() {
		double finalSal = this.basicSalary+this.basicSalary*0.15;
		System.out.println("Salary is "+finalSal);
	}
}
