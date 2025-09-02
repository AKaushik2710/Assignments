package ecommerceStore;

public class Clothing extends Product{
	Clothing(int id, double price, String name){
		super(id, price, name);
	}
	
	void applyDiscount(double percentage) {
		double finalPrice = this.price - this.price*(percentage/100);
		System.out.println("Price of product "+this.name+" has been reduced to "+finalPrice);
	}
}
