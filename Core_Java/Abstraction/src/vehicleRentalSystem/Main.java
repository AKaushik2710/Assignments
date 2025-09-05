package vehicleRentalSystem;

public class Main {
	public static void main(String[] args) {
		Car c = new Car(1001, 1005.5);
		Bike b = new Bike(1002, 600.4);
		
		c.calculateRent(4);
		b.calculateRent(2);
	}
}
