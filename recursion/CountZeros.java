package recursion;

public class CountZeros {
	
	public static int countZerosRec(int input){
		if(input==0)
			return 1;
		return countZerosRecHelper(input);
	}

	public static int countZerosRecHelper(int input){
		if(input==0)
			return 0;
		int digit=input%10;
		if(digit==0)
		{
			return 1+countZerosRecHelper(input/10);		
		}
		else {
           return countZerosRecHelper(input/10);
		}
	}
}