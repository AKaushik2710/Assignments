package arrayList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

class SortById implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2) {
		return Integer.compare(e1.eid, e2.eid);
	}
}
class SortByName implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2) {
		return e1.ename.compareTo(e1.ename);
	}
}

class SortBySalary implements Comparator<Employee>{
	public int compare(Employee e1, Employee e2) {
		return Double.compare(e1.salary, e2.salary);
	}
}
public class EmployeeSortingSystem {
	public static void main(String[] args) {
		ArrayList<Employee> emp = new ArrayList<Employee>();
		emp.add(new Employee(103, "Aman", 55000));
        emp.add(new Employee(101, "Kaushik", 60000));
        emp.add(new Employee(105, "Meera", 45000));
        emp.add(new Employee(102, "Raj", 70000));
        emp.add(new Employee(104, "Zara", 50000));
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose sorting method:-");
        System.out.println("1. By ID\t2.By Name");
        System.out.println("\t3. By Salary");
        
        int choice = sc.nextInt();
        sc.close();
        switch(choice) {
        case 1:
        	Collections.sort(emp, new SortById());
        	break;
        case 2:
        	Collections.sort(emp, new SortByName());
        	break;
        case 3:
        	Collections.sort(emp, new SortBySalary());
        	break;
        	default:
        		System.out.println("Invalid Choice.");
        		
        }
        
        for(Employee e : emp) {
        	System.out.println(e);
        }
	}
}
