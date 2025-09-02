package productBillingSystem;

class Product{
	String productName;
	float price;
	void showProduct() {
		System.out.println("Product's name - "+productName);
		System.out.println("Product's price - "+price);
	}
}

class DiscountedProduct extends Product{
	float discountRate;
	DiscountedProduct(String name, float price, float discountRate){
		this.productName = name;
		this.price = price;
		this.discountRate = discountRate;
	}
	void calculateFinalPrice() {
		float finalPrice = price - (price*(discountRate/100));
		System.out.println("Your discounted price is "+finalPrice);
	}
}
public class Main {

	public static void main(String[] args) {
		DiscountedProduct dp = new DiscountedProduct("Soap", 26.33f, 7);
		dp.showProduct();
		dp.calculateFinalPrice();
	}
}

