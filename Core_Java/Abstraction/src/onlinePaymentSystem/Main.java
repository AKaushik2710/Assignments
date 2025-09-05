package onlinePaymentSystem;

public class Main {
	public static void main(String[] args) {
		CreditCardPayment credit = new CreditCardPayment(1001, 456213);
		UPIPayment upi = new UPIPayment(1002, 789564);
		
		credit.processPayment(560.80);
		credit.refund(345);
		upi.processPayment(456);
		upi.refund(546);
	}
}
