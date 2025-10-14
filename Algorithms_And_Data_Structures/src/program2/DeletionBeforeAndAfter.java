package program2;
import java.util.Scanner;

import program_1.Node;

public class DeletionBeforeAndAfter {
	static void beforeDel(int len, Node head, int num) {
		int count=1;
		while(count<=len) {
			if(count%len+1 == num) {
				head = head.next;
				count++;
				continue;
			}
			count++;
			System.out.print(head.val + " ");
			head = head.next;
		}
	}
	static void afterDel(int len, Node head, int num) {
		int count = 1;
		while(count<=len) {
			if(count-1 == num%len) {
				head = head.next;
				count++;
				continue;
			}
			System.out.print(head.val + " ");
			head = head.next;
			count++;
		}
		
	}
	
	static Node headCreator(int[] vals) {
		Node head = new Node(vals[0]);
		Node temp = head;
		for(int i = 1; i<vals.length; i++) {
			head.next = new Node(vals[i]);
			head = head.next;
		}
		
		return temp;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int length = sc.nextInt();
		sc.nextLine();
		String nodes = sc.nextLine();
		int num = sc.nextInt();
		
		int[] vals = new int[length];
		String[] adders = nodes.split(" ");
		int pointer = 0;
		for(String str : adders) {
			vals[pointer++] = Integer.parseInt(str);
		}
		
		Node head = headCreator(vals);
		beforeDel(length, head, num);
		System.out.println();
		afterDel(length, head, num);
	}
}
