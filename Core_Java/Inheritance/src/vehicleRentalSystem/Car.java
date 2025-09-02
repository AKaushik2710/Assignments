package vehicleRentalSystem;

public class Car extends Vehicle {
	Car(int id, String brand, int rent){
		super(id, brand, rent);
	}
	
	void calculateRental(int days) {
		System.out.println("The total rent amounted to be "+this.rentPerDay*days);
	}
}
