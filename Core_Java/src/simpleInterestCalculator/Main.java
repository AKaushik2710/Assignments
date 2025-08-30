package simpleInterestCalculator;
import java.util.Scanner;
public class Main {
	static double calculateSI(double p, double r, double t) {
		double si = (p*r*t)/100;
		return si;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter your principal amount:- ");
		double p = sc.nextDouble();
		System.out.print("Enter the rate you've got:- ");
		double r = sc.nextDouble();
		System.out.print("Enter the time:- ");
		double t = sc.nextDouble();
		sc.close();
		System.out.println("The simple interest for the given data is "+calculateSI(p,r,t));
	}
}
