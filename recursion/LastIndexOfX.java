package recursion;

public class LastIndexOfX {


	public static int lastIndex(int input[], int x) {
	
		return lastIndexHelper(input,x,input.length-1);
		
		
	}

	private static int lastIndexHelper(int[] input, int x, int index) {
		
		if(index<0)
			return -1;
		
		if(input[index]==x)
			return index;
		return lastIndexHelper(input,x,index-1);
		
	}

}