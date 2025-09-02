package employeepayroll;

public class Main {

	public static void main(String[] args) {
		EmployeePayrollSystem eps = new EmployeePayrollSystem(1001,"Aman",50000);
		System.out.println("The gross Salary of employee is "+eps.grossSalary());
	}

}
