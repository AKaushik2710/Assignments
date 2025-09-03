package employeeSalarySystem;

public class Manager extends Employee{
	Manager(String name, double basicSalary){
		super(name, basicSalary);
	}
	
	void calculateSalary() {
		double finalSal = this.basicSalary+this.basicSalary*0.2;
		System.out.println("Salary is "+finalSal);
	}
}
