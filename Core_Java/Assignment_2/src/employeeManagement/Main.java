package employeeManagement;

class Employee{
	String name;
	double salary;
	
	void displayDetails() {
		System.out.println("Name of Employee - "+this.name);
		System.out.println("Salary of Employee - "+this.salary);
	}
	
}

class Manager extends Employee{
	int teamSize;
	Manager(String name, double salary, int teamSize){
		this.name = name;
		this.salary = salary;
		this.teamSize = teamSize;
	}
	double calculateBonus() {
		if(teamSize>50) {
			return salary+(salary*0.15);
		}
		else if(teamSize>30) {
			return salary+(salary*0.1);
		}
		else if(teamSize>10) {
			return salary+(salary*0.05);
		}
		else {
			return salary;
		}
	}
}
public class Main {

	public static void main(String[] args) {
		Manager m = new Manager("Aman", 43560.45,35);
		m.displayDetails();
		System.out.println("Your salary for this month including bonus is "+m.calculateBonus());
	}
}
