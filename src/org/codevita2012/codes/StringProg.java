package org.codevita2012.codes;

/** StringProg.java
 *Coded by sriramb,sgsshankar,hari raghav
 *released under creative commons license
 *http://creativecommons.org/ for more details
 */
import java.io.*;
import java.util.*;
import java.util.regex.*;

class StringProg {
	public static String findOutputFile(String inp) {
		String out = "";
		for (int i = 0; i < inp.length(); i++) {
			out += inp.charAt(i);
			if (inp.charAt(i) == '.') {
				out += "out";
				return out;
			}
		}
		return out;
	}

	public static void main(String[] args) {
		try {
			List<String> words = new ArrayList<String>();
			List<String> rwords = new ArrayList<String>();
			String inpFile, opFile;
			String inpString;
			String opString = "";
			inpFile = args[0];
			FileInputStream fis = new FileInputStream(inpFile);
			opFile = findOutputFile(inpFile);
			FileOutputStream fos = new FileOutputStream(opFile);
			BufferedReader br = new BufferedReader(new InputStreamReader(
					new DataInputStream(fis)));
			inpString = br.readLine();
			br.close();
			Pattern p = Pattern.compile("[\\w]+");
			Matcher m = p.matcher(inpString);
			while (m.find()) {
				words.add(inpString.substring(m.start(), m.end()));
			}
			opString = inpString;
			for (int i = 0; i < words.size(); i++) {
				rwords.add(reverseString(words.get(i).toString()));
				opString = opString.replace(words.get(i).toString(), rwords
						.get(i).toString());
			}
			System.out.println(opString);
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(
					new DataOutputStream(fos)));
			bw.write(opString);
			bw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String reverseString(String input) {
		String output = "";
		for (int i = input.length() - 1; i >= 0; i--) {
			output += input.charAt(i);
		}
		return output;
	}
}