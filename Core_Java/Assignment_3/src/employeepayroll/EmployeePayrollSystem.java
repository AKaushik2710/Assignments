package employeepayroll;

public class EmployeePayrollSystem {
	int empId;
	String name;
	float basicSalary;
	
	EmployeePayrollSystem(int empId, String name, float basicSalary){
		this.empId = empId;
		this.name = name;
		this.basicSalary = basicSalary;
	}
	
	public float grossSalary() {
		float grossSalary = this.basicSalary  + (this.basicSalary*0.4f)+(this.basicSalary*0.55f);
		return grossSalary;
	}
}
