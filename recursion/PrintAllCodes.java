package recursion;

public class PrintAllCodes {


	public static void printAllPossibleCodes1(String input) {

		String[] codes = {
				"",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z"
		};

		if (input == null) return;

		backtrack(input, 0, codes, new StringBuilder());
	}

	private static void backtrack(String input,
			int index,
			String[] codes,
			StringBuilder temp) {

		if (index == input.length()) {
			System.out.println(temp.toString());
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
				backtrack(input, index + len, codes, temp);

				// unchoose
				temp.deleteCharAt(temp.length() - 1);
			}
		}
	}


	public static void printAllPossibleCodes(String input) {


		String[] codes = new String[] {
				"",
				"a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
				"k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
				"u", "v", "w", "x", "y", "z"
		};

		if(input==null)
			return;

		getCodeHelper(input,0,codes,"");

	}

	private static void getCodeHelper(String input, int index, String[] codes, String temp) {


		if(index==input.length()) {
			System.out.println(temp);
			return ;
		}

		char l1=input.charAt(index);
		int x=l1-'0';
		getCodeHelper(input,index+1,codes,temp+codes[x]);

		if(index+1<input.length()) {
			char l2=input.charAt(index+1);
			int number=l2-'0';
			number=x*10+number;
			if(number<=26) {
				getCodeHelper(input,index+2,codes,temp+codes[number]);
			}
		}

	}


}