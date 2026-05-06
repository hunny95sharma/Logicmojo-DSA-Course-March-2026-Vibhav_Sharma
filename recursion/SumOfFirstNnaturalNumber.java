package recursion;

public class SumOfFirstNnaturalNumber {

	public static int fetchSumOfFirstNnaturalNumber(int n) {
		
		if(n<=0)
			return 0;
		return fetchSumOfFirstNnaturalNumber(n-1)+n;
		
	}
	
}