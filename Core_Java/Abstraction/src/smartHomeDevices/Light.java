package smartHomeDevices;

public class Light implements SmartDevice{
	int deviceId;
	State status;
	Light(int id, State status){
		this.deviceId = id;
		this.status = status;
	}
	
	public void turnOn() {
		this.status = State.On;
		System.out.println("Light has been turned on.");
	}
	
	public void turnOff() {
		this.status = State.Off;
		System.out.println("Light has been turned off.");
	}
	
	public void getStatus() {
		System.out.println("Light is "+this.status);
	}
}
