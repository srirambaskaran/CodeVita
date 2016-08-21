package org.codevita2012.codes;

/** SumOfArray.java
 *Coded by sriramb,sgsshankar,hari raghav
 *released under creative commons license
 *http://creativecommons.org/ for more details
 */
import java.util.Scanner;

public class SumOfArray {

	public static void main(String args[]) {

		int n;
		int array[];
		int sum = 0;
		Scanner scanner = new Scanner(System.in);
		n = scanner.nextInt();
		scanner.close();
		
		array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = scanner.nextInt();
		}

		for (int i = 0; i < n; i++) {
			sum += array[i];
		}

		System.out.println(sum);

	}

}