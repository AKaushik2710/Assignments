package temperatureConverter;

import java.util.Scanner;

public class Main {

	static double celsiusToFahrenheit(double c) {
		double temp = (c * 9/5)+32;
		return temp;
	}
	
	static double fahrenheitToCelsius(double f) {
		double temp = (f-32)*5/9;
		return temp;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Which method would you like to use for your temperature conversion\na.)Celsius To Fahrenheit\t\tb.) Fahrenheit To Celsius");
		String choice = sc.next();
		
		switch(choice.charAt(0)) {
		case 'a':
			System.out.print("Enter the temperature:- ");
			double input = sc.nextDouble();
			System.out.println("Your conversion of Celsius to Fahrenheit resulted in "+celsiusToFahrenheit(input)+"F");
			break;
		case 'b':
			System.out.print("Enter the temperature:- ");
			input = sc.nextDouble();
			System.out.println("Your conversion of Fahrenheit to Celsius resulted in "+fahrenheitToCelsius(input)+"C");
			break;
		default:
			System.out.print("You didn't select a valid option.");
		}
		sc.close();
	}

}
