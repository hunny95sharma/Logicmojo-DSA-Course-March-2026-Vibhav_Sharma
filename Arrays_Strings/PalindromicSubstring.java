package arrays;

import java.util.ArrayList;

public class PalindromicSubstring {

	public int countSubstrings(String s) {

		int l=s.length();
		ArrayList<String>result=new ArrayList<>();

		for(int i=0;i<l;i++) {

			expand(s,i,i,result);
			expand(s,i,i+1,result);

		}
		return result.size();
	}

	private void expand(String s, int i, int j, ArrayList<String> result) {

		while(i>=0&&j<s.length() && s.charAt(i)==s.charAt(j)) {

			result.add(s.substring(i, j));
			i--;
			j++;
		}
	}


}