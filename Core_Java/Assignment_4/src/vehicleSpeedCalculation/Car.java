package vehicleSpeedCalculation;

public class Car extends Vehicle{
	Car(String brand, double maxSpeed){
		super(brand, maxSpeed);
	}
	
	void showTopSpeed() {
		System.out.println("The Car's speed goes upto "+this.maxSpeed);
	}
}
