package recursion;

public class PrintKeypadCombinations {

	public static void printKeypad(int input){

		printKeypadHelper(input,"");

	}

	private static void printKeypadHelper(int input,String res) {

		if(input==0)
		{
			System.out.println(res+" ");
			return ;
		}

		int digit=input%10;
		String option=getOptions(digit);
		for(int i=0;i<option.length();i++)
			printKeypadHelper(input/10,option.charAt(i)+res);


	}

	public static void printKeypad1(int input) {
		String digits = String.valueOf(input);

		if (input <= 0) return;

		backtrack(digits, 0, new StringBuilder());
	}

	private static void backtrack(String digits, int index, StringBuilder temp) {

		if (index == digits.length()) {
			System.out.println(temp.toString());
			return;
		}

		int digit = digits.charAt(index) - '0';
		String options = getOptions(digit);

		for (int i = 0; i < options.length(); i++) {

			// choose
			temp.append(options.charAt(i));

			// explore
			backtrack(digits, index + 1, temp);

			// unchoose
			temp.deleteCharAt(temp.length() - 1);
		}
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


}