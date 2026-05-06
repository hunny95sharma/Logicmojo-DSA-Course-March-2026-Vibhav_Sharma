package recursion;

public class SumOfDigits {

	public static int sumOfDigits(int input){
		
		if(input==0)
			return 0;
		int digit=input%10;
		return digit +sumOfDigits(input/10);

	}


}