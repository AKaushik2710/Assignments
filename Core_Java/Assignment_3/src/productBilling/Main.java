package productBilling;
import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Product[] myProducts = new Product[3];
		Random r = new Random();
		for(int i=0; i<myProducts.length; i++) {
			float prod1 = r.nextFloat(1000);
			int prod2 = r.nextInt(10);
			myProducts[i] = new Product(2000+i, "Kaushik" + i, prod1, prod2);
		}
		for(int i=0; i<myProducts.length; i++) {
			System.out.println("The total price for "+ myProducts[i].productName+ " is "+ myProducts[i].totalPrice());
		}
		System.out.println("The total cumulative price for all the products present is "+ myProducts[0].totalProductPrice(myProducts));
	}
}
