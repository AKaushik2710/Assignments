package onlineShopping;

public class Main {
	public static void main(String[] args) {
		Cart c = new Cart();
		c.addProduct("abg", 340);
		c.viewCart();
		c.addProduct("Shoes", 345.23);
		c.viewCart();
		c.placeOrder();
		c.makePayment();
	}
}
