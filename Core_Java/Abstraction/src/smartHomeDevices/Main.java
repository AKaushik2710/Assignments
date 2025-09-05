package smartHomeDevices;

public class Main {
	public static void main(String[] args) {
		Light bulb = new Light(1001, State.Off);
		Fan ceiling = new Fan(1002, State.On);
		
		bulb.getStatus();
		ceiling.getStatus();
		bulb.turnOn();
		bulb.getStatus();
		bulb.turnOff();
		bulb.getStatus();
		ceiling.turnOff();
		ceiling.getStatus();
		ceiling.turnOn();
		ceiling.getStatus();
	}
}
