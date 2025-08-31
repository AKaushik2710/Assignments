package shoppingCartManagement;

public class Product {
	int productId, quantity;
	String productName;
	double price;
	static int productCount;
	Product(int id, int quantity, String name, double price){
		this.productId  = id;
		this.quantity = quantity;
		this.productName = name;
		this.price = price;
		productCount +=quantity;
	}
}
