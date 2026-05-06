package recursion;

public class StairCase {

	public static int staircase(int n){

		if(n==0)
			return 1;
		if(n<0)
			return 0;

		int one=staircase(n-1);
		int two=staircase(n-2);
		int three=staircase(n-3);

		return one + two +three;
	}
}