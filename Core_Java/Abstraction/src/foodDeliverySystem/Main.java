package foodDeliverySystem;

public class Main {
	public static void main(String[] args) {
		SwiggyDelivery swiggy = new SwiggyDelivery(1001, 560.8, "Domino's", OrderState.Cooking);
		ZomatoDelivery zomato = new ZomatoDelivery(1002, 350, "Gulab's", OrderState.On_The_Way);
		SwiggyDelivery sw = new SwiggyDelivery(1003, 456.67, "Burger King", OrderState.Delivered);
		
		swiggy.placeOrder("Pizza", 2);
		swiggy.cancelOrder(1001);
		swiggy.trackOrder(1001);
		zomato.placeOrder("Kadhai Paneer", 1);
		zomato.cancelOrder(1002);
		zomato.trackOrder(1002);
		sw.placeOrder("Cheese Burger", 5);
		sw.cancelOrder(1003);
		sw.trackOrder(1003);
	}
}
