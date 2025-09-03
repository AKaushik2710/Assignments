package mobilePhone;

interface MyMobile{
	void makeCall(String name);
	void sendMessage(String name);
}

public class Mobile implements MyMobile{
	public void makeCall(String name) {
		System.out.println("Calling "+name);
	}
	
	public void sendMessage(String name){
		System.out.println("A message has been sent to "+name);
	}
}
