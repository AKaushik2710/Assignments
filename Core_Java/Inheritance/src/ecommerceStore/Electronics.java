package ecommerceStore;

public class Electronics extends Product{
	public Electronics(int id, double price, String name) {
		super(id, price, name);
	}
	
	void applyWarranty(int years) {
		System.out.println("Product "+this.productId + " has warranty of "+years+" years");
	}
}
