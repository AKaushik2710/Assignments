package onlinePaymentSystem;

interface Payment {
	void processPayment(double amount);
	void refund(double amount);
}
