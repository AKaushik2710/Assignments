package arrayMaximumFinder;
import java.util.Scanner;
public class Main {
	static int findMax(int[] arr) {
		int max = arr[0];
		for(int i=0; i<arr.length; i++) {
			if(arr[i]>max) {
				max = arr[i];
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of elements you want to have in your array:- ");
		int length = sc.nextInt();
		int arr[] = new int[length];
		System.out.println("Enter the array elements");
		for(int i=0; i<length; i++) {
			arr[i] = sc.nextInt();
		}
		sc.close();
		System.out.println("The element having the maximum value in the array is "+findMax(arr));
	}
}
