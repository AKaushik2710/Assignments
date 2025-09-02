package vehicleRentalSystem;

public class Main {

	public static void main(String[] args) {
		Car c = new Car(1001, "KIA", 2000);
		Bike b = new Bike(1002, "Royal Enfield", 1000);
		c.calculateRental(6);
		b.calculateRental(4);
	}

}
