package chatHandler;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;

class Prod implements Serializable{
	private int id;
	private String name;
	Prod(int id, String nm){
		this.id = id;
		this.name = nm;
	}
	
	@Override
	public String toString() {
		return this.id + this.name;
	}
}
public class FileShareFunc {
	<T>void writeToFile(String fileName, ArrayList<T> myArr) {
		try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))){
			oos.writeObject(myArr);
			oos.close();
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
	}
	
	<T> void readFromFile(String fileName) {
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))){
			ArrayList<T> myArr = (ArrayList<T>) ois.readObject();
			System.out.println(myArr.get(0));
			ois.close();
			
		}
		catch(Exception e) {
			System.out.println("Following exception occured:- "+e);
		}
	}
	
	public static void main(String[] args) {
		Prod p1 = new Prod(1001, "Prod1");
		System.out.println(p1);
		Prod p2 = new Prod(1002, "Prod2");
		
		FileShareFunc fsf = new FileShareFunc();
		fsf.writeToFile("product", new ArrayList<Prod>(Arrays.asList(p1,p2)));
		fsf.readFromFile("product");
	}
}
