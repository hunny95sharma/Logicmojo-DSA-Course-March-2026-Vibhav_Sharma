package recursion;

public class AllIndexesOfX {

	public static int[] allIndexes(int input[], int x) {
		
		
		return allIndexesHelper(input,x,0);
		
		

	}

	private static int [] allIndexesHelper(int[] input, int x,int index) {
		
		if(index==input.length)
		{
			int smallArray[]=new int[0];
			return smallArray;
		}
		
		int smalloutput[]=allIndexesHelper(input,x,index+1);
		if(input[index]==x) {
			
			int output[]=new int[smalloutput.length+1];
			output[0]=index;
			for(int i=0;i<smalloutput.length;i++) {
				output[i+1]=smalloutput[i];
			}
			return output;
		}else
			return smalloutput;
		
		
	}

}