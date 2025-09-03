package appliancePowerConsumption;

public class AirConditioner extends Appliance{
	AirConditioner(String name, double power){
		super(name, power);
	}
	
	void showConsumption(int hours) {
		System.out.println("The power consumption for AC is "+this.power*hours);
	}
}
