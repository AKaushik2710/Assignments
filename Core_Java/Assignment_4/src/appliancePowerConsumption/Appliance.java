package appliancePowerConsumption;

public class Appliance {
	String name;
	double power;
	Appliance(String name, double power){
		this.name = name;
		this.power = power;
	}
	void showConsumption(int hours) {
		System.out.println("The power consumption is "+this.power*hours);
	}
}
