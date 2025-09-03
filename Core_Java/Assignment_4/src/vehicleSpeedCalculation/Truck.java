package vehicleSpeedCalculation;

public class Truck extends Vehicle{
	Truck(String brand, double maxSpeed){
		super(brand, maxSpeed);
	}
	
	void showTopSpeed() {
		System.out.println("The Truck's speed goes upto "+this.maxSpeed);
	}
}
