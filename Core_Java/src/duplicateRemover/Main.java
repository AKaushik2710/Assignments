package duplicateRemover;
import java.util.Arrays;
import java.util.Scanner;
public class Main {
	static int[] removeDuplicates(int[] arr) {
		int[] resArr = new int[arr.length];
		int uniqueElements = 0;
		int count = 1;
		
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<resArr.length; j++) {
				if(arr[i] == resArr[j]) {
					++count;
				}
			}
			if(count>1) {
				count=1;
				continue;
			}
			else {
				resArr[uniqueElements] = arr[i];
				uniqueElements++;
			}
		}
		arr = Arrays.copyOf(resArr, uniqueElements);
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
		System.out.println("The resultant array is "+Arrays.toString(removeDuplicates(arr)));
	}
}
