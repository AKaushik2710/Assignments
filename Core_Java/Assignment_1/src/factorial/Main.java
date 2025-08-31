package factorial;

import java.util.Scanner;

public class Main {
	static int findFactorial(int num) {
		int res = num;
		for(int i=1; i<num; i++) {
			res *= i;
		}
		
		return res;
	}
	
	public static void main(String[]  args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the number whose factorial you want as output:- ");
		int input = sc.nextInt();
		sc.close();
		System.out.println("Factorial of "+input+" is "+findFactorial(input));
	}
}
