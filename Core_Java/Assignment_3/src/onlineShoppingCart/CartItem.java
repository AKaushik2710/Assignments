package onlineShoppingCart;

public class CartItem {
	int itemId, quantity;
	String itemName;
	float price;
	
	CartItem(int itemId, int quantity, String itemName, float price){
		this.itemId = itemId;
		this.quantity = quantity;
		this.itemName = itemName;
		this.price = price;
	}
}
