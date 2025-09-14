package studentRecordManagementSystem;

import java.io.Serializable;

public class StudentRecords implements Serializable{
	private int id;
	private double marks;
	private String name, course;
	public StudentRecords(int id, double marks, String name, String course) {
		this.id = id;
		this.marks = marks;
		this.name = name;
		this.course = course;
	}
	
	@Override
	public String toString() {
		return "Student's Name is " + this.name + ", Id is "+ this.id+", Course is " +this.course+", Marks are " + this.marks;
	}
	
	public int getId() {
		return this.id;
	}
	
	public void setVars(double marks) {
		this.marks = marks;
	}
	
	public void setVars(int id) {
		this.id = id;
	}
	
	public void setVars(String name) {
		this.name = name;
	}
	
	public void setCourse(String course) {
		this.course = course;
	}
	
	public char getMarks() {
		if(this.marks > 90) return 'A';
		else if(this.marks > 80) return 'B';
		else if(this.marks > 70) return 'C';
		else if(this.marks > 50) return 'D';
		else if(this.marks > 30) return 'E';
		else return 'F';
	}
}
