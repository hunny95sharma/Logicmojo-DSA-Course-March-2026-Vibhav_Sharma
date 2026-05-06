package recursion;

import java.util.ArrayList;
import java.util.List;

public class ReturnSubsetsToK {

	public static List<List<Integer>> subsetsSumK3(int[] input, int target) {
		if (input == null) return null;

		List<List<Integer>> result = new ArrayList<>();
		backtrack(input, 0, target, new ArrayList<>(), result);
		return result;
	}

	private static void backtrack(int[] input,
			int start,
			int target,
			List<Integer> temp,
			List<List<Integer>> result) {

		if (target == 0) {
			result.add(new ArrayList<>(temp));
			return;
		}

		for (int i = start; i < input.length; i++) {

			// optional pruning
			if (input[i] > target) continue;

			// choose
			temp.add(input[i]);

			// explore
			backtrack(input, i + 1, target - input[i], temp, result);

			// unchoose
			temp.remove(temp.size() - 1);
		}
	}


	public static List<List<Integer>> subsetsSumK2(int input[],int target) {
		if(input==null)
			return null;

		List<List<Integer>>result=new ArrayList<>();
		List<Integer>temp=new ArrayList<>();
		subsetsSumK1ResultPassHelper(input,0,temp,result,target);

		return result;
	}
	private static void subsetsSumK1ResultPassHelper(int[] input, int i, List<Integer> temp,
			List<List<Integer>> result,int target) {
		if(target==0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		if(i==input.length)
		{
			return;
		}
		temp.add(input[i]);
		subsetsSumK1ResultPassHelper(input,i+1,temp,result,target-input[i]);
		temp.remove(temp.size()-1);
		subsetsSumK1ResultPassHelper(input,i+1,temp,result,target);
	}

	public static int[][] subsetsSumK1(int input[],int target) {

		if(input==null)
			return null;

		return subsetsHelper(input,0,target);
	}

	private static int[][] subsetsHelper(int[] input, int index,int target) {

		if(target==0) {
			return new int[][] {{}};
		}

		if(index==input.length) {
			return new int[0][0];
		}

		int [][]smallResult=subsetsHelper(input,index+1,target-input[index]);

		int [][]result1=new int[smallResult.length][];
		int k=0;
		for(int i=0;i<smallResult.length;i++)
		{
			int [] temp=new int [smallResult[i].length+1];
			temp[0]=input[index];
			for(int j=1;j<temp.length;j++)
			{
				temp[j]=smallResult[i][j-1];
			}
			result1[k++]=temp;
		}
		smallResult=subsetsHelper(input,index+1,target);

		int [][]result=new int[result1.length+smallResult.length][];
		k=0;
		for(int i=0;i<result1.length;i++)
			result[k++]=result1[i];

		for(int i=0;i<smallResult.length;i++)
			result[k++]=smallResult[i];


		return result;
	}


}