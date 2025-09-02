package onlineShoppingCart;
import java.util.Random;

public class ShoppingCart {
CartItem[] ci = new CartItem[3];
	
	ShoppingCart(Random r) {
		for(int i=0; ci.length>i; i++) {
			int id = r.nextInt(10);
			int name = r.nextInt(100);
			int quantity = r.nextInt(100);
			float price =  r.nextFloat(1000);
			ci[i] = new CartItem(id, quantity, "AK"+name, price);
		}
	}
	
	public float total() {
		float total=0;
		for(int i=0; i<ci.length; i++) {
			total += ci[i].quantity*ci[i].price;
		}
		if(total>2000) {
			total = total - total*0.3f;
		}
		else if(total >1000) {
			total = total - total*0.15f;
		}
		else if(total > 500) {
			total = total - total*0.6f;
		}
		
		return total;
	}
}
