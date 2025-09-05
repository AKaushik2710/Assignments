package eCommerceOrder;

public class StoreOrder extends Order{
	StoreOrder(int id, String name, double amount){
		this.orderId = id;
		this.customerName = name;
		this.amount = amount;
	}
	
	void generateInvoice() {
		double finalPrice;
		if(this.amount>500) finalPrice = this.amount - this.amount*0.1;
		else finalPrice = this.amount - this.amount*0.05;
		System.out.println("Your invoice generated amount comes down to "+finalPrice);
	}
}
