package shoppingCartManagement;

public class Main {
	
	public static void main(String[] args) {
		CartManager cm = new CartManager();
		
		cm.addProduct(1001, 1, 34, "A");
		cm.addProduct(1002, 2, 35, "M");
		cm.addProduct(1003, 3, 36, "U");
		cm.addProduct(1004, 4, 37, "N");
		cm.addProduct(1005, 5, 38, "K");
		
		cm.viewCart();
		
		cm.getTotalBill();
		cm.updateProduct(1002, 32, 7);
		cm.getTotalBill();
		cm.viewCart();
		cm.deleteProduct(1002);
		cm.viewCart();
		cm.getTotalBill();
	}
}
