package vehicleRentalSystem;

public class Vehicle {
	int vehicleId;
	String brand;
	int rentPerDay;
	Vehicle(int id, String brand, int rent){
		this.vehicleId = id;
		this.brand = brand;
		this.rentPerDay = rent;
	}
}
