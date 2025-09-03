package appliancePowerConsumption;

public class Refrigerator extends Appliance{
	Refrigerator(String name, double power){
		super(name, power);
	}
	
	void showConsumption(int hours) {
		System.out.println("The power consumption for refrigerator is "+this.power*hours);
	}
}
