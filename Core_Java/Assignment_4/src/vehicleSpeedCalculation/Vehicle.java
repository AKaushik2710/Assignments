package vehicleSpeedCalculation;

public class Vehicle {
	String brand;
	double maxSpeed;
	Vehicle(String brand, double maxSpeed){
		this.brand = brand;
		this.maxSpeed = maxSpeed;
	}
	
	void showTopSpeed() {
		System.out.println("The speed goes upto "+this.maxSpeed);
	}
}
