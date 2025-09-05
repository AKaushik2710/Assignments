package vehicleRentalSystem;

public class Car extends Vehicle{
	Car(int number, double rent){
		this.vehicleNumber = number;
		this.rentalPrice = rent;
	}
	
	void calculateRent(int days) {
		System.out.println("Total Rental Price amounted to "+this.rentalPrice*days);
	}
}
