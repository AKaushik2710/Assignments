package appliancePowerConsumption;

public class Main {
	public static void main(String[] args) {
		Fan f = new Fan("Havells", 2);
		Refrigerator r = new Refrigerator("Whirlpool", 3);
		AirConditioner ac = new AirConditioner("Godrej", 12);
		
		f.showConsumption(10);
		r.showConsumption(24);
		ac.showConsumption(4);
	}
}
