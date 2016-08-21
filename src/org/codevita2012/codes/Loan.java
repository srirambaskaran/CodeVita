package org.codevita2012.codes;

/** Loan.java
 *Coded by sriramb,sgsshankar,hari raghav
 *released under creative commons license
 *http://creativecommons.org/ for more details
 */
import java.text.DecimalFormat;
import java.util.Scanner;

class Loan {
	public static void main(String args[]) {
		try {

			DecimalFormat df = new DecimalFormat("#.00");
			DecimalFormat df1 = new DecimalFormat("#");
			Scanner sc = new Scanner(System.in);
			double emi = 0.0;
			String loanAmt = sc.nextLine();
			String rateOfInt = sc.nextLine();
			String ten = sc.nextLine();
			String freqofPay = sc.nextLine();
			sc.close();
			if (loanAmt == null || rateOfInt == null || ten == null
					|| freqofPay == null) {
				System.out.print("Invalid Input\n");
				System.exit(0);
			}
			if (!freqofPay.equals("MONTHLY")) {
				System.out.print("Invalid Input\n");
				System.out
						.print("Please Mention Frequency Of EMI As MONTHLY\n");
				System.exit(0);
			}
			double max = 10000000000.0;
			double I = Double.parseDouble(rateOfInt);
			double L = Double.parseDouble(loanAmt);
			double N = new Double(ten);
			if (I < 0 || I > 100 || N < 1 || N > 1188 || L < 0 || L > max) {
				System.out.print("Invalid Input\n");
				System.exit(0);
			}
			I /= 1200.0;
			emi = (L * I)
					* ((Math.pow(1.0 + I, N)) / ((Math.pow(I + 1.0, N)) - 1.0));
			System.out.print("EMI calculated is Rs " + df.format(emi) + "\n");
			Double totint = 0.0, nL = L, intr = 0.0, pc = 0.0;
			for (int i = 1; i <= N; i++) {
				intr = nL * I;
				pc = emi - intr;
				totint += intr;
				nL = nL - pc;
			}
			System.out
					.printf("Total interest paid is Rs " + df1.format(totint));
			System.out.println();
		} catch (Exception e) {
			System.out.print("Invalid Input\n");
		}
	}
}