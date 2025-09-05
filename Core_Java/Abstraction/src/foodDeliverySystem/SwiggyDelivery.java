package foodDeliverySystem;

public class SwiggyDelivery implements FoodDelivery{
	int orderId;
	String restaurantName;
	double price;
	OrderState status;
	boolean isCancelled;
	
	SwiggyDelivery(int id, double price, String name, OrderState status){
		this.orderId = id;
		this.price = price;
		this.restaurantName = name;
		this.status = status;
	}
	
	public void placeOrder(String item, int quantity) {
		double finalPrice = this.price*quantity - this.price*quantity*0.05;
		System.out.println("Order of "+item+" having quantity: "+quantity+" has been placed and total amount is "+finalPrice);
	}
	
	public void cancelOrder(int orderId) {
		if(this.status.equals(OrderState.Delivered));
		else {
			this.isCancelled = true;
			System.out.println("Cancellation of order id "+orderId+" has been processed.");
		}
	}
	
	public void trackOrder(int orderId) {
		if(!this.isCancelled)System.out.println("Your order having orderId is "+this.status);
		else System.out.println("Your order has been cancelled, so can't be tracked.");
	}
}
