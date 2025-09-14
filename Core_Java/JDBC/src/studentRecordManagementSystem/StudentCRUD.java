package studentRecordManagementSystem;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class StudentCRUD {
	ArrayList<StudentRecords> students;
	void create(Scanner sc, String fileName) {
		System.out.println("How many students data you want to enter:- ");
		students = new ArrayList<>();
		int num = sc.nextInt();
		int id;
		double marks;
		String name, course;
		for(int i=0; i< num; i++) {
			System.out.println("Enter Student's Id:-");
			id = sc.nextInt();
			sc.nextLine();
			System.out.println("Enter Student's Name:-");
			name = sc.nextLine();
			System.out.println("Enter Student's Marks:-");
			marks = sc.nextDouble();
			System.out.println("Enter Student's Course Name:-");
			course = sc.next();
			students.add(new StudentRecords(id, marks, name, course));
		}
		
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(students);
			oos.close();
			System.out.println("Did it");
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
	}
	
	ArrayList<StudentRecords> read(String fileName, boolean update) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			students = (ArrayList<StudentRecords>) ois.readObject();
			if(update) return students;
			else {
				for(StudentRecords sr : students) {
					System.out.println(sr);
				}
			}
			ois.close();
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
		return null;
	}
	
	void update(String fileName, Scanner sc) {
		StudentCRUD scrud = new StudentCRUD();
		ArrayList<StudentRecords> students =  scrud.read(fileName, true);
		System.out.println("Enter student's id whose data you want to update:-");
		int id = sc.nextInt();
		for(StudentRecords sr : students) {
			if(sr.getId() == id) {
				System.out.println("Do you want to update id:-\n"
						+ "a.)Yes\t\tb.)No");
				if(sc.next().charAt(0)== 'a') {
					System.out.println("Enter the new id:-");
					sr.setVars(sc.nextInt());
				}
				System.out.println("Do you want to update name:-\n"
						+ "a.)Yes\t\tb.)No");
				if(sc.next().charAt(0)== 'a') {
					sc.nextLine();
					System.out.println("Enter the new name:-");
					sr.setVars(sc.nextLine());
				}
				System.out.println("Do you want to update marks:-\n"
						+ "a.)Yes\t\tb.)No");
				if(sc.next().charAt(0)== 'a') {
					System.out.println("Enter the new marks:-");
					sr.setVars(sc.nextDouble());
				}
				System.out.println("Do you want to update course:-\n"
						+ "a.)Yes\t\tb.)No");
				if(sc.next().charAt(0)== 'a') {
					System.out.println("Enter the new name:-");
					sc.nextLine();
					sr.setCourse(sc.nextLine());
				}
			}
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(students);
			oos.close();
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
	}
	
	void delete(String fileName, Scanner sc) {
		StudentCRUD scrud = new StudentCRUD();
		ArrayList<StudentRecords> students =  scrud.read(fileName, true);
		System.out.println("Enter student's id whose data you want to delete:-");
		int id = sc.nextInt();
		ArrayList<StudentRecords> newStudents = new ArrayList<>();
		for(StudentRecords sr : students) {
			if(sr.getId() == id) continue;
			newStudents.add(sr);
		}
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(newStudents);
			oos.close();
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
	}
	
	public static void main(String[] args) {
		StudentCRUD scrud = new StudentCRUD();
		Scanner sc = new Scanner(System.in);
		boolean looping = true;
		String fileName = "studentRecords.dat";
		while(looping) {
			System.out.println("What operation would you like to perform:-\n"
					+ "1.)Create Student\t\t2.)View All Student\n"
					+ "3.)Update Student\t\t4.)Delete Student\n"
					+ "\t\t5.)Exit");
			switch(sc.nextInt()) {
				case 1:
					scrud.create(sc, fileName);
					break;
				case 2:
					scrud.read(fileName, false);
					break;
				case 3:
					scrud.update(fileName, sc);
					break;
				case 4:
					scrud.delete(fileName, sc);
					break;
				case 5:
					looping = false;
					break;
				default:
					System.out.println("Invalid option selected.");
					break;
			}
		}
	}
}
