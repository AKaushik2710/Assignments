package smartHomeDevices;

public class Fan implements SmartDevice{
	int deviceId;
	State status;
	Fan(int id, State status){
		this.deviceId = id;
		this.status = status;
	}
	
	public void turnOn() {
		this.status = State.On;
		System.out.println("Fan has been turned on.");
	}
	
	public void turnOff() {
		this.status = State.Off;
		System.out.println("Fan has been turned off.");
	}
	
	public void getStatus() {
		System.out.println("Fan is "+this.status);
	}
}
