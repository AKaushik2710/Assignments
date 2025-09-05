package foodDeliverySystem;

interface FoodDelivery {
	void placeOrder(String item, int quantity);
	void cancelOrder(int orderId);
	void trackOrder(int orderId);
}
