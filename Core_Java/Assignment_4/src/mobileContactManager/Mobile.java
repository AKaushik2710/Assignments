package mobileContactManager;

public class Mobile {
	void addContact(String name, String phoneNumber) {
		System.out.println("Contact with name "+name+" and number "+phoneNumber+" is saved.");
	}
	
	void addContact(String name, String phoneNumber, String email) {
		System.out.println("Contact with name "+name+" , number "+phoneNumber+" and email "+email+" is saved.");
	}
	
	void addContact(String name, String phoneNumber, String email, String address) {
		System.out.println("Contact with name "+name+" , number "+phoneNumber+" , email "+email+" and address "+address+" is saved.");
	}
	
	void addContact(String[] name, String[] phoneNumber) {
		for(int i=0; i<name.length;i++) {
			System.out.println("Contact with name "+name[i]+" and number "+phoneNumber[i]+" is saved.");
		}
	}
}
