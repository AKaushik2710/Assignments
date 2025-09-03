package carDriving;

interface MyCar{
	void steeringWheel(boolean right);
	void accelerator();
	void brake();
	void gear(int gear);
}

public class Car implements MyCar{
	public void steeringWheel(boolean right) {
		if(right) System.out.println("Turning right.");
		else System.out.println("Turning left");
	}
	
	public void accelerator() {
		System.out.println("Accelerator has been pressed, Speed Will Increase.");
	}
	
	public void brake() {
		System.out.println("Brakes has been pressed, Car will stop.");
	} 
	
	public void gear(int gear) {
		System.out.println("Gear has been shifted to "+gear);
	}
}
