package vehicleRentalSystem;

abstract class Vehicle {
	int vehicleNumber;
	double rentalPrice;
	
	abstract void calculateRent(int days);
}
