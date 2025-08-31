package shoppingCartManagement;
import java.util.Arrays;
public class CartManager {
	Product[] p = new Product[5];
	static int productIndex=0;
	
	void addProduct(int id, int quantity, double price, String name) {
		p[productIndex++] = new Product(id, quantity, name, price);
	}
	
	void viewCart() {
		for(int i=0; i<p.length; i++) {
			System.out.println("Product Id is "+p[i].productId);
			System.out.println("Product name is "+p[i].productName);
			System.out.println("Product price is "+p[i].price);
			System.out.println("Product quantity is "+p[i].quantity+"\n");
		}
	}
	
	void updateProduct(int id, double price, int quantity) {
		for(int i=0; i<p.length; i++) {
			if(p[i].productId == id) {
				if(price>0 && quantity>0) {
					p[i].price = price;
					p[i].quantity = quantity;
				}
				else if(price > 0) p[i].price = price;
				else if(quantity>0) p[i].quantity = quantity;
				else break;
			}
		}
	}
	
	void deleteProduct(int id) {
		Product[] tempArr = new Product[p.length];
		int deleteIndex = 0;
		for(int i=0; i<p.length; i++) {
			if(p[i].productId == id) {
				continue;
			}
			else {
				tempArr[deleteIndex++] = p[i];
			}
		}
		
		p = Arrays.copyOf(tempArr, p.length-1);
	}
	
	void getTotalBill() {
		double totalPrice =0;
		for(int i=0; i<p.length; i++) {
			totalPrice += p[i].price * p[i].quantity;
		}
		
		System.out.println("The total bill for your cart items is "+totalPrice);
	}
}
