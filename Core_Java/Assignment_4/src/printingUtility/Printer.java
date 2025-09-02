package printingUtility;

public class Printer {
	void println(int number) {
		System.out.println("I ran num");
		System.out.println(number);
	}
	
	void println(String message) {
		System.out.println(message);
	}
	
	void println(double value) {
		System.out.println(value);
	}
	
	void println(String[] items) {
		for(String str : items) {
			System.out.println(str);
		}
	}
	
	void println(Object obj) {
		System.out.println(obj.toString());
	}
}
