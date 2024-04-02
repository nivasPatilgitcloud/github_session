package githubdemo.package_one;

import java.util.Arrays;

public class MayurKhandesh {

	public static void main(String[] args) {
		// Find maximum number from array
		
		int[] arr = {3,4,2,6,2,4,5};
		
		Arrays.sort(arr);
		
		System.out.println("maximum number from given array is "+ arr[arr.length-1]);
	}

}
