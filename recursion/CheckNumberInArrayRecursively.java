package recursion;

public class CheckNumberInArrayRecursively {


	public static boolean checkNumber(int input[], int x) {
		
		return checkNumberHelper(input,x,0);

	}

	private static boolean checkNumberHelper(int[] input, int x, int index) {
		
		if(index==input.length)
			return false;
		
		if(input[index]==x)
			return true;
		return checkNumberHelper(input,x,index+1);
		
	}


}