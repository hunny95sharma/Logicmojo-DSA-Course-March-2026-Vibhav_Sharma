package recursion;

public class Factorial {

	public static int fetchFactorialOfNumber(int n) {
		
		if(n<=1)
			return 1;
		return n*fetchFactorialOfNumber(n-1);
		
		
	}
	
}