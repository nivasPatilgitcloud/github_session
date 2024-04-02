package githubdemo.package_one;

import java.util.Arrays;

public class JagrutiSurat {

	public static void main(String[] args) {
		// Even odd using stream API
		int[] num = { 2, 3, 4, 5, 6, 8, 7, 9, 10 };
		// Finding even numbers
		System.out.println("Even numbers:");
		Arrays.stream(num).filter(n -> n % 2 == 0).forEach(System.out::println);

		// Finding odd numbers
		System.out.println("Odd numbers:");
		Arrays.stream(num).filter(n -> n % 2 != 0).forEach(System.out::println);

	}

}
