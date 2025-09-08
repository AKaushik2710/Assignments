package stack;
import java.util.Stack;
public class MyStack {
	public static void main(String[] args) {
		Stack<Double> temp = new Stack<>();
		
		temp.push(23.3);
		temp.push(123.2);
		temp.push(45.5);
		temp.push(34.67);
		temp.push(12.2);
		
		System.out.println("Poppped values are "+temp.pop()+","+temp.pop());
		
		System.out.println("Current top element is "+temp.peek());
		System.out.println(temp);
		String emptiness = temp.isEmpty() ? "empty" : "not empty.";
		System.out.println("The stack is "+emptiness);
	}
}
