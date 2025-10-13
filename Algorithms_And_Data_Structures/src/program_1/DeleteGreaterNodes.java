package program_1;

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
	
	public static void main(String[] args) {
		Node head = new Node(12);
		head.next = new Node(15);
		head.next.next = new Node(10);
		head.next.next.next = new Node(11);
		head.next.next.next.next = new Node(5);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(3);
		head.next.next.next.next.next = new Node(6);
		head.next.next.next.next.next.next = new Node(2);
		head.next.next.next.next.next.next.next = new Node(3);
		
//		Node head = new Node(10);
//		head.next = new Node(20);
//		head.next.next = new Node(30);
//		head.next.next.next = new Node(40);
//		head.next.next.next.next = new Node(50);
		Node otp = nodeDeleter(head);
		
		while(otp!=null) {
			System.out.println(otp.val);
			otp=otp.next;
		}
//		System.out.println(temp.val + "jhj");
	}
}
