package recursion;

import java.util.ArrayList;

public class ReturnAllCodes {


	public static ArrayList<String> getCode2(String input) {

		String[] codes = {
				"",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z"
		};

		if (input == null) return null;

		ArrayList<String> result = new ArrayList<>();
		backtrack(input, 0, codes, new StringBuilder(), result);
		return result;
	}

	private static void backtrack(String input,
			int index,
			String[] codes,
			StringBuilder temp,
			ArrayList<String> result) {

		if (index == input.length()) {
			result.add(temp.toString());
			return;
		}

		// choices: 1 digit ya 2 digit
		for (int len = 1; len <= 2; len++) {

			if (index + len > input.length()) continue;

			String sub = input.substring(index, index + len);
			int num = Integer.parseInt(sub);

			if (num >= 1 && num <= 26) {

				// choose
				temp.append(codes[num]);

				// explore
				backtrack(input, index + len, codes, temp, result);

				// unchoose
				temp.deleteCharAt(temp.length() - 1);
			}
		}
	}


	public static  ArrayList<String> getCode(String input){

		String[] codes = new String[] {
				"",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z"
		};

		if(input==null)
			return null;

		ArrayList<String>result=new ArrayList<>();

		getCodeHelper(input,0,codes,"",result);
		return result;
	}

	private static void getCodeHelper(String input, int index, String[] codes, String temp,
			ArrayList<String> result) {

		if(index==input.length()) {
			result.add(temp);
			return ;
		}

		char l1=input.charAt(index);
		int x=l1-'0';
		getCodeHelper(input,index+1,codes,temp+codes[x],result);

		if(index+1<input.length()) {
			char l2=input.charAt(index+1);
			int number=l2-'0';
			number=x*10+number;
			if(number<=26) {
				getCodeHelper(input,index+2,codes,temp+codes[number],result);
			}
		}

	}

	public static  String[] getCode1(String input){

		String[] codes = new String[] {
				"",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z"
		};

		if(input==null)
			return null;

		return getCodeHelper1(input,0,codes);
	}

	private static String[] getCodeHelper1(String input, int index,String []codes) {

		if(index==input.length()) {
			return new String[] {""};
		}
		char l1=input.charAt(index);
		int x=l1-'0';
		String[]smallOutput1=getCodeHelper1(input,index+1,codes);
		for(int i=0;i<smallOutput1.length;i++) {
			smallOutput1[i]=codes[x]+smallOutput1[i];
		}
		String[]smallOutput2=new String[0];
		if(index+1<input.length()) {
			char l2=input.charAt(index+1);
			int number=l2-'0';
			number=x*10+number;
			if(number<=26) {
				smallOutput2=getCodeHelper1(input,index+2,codes);
				for(int i=0;i<smallOutput2.length;i++) {
					smallOutput2[i]=codes[number]+smallOutput2[i];
				}
			}
		}

		String[]result=new String[smallOutput1.length+smallOutput2.length];
		int k=0;
		for(int i=0;i<smallOutput1.length;i++)
			result[k++]=smallOutput1[i];

		for(int i=0;i<smallOutput2.length;i++)
			result[k++]=smallOutput2[i];

		return result;

	}


}