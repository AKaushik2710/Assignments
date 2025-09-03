package appliancePowerConsumption;

public class Fan extends Appliance{
	Fan(String name, double power){
		super(name, power);
	}
	
	void showConsumption(int hours) {
		System.out.println("The power consumption for fan is "+this.power*hours);
	}
}
