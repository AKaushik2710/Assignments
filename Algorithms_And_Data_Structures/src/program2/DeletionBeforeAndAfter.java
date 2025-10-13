package program2;

import program_1.Node;

public class DeletionBeforeAndAfter {
	static void beforeDel(int len, Node head, int num) {
		int count=1;
		Node temp=head;
		while(count<=len) {
			if(num-1==count) {
				head=head.next;
				count++;
				continue;
			}
			else if(num-1==0 && head.next==temp) {
				head=head.next;
				count++;
				continue;
			}
			count++;
			System.out.println(head.val);
			head=head.next;
		}
	}
	static void afterDel(int len, Node head, int num) {
		int count = 1;
		Node temp=head;
		
		while(count<=len) {
			if(count-1==num) {
				head = head.next;
				count++;
				continue;
			}
			else if(num==len && count==1) {
				head=head.next;
				count++;
				continue;
			}
			System.out.println(head.val);
			head=head.next;
			count++;
		}
	}
	public static void main(String[] args) {
		Node head = new Node(10);
		head.next = new Node(20);
		head.next.next = new Node(30);
		head.next.next.next = new Node(40);
		head.next.next.next.next = new Node(50);
		head.next.next.next.next.next = new Node(60);
		head.next.next.next.next.next.next = head;
//		beforeDel(6, head, 3);
		afterDel(6, head, 5);
	}
}
