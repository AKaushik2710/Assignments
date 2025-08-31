package stringReversal;
import java.util.Scanner;
public class Main {
	static String reverseString(String str) {
		String res = "";
		for(int i=str.length()-1; i>=0; i--) {
			res+=str.charAt(i);
		}
		return res;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter the string you want to be reversed:-");
		String input = sc.nextLine();
		sc.close();
		System.out.println(reverseString(input));
	}
}
