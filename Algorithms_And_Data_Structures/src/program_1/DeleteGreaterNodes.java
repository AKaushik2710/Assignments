package program_1;

import java.util.Scanner;

class Node {
	public int val;
	public Node next;
	public Node(int val){
		this.val = val;
		this.next = null;
	}
}

public class DeleteGreaterNodes {
	static Node nodeDeleter(Node head) {
		Node temp = head;
		Node myHead = head;
		Node res = head;
		Node prev = head;
		boolean great=false;
		while(temp!=null && temp.next!=null) {
			if(temp.val<temp.next.val) {
				res = temp.next;
				prev.next = temp.next;
				great=true;
				break;
			}
			prev = temp;
			res=res.next;
			temp=temp.next;
		}
		
		if( (myHead !=null && myHead.next!=null) && (myHead.val<myHead.next.val) ) {
			res=myHead.next;
		}
		else res=myHead;
		
		if(great) res = nodeDeleter(res);
		return res;
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
		
		int[] vals = new int[length];
		String[] adders = nodes.split(" ");
		int pointer = 0;
		for(String str : adders) {
			vals[pointer++] = Integer.parseInt(str);
		}
		
		Node head = headCreator(vals);
		
		Node otp = nodeDeleter(head);
		
		while(otp!=null) {
			System.out.println(otp.val);
			otp=otp.next;
		}
	}
}
