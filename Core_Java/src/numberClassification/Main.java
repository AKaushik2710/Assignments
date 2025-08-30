package numberClassification;
import java.util.Scanner;
public class Main {
	static void classifyNumbers(int num) {
		if(num/1 > 0) {
			System.out.println("Given input is positive.");
		}
		else if(num/1 < 0) {
			System.out.println("Given input is negative.");
		}
		else {
			System.out.println("Given input is zero.");
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number to be categorised into +ve, -ve & 0:- ");
		int input = sc.nextInt();
		sc.close();
		classifyNumbers(input);
	}
}
