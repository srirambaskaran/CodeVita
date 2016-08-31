package org.usc.homework1;

public class Test {
	public static void main(String[] args) {
		String str = "1251";
		char[] oldCharacters = str.toCharArray();
		char[] decimalCharacters = new char[oldCharacters.length+1];
		int k=decimalCharacters.length-1;
		for(int i=oldCharacters.length-1;i>=0;i--){
			if(i==oldCharacters.length-3){
				decimalCharacters[k--] = '.';
			}
			decimalCharacters[k--] = oldCharacters[i];
		}
		int separatorDistance = 3;
		int numCommas = (decimalCharacters.length-4)/separatorDistance;
		char[] newCharacters = new char[decimalCharacters.length+numCommas];
		int j=newCharacters.length-1;
		for(int i=decimalCharacters.length-1;i>=0;i--){
			if(i>decimalCharacters.length-4){
				newCharacters[j--] = decimalCharacters[i];
			}else{
				//separator start
				newCharacters[j--] = decimalCharacters[i];
				separatorDistance--;
				if(separatorDistance == 0){
					if(i-1 >= 0){
						newCharacters[j--] = ',';
						separatorDistance=3;
					}
				}
			}
		}
		for(int i=0;i<newCharacters.length;i++)
			System.out.print(newCharacters[i]);
	}
}
