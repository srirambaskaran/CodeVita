package org.codevita2012.codes;

import java.util.Scanner;

/**
 * ISBN.java Coded by sriramb,sgsshankar,hari raghav released under creative
 * commons license http://creativecommons.org/ for more details
 * 
 */

public class ISBN {
	public static void main(String args[]) {
		try {
			String inp;
			int flag = 0;
			int x = 10;
			int pos = 0;
			int op = -1;
			int sum = 0, newSum = 0;
			Scanner sc = new Scanner(System.in);
			inp = sc.next();
			char[] inpArr = inp.toCharArray();
			if (inpArr.length != 10) {
				System.out.print("INVALID INPUT\n");
				System.exit(0);
			}
			for (int i = 0; i < inpArr.length; i++) {
				if (inpArr[i] == 'X') {
					if (i != 9) {
						System.out.print("INVALID INPUT\n");
						System.exit(0);
					} else {
						sum += x * 10;
					}
				} else if (inpArr[i] == '?') {
					if (flag == 0) {
						pos = i + 1;
						flag = 1;
						x--;
						continue;
					} else {
						System.out.print("INVALID INPUT\n");
						System.exit(0);
					}

				} else
					sum += x * Integer.parseInt(inpArr[i] + "");
				x--;
			}
			if (pos == 0 && flag == 0) {
				System.out.print("INVALID INPUT\n");
				System.exit(0);
			}
			int mul = 10 - pos + 1;
			for (int i = 0; i < 10 && pos != 0; i++) {
				newSum = sum + i * mul;
				if (newSum % 11 == 0)
					op = i;
			}
			if ((newSum = sum + 10 * mul) % 11 == 0 && pos != 0 && op == -1) {
				System.out.print("X\n");
				System.exit(0);
			}
			if (op != -1)
				System.out.print(op + "\n");
			else
				System.out.print("NO SOLUTION POSSIBLE\n");
			sc.close();
		} catch (Exception e) {
			System.out.print("INVALID INPUT\n");
		}
	}
}
