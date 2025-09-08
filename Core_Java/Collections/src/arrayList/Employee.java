package arrayList;

public class Employee {
	int eid;
	String ename;
	double salary;
	Employee(int id, String name, double salary){
		this.eid = id;
		this.ename = name;
		this.salary = salary;
	}
	
	@Override
	public String toString() {
		return "Employee Id is "+this.eid+", Name is "+this.ename+", and Salary is "+this.salary;
	}
}
