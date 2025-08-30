package arraySorting;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	static int[] sortArray(int[] arr) {
		int i,j,temp;
		boolean swap = false;
		
		for(i=0; i<arr.length-1; i++) {
			for(j=0; j<arr.length-i-1; j++) {
				if(arr[j]>arr[j+1]) {
					temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
					swap = true;
				}
			}
			
			if(!swap) break;
			swap = false;
		}
		
		return arr;
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
		System.out.println("Here is the sorted Array:- "+ Arrays.toString(sortArray(arr)));
	}
}
