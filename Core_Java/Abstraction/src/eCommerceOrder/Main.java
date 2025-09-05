package eCommerceOrder;

public class Main {
	public static void main(String[] args) {
		OnlineOrder order1 = new OnlineOrder(1001, "John", 345.56);
		StoreOrder order2 = new StoreOrder(1002, "Doe", 567.8);
		
		order1.generateInvoice();
		order2.generateInvoice();
	}
}
