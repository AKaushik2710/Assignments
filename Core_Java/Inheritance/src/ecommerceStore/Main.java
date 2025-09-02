package ecommerceStore;

public class Main {
	public static void main(String[] args) {
		Clothing c = new Clothing(1001, 740.34, "Jeans");
		Electronics e = new Electronics(1002, 450.5, "Iron");
		c.applyDiscount(12);
		e.applyWarranty(2);
	}
}
