package vehicleRentalSystem;

public class Bike extends Vehicle{
	Bike(int id, String brand, int rent){
		super(id, brand, rent);
	}
	
	void calculateRental(int days) {
		System.out.println("The rental amount came to be "+this.rentPerDay*days);
	}
}
