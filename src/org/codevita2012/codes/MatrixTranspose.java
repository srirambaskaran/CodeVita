package org.codevita2012.codes;

/** MatrixTranspose.java
 *Coded by sriramb,sgsshankar,hari raghav
 *released under creative commons license
 *http://creativecommons.org/ for more details
 */
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MatrixTranspose {
	public static void main(String args[]) {
		double[][] a;
		double[][] b;
		String[] tokens;
		List<String> rows = new ArrayList<String>();
		List<Integer> colrow = new ArrayList<Integer>();
		int row1 = 0;
		int col1 = 0;
		String readLine;
		String file1;
		DecimalFormat df = new DecimalFormat("0.000");
		try {
			Scanner sc = new Scanner(System.in);
			file1 = sc.next();
			FileInputStream fileInputStream = new FileInputStream(file1);
			DataInputStream dataInputStream = new DataInputStream(
					fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(
					new InputStreamReader(dataInputStream));
			sc.close();
			while ((readLine = bufferedReader.readLine()) != null) {
				rows.add(readLine);
				tokens = rows.get(row1).split(" ");
				colrow.add(tokens.length);
				row1++;
			}
			bufferedReader.close();
			for (int i = 1; i < colrow.size(); i++) {
				if (colrow.get(i - 1) != colrow.get(i)) {
					System.out.print("Invalid Input\n");
					System.exit(0);
				}
			}
			tokens = rows.get(0).split(" ");
			col1 = tokens.length;
			a = new double[row1][col1];
			for (int i = 0; i < row1; i++) {
				tokens = rows.get(i).split(" ");
				for (int j = 0; j < col1; j++) {
					a[i][j] = Double.parseDouble(tokens[j]);
				}
			}

			System.out.print("Size before transpose is " + row1 + "x" + col1
					+ "\n");
			b = new double[col1][row1];
			for (int i = 0; i < row1; i++)
				for (int j = 0; j < col1; j++)
					b[j][i] = a[i][j];

			for (int i = 0; i < col1; i++) {
				for (int j = 0; j < row1; j++) {
					if (j == row1 - 1)
						System.out.printf(df.format(b[i][j]));
					else
						System.out.printf(df.format(b[i][j]) + " ");
				}
				System.out.print("\n");
			}
			System.out.print("Size after transpose is " + col1 + "x" + row1
					+ "\n");
		}

		catch (Exception e) {
			System.out.print("Invalid Input\n");
		}
	}
}
