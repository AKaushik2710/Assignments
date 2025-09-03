package vehicleSpeedCalculation;

public class Bike extends Vehicle{
	Bike(String brand, double maxSpeed){
		super(brand, maxSpeed);
	}
	
	void showTopSpeed() {
		System.out.println("The Bike's speed goes upto "+this.maxSpeed);
	}
}
