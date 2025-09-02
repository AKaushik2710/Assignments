package vehicleSystem;

class Vehicle{
	String brand;
	int fuel;
	
	void refuel(int litres) {
		fuel += litres;
	}
}

class Car extends Vehicle{
	int mileage;
	
	Car(String name,  int mileage){
		this.brand = name;
		this.mileage = mileage;
	}
	int calculateTravelDistance() {
		return mileage * fuel;
	}
}
public class Main {
	
	public static void main(String[] args) {
		Car myCar = new Car("Tata", 23);
		System.out.println("Properties of car "+myCar.brand + " "+ myCar.fuel + " "+ myCar.mileage+" "+myCar.calculateTravelDistance());
		myCar.refuel(45);
		System.out.println(myCar.calculateTravelDistance());
	}
	
}
