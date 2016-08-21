package org.codevita2012.codes;

/** PrimeNumber.java
 *Coded by sriramb,sgsshankar,hari raghav
 *released under creative commons license
 *http://creativecommons.org/ for more details
 */
import java.util.Scanner;

public class PrimeNumber {
	public static void main(String[] args) {
		int[] a;
		int flag = 0;
		int i, k = 0;
		try {
			Scanner scanner = new Scanner(System.in);
			String s1, s2, s3;
			s1 = scanner.nextLine();
			s2 = scanner.nextLine();
			s3 = scanner.nextLine();
			scanner.close();
			int s = Integer.parseInt(s1);
			int e = Integer.parseInt(s2);
			int n = Integer.parseInt(s3);
			if (s > e || n == 0 || s < 0 || e > 1500000) {
				System.out.print("Invalid Input\n");
				System.exit(0);
			}
			if (s == e || n >= e) {
				System.out.print("No prime number is present at this index\n");
				System.exit(0);
			}
			a = new int[e - s + 1];
			if (s <= 2 && 2 <= e)
				a[k++] = 2;
			if (s <= 3 && 3 <= e)
				a[k++] = 3;
			for (i = s; i <= e && k < n; i++) {
				flag = 0;
				for (int j = 2; j <= Math.sqrt(i); j++) {
					if (i % j == 0) {
						flag = 1;
					}
				}
				if (flag != 1 && i != 1 && i != 2 && i != 3) {
					a[k++] = i;
				}
			}
			if (a[n - 1] == 0) {
				System.out.print("No prime number is present at this index\n");
			} else {
				System.out.print(a[n - 1] + "\n");
			}
		} catch (Exception e) {
			System.out.print("Invalid Input\n");
		}
	}
}