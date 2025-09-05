package eCommerceOrder;

abstract class Order {
	int orderId;
	String customerName;
	double amount;
	
	abstract void generateInvoice();
}
