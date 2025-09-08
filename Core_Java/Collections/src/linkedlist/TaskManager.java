package linkedlist;
import java.util.LinkedList;
import java.util.Scanner;
public class TaskManager {
	public static void main(String[] args) {
		LinkedList<Integer> taskList = new LinkedList<>();
		
		taskList.add(1001);
		taskList.add(1002);
		taskList.add(1003);
		taskList.add(1004);
		taskList.add(1005);
		
		taskList.addFirst(1000);
		taskList.addLast(1006);
		taskList.remove(taskList.size()/2);
		System.out.println(taskList);
		System.out.println("The first task is "+taskList.getFirst());
		System.out.println("The last task is "+taskList.getLast());
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter the task priority you want to check whether exists or not:-");
		int inp = sc.nextInt();
		String containment = taskList.contains(inp) ? "exist" : "not  exist";
		System.out.println("The task with priority "+inp+" does "+containment);
	}
}
