package recursion;

public class SumOfArray {

	public static int sum(int input[]) {
		
		return sumHelper(input,0);
		
		
	}

	private static int sumHelper(int[] input, int index) {
		
		if(index==input.length)
			return 0;
		
		return input[index]+sumHelper(input,index+1);
		
	}


}