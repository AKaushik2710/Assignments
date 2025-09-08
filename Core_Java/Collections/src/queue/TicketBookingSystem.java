package queue;
import java.util.PriorityQueue;
public class TicketBookingSystem {
	public static void main(String[] args) {
		PriorityQueue<Integer> ticketQueue  = new PriorityQueue<>();
		
		ticketQueue.add(1001);
		ticketQueue.add(1002);
		ticketQueue.add(1003);
		ticketQueue.add(1004);
		ticketQueue.add(1005);
		
		System.out.println("First 2 Dequeued customers are "+ticketQueue.poll()+","+ticketQueue.poll());
		
		System.out.println("First customer is "+ticketQueue.peek());
		
		String emptiness = ticketQueue.isEmpty() ? "empty" : "not empty";
		System.out.println("The queue is "+emptiness);
	}
}
