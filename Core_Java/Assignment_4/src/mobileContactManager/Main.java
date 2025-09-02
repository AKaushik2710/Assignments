package mobileContactManager;

public class Main {
	public static void main(String[] args) {
		Mobile m = new Mobile();
		String[] names = {"Hunny", "Bunny"};
		String[] numbers = {"12XXXXXXXXXX","34XXXXXXXX"};
		m.addContact("Aman", "86XXXXXX");
		m.addContact("Kaushik", "83XXXXXXX", "kaushik@gmail.com");
		m.addContact("AK", "93XXXXXX", "AK@gmail.com", "Rohtak, Haryana");
		m.addContact(names, numbers);
	}
}
