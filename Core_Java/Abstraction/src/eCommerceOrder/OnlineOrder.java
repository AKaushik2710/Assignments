package eCommerceOrder;

public class OnlineOrder extends Order{
	OnlineOrder(int id, String name, double amount){
		this.orderId = id;
		this.customerName = name;
		this.amount = amount;
	}
	
	void generateInvoice() {
		double deliveryPrice = this.amount + 22.5;
		if(this.amount<500)System.out.println("Your invoice generated amount is "+deliveryPrice);
		else System.out.println("Your invoice generated amount is "+this.amount);
	}
}
