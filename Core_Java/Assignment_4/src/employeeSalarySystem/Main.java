package employeeSalarySystem;

public class Main {
	public static void main(String[] args) {
		Manager m = new Manager("M1", 23000);
		SoftwareEngineer se = new SoftwareEngineer("SE1", 35000);
		m.calculateSalary();
		se.calculateSalary();
	}
}
