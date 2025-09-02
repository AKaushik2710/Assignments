package onlineShoppingCart;

import java.util.Random;

public class Main {
	public static void main(String[] args) {
		Random r = new Random();
		ShoppingCart sCart = new ShoppingCart(r);
		System.out.println("Your total amount comes down to:- Rs."+sCart.total());
	}
}
