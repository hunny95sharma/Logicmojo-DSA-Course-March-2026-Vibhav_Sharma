package recursion;

public class ConvertStringToInteger {

	public static int convertStringToInt(String input){

		if(input==null)
			return 0;

		return convertStringToIntHelper(input,0,0);

	}

	private static int convertStringToIntHelper(String input, int i, int number) {

		if(i==input.length())
			return number;


		number=number*10 + (input.charAt(i)-'0');
		return convertStringToIntHelper(input,i+1,number);


	}

}