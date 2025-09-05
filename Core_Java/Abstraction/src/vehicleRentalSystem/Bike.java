package vehicleRentalSystem;

public class Bike extends Vehicle {

	Bike(int number, double rent){
		this.vehicleNumber = number;
		this.rentalPrice = rent;
	}
	void calculateRent(int days) {
		System.out.println("Total rent amounted to "+this.rentalPrice*days);
	}

}
