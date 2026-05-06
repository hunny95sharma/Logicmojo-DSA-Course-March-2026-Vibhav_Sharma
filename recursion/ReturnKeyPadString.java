package recursion;

import java.util.ArrayList;
import java.util.List;

public class ReturnKeyPadString {


	public static String[] keypad1(int n){

		if(n==0)
			return new String[] {""};

		String keyPad=getOptions(n%10);

		String[]smallOutput=keypad1(n/10);


		if(!keyPad.equals("")) {
			String[]result=new String[smallOutput.length*keyPad.length()];
			int k=0;
			for(int i=0;i<keyPad.length();i++)
			{

				for(int j=0;j<smallOutput.length;j++)
					result[k++]=smallOutput[j]+keyPad.charAt(i);


			}
			return result;
		}
		return smallOutput;

	}


	public static String getOptions(int digit) {
		switch (digit) {
		case 2:
			return "abc";
		case 3:
			return "def";
		case 4:
			return "ghi";
		case 5:
			return "jkl";
		case 6:
			return "mno";
		case 7:
			return "pqrs";
		case 8:
			return "tuv";
		case 9:
			return "wxyz";
		case 0:
		case 1:
			return "";
		default:
			return "";
		}
	}


	public static List<String> keypad2(int n){

		List<String>result=new ArrayList<>();

		keypad2Helper(n,"",result);
		return result;
	}


	private static void keypad2Helper(int n, String temp, List<String> result) {

		if(n==0) {
			result.add(temp);
			return;			
		}
		String keyPad=getOptions(n%10);


		if(!keyPad.equals("")) {
			for(int i=0;i<keyPad.length();i++)
			{
				keypad2Helper(n/10,temp+keyPad.charAt(i),result);
			}
		}
	}
	
	public static List<String> keypad3(int n) {
	    List<String> result = new ArrayList<>();
	    backtrack(n, new StringBuilder(), result);
	    return result;
	}

	private static void backtrack(int n, StringBuilder temp, List<String> result) {

	    if (n == 0) {
	        result.add(temp.toString());
	        return;
	    }

	    String keyPad = getOptions(n % 10);

	    if (!keyPad.equals("")) {
	        for (int i = 0; i < keyPad.length(); i++) {

	            // choose
	            temp.append(keyPad.charAt(i));

	            // explore
	            backtrack(n / 10, temp, result);

	            // unchoose
	            temp.deleteCharAt(temp.length() - 1);
	        }
	    }
	}


}