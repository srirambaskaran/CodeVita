package org.codevita2012.codes;

/** NumbersSort.java
 *Coded by sriramb,sgsshankar,hari raghav
 *released under creative commons license
 *http://creativecommons.org/ for more details
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;

public class NumberSort {
	public static void main(String args[]) {
		try {
			int n;
			Double a[];
			String file1;
			String readLine;
			Scanner scanner = new Scanner(System.in);
			file1 = scanner.next();
			scanner.close();
			
			FileInputStream fileInputStream = new FileInputStream(file1);
			DataInputStream dataInputStream = new DataInputStream(
					fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(dataInputStream));
			readLine = bufferedReader.readLine();
			bufferedReader.close();
			String[] tokens = readLine.split(",");
			n = tokens.length;
			a = new Double[n];
			for (int i = 0; i < tokens.length; i++)
				a[i] = Double.parseDouble(tokens[i]);
			System.out.println("Values Before the sort:");
			for (int i = 0; i < a.length; i++)
				System.out.print(a[i] + " ");
			Arrays.sort(a);
			System.out.println();
			System.out.println("Values after the Ascending sort:");
			for (int i = 0; i < a.length; i++)
				System.out.print(a[i] + " ");
			System.out.println();
			System.out.println("Values after the Descending sort:");
			for (int i = a.length - 1; i >= 0; i--)
				System.out.print(a[i] + " ");
			System.out.println();
		} catch (NumberFormatException e) {
			System.out.print("Invalid Input");
		} catch (Exception e) {
		}
	}
}
