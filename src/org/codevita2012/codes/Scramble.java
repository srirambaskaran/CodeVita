package org.codevita2012.codes;

/** Scramble.java
 *Coded by sriramb,sgsshankar,hari raghav
 *released under creative commons license
 *http://creativecommons.org/ for more details
 */
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Scramble {
	static int[] k;
	static int m;

	public static void main(String[] args) {
		try {
			List<String> words = new ArrayList<String>();
			List<String> rwords = new ArrayList<String>();
			Scanner sc = new Scanner(System.in);
			String keystr = sc.nextLine();
			String str1 = sc.nextLine();
			sc.close();
			char[] tokens = keystr.toCharArray();
			k = new int[tokens.length];
			m = k.length;
			for (int i = 0; i < tokens.length; i++)
				k[i] = Integer.parseInt(tokens[i] + "");
			Pattern p = Pattern.compile("[\\w]+");
			Matcher m = p.matcher(str1);
			while (m.find()) {
				words.add(str1.substring(m.start(), m.end()));
			}
			for (int i = 0; i < words.size(); i++) {
				rwords.add(Scramb(words.get(i).toString()));
				str1 = str1.replace(words.get(i).toString(), rwords.get(i)
						.toString());
			}
			System.out.println(str1);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String Scramb(String word) {
		if (word.length() == 1 || word.length() == 2 || word.length() == 3)
			return word;
		char fr, la;
		int f = 0, temp, len;
		fr = word.charAt(0);
		la = word.charAt(word.length() - 1);
		String trim = word.substring(1, word.length() - 1);
		char[] chrs = trim.toCharArray();
		int[] s = new int[chrs.length];
		for (int i = 0; i < s.length; i++)
			s[i] = i;
		len = s.length;
		for (int i = 0; i < len; i++) {
			f = (f + s[i % len] + k[i % m]) % len;
			temp = s[i];
			s[i] = s[f];
			s[f] = temp;
		}
		String ret = fr + "";
		for (int i = 0; i < len; i++)
			ret += chrs[s[i]];
		ret += la;
		return ret;
	}
}