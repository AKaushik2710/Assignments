package productBilling;

public class Product {
	int productId, quantity;
	String productName;
	float price;
	
	Product(int productId, String productName, float price, int quantity){
		this.productId = productId;
		this.productName = productName;
		this.price = price;
		this.quantity = quantity;
	}
	
	public float totalPrice() {
		return this.price*this.quantity;
	}
	
	public float totalProductPrice(Product[] price) {
		float totalPrice=0;
		for(int i=0; i<price.length; i++) {
			totalPrice+=price[i].totalPrice();
		}
		return totalPrice;
	}
}
