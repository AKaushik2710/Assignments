package vehicleSpeedCalculation;

public class Main {
	public static void main(String[] args) {
		Bike b = new Bike("KTM", 320.5);
		Car c = new Car("Bugatti", 450.2);
		Truck t = new Truck("Tata", 100);
		b.showTopSpeed();
		c.showTopSpeed();
		t.showTopSpeed();
	}
}
