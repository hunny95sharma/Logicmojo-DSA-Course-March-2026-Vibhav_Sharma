package recursion;

public class SplitArray {


	public static boolean splitArray(int input[]) {

		return splitArrayHelper(input,0,0,0);

	}

	private static boolean splitArrayHelper(int[] input, int index, int group1, int group2) {
		if(index==input.length)
		{
			if(group1==group2)
				return true;
			else
				return false;
		}
		if(input[index]%5==0) {
			group1=group1+input[index];
			return splitArrayHelper(input,index+1,group1,group2);
		}
		else if(input[index]%3==0) {
			group2=group2+input[index];
			return splitArrayHelper(input,index+1,group1,group2);
		}else {
			group1=group1+input[index];
			boolean result=splitArrayHelper(input,index+1,group1,group2);
			if(!result) {
				group1=group1-input[index];
				group2=group2+input[index];
				result=splitArrayHelper(input,index+1,group1,group2);
			}
			return result;
		}


	}




}