package digitsReversal;
import java.util.Scanner;
public class Main {
	static int reverseDigits(int num) {
		int res=0;
		while(num>0) {
			res = num%10 + res*10;
			num = num/10;
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter number you want to be reversed:- ");
		int input = sc.nextInt();
		sc.close();
		System.out.println("Reverse of the given input is "+reverseDigits(input));
	}
}
