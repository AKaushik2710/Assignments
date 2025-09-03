package restaurantMenu;

abstract class FoodItems{
	String[] menuItems = {"samosa","kachori","burger", "pizza"};
	int[] itemPrices = {15, 20, 30, 80};
	abstract void viewMenu();
}
public class Menu extends FoodItems{
	void viewMenu() {
		for(int  i=0; i< this.menuItems.length; i++) {
			System.out.println(this.menuItems[i]+"\t\t\t"+this.itemPrices[i]);
		}
	}
}
