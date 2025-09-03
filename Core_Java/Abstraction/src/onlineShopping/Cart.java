package onlineShopping;

import java.util.Arrays;

class Product{
	String name;
	double price;
	Product(String name, double price){
		this.name = name;
		this.price = price;
	}
}
interface CartFunctions{
	void addProduct(String name, double price);
	void placeOrder();
	void makePayment();
}
public class Cart implements CartFunctions{
	double cartPrice;
	double amount = 0;
	Product[] myCartProducts = new Product[0];
	public void addProduct(String name, double price) {
		Product[] myTempArr = new Product[myCartProducts.length+1];
		for(int i=0; i<myCartProducts.length; i++) {
			if(myCartProducts[i] == null) break;
			else {
				myTempArr[i] =  myCartProducts[i];
			}
		}
		myTempArr[myCartProducts.length] = new Product(name, price);
		myCartProducts = Arrays.copyOf(myTempArr, myTempArr.length);
	}
	
	public void placeOrder() {
		String finalString = "";
		for(int i=0; i<myCartProducts.length; i++) {
			amount+= myCartProducts[i].price;
			if(i==myCartProducts.length-1) finalString += myCartProducts[i].name + ". ";
			else finalString += myCartProducts[i].name + ", ";
		}
		System.out.println("Order amount of "+amount+" has been placed for products "+finalString);
	}
	
	public void viewCart() {
		for(int i=0; i<myCartProducts.length; i++) {
			System.out.println(myCartProducts[i].name + " "+myCartProducts[i].price);
		}
	}
	public void makePayment() {
		System.out.println("Payment of Rs."+amount+" has been completed.");
	}
}
