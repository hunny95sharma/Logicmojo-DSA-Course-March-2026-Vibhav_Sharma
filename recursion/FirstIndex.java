package recursion;

public class FirstIndex {

	public static int firstIndex(int input[], int x) {

		return firstIndexHelper(input,x,0);

	}

	private static int firstIndexHelper(int[] input, int x, int index) {

		if(index==input.length)
			return -1;
		
		if(input[index]==x)
			return index;
		
		return firstIndexHelper(input,x,index+1);
		
		
	}


}