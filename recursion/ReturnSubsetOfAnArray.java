package recursion;

import java.util.ArrayList;
import java.util.List;

public class ReturnSubsetOfAnArray {

	public static int[][] subsets(int input[]) {

		if(input==null)
			return null;

		return subsetsHelper(input,0);
	}

	private static int[][] subsetsHelper(int[] input, int index) {

		if(index==input.length) {
			return new int[][] {{}};
		}

		int [][]smallResult=subsetsHelper(input,index+1);

		int [][]result=new int[smallResult.length*2][];
		int k=0;
		for(int i=0;i<smallResult.length;i++)
			result[k++]=smallResult[i];

		for(int i=0;i<smallResult.length;i++)
		{
			int [] temp=new int [smallResult[i].length+1];
			temp[0]=input[index];
			for(int j=1;j<temp.length;j++)
				temp[j]=smallResult[i][j-1];
			result[k++]=temp;
		}
		return result;
	}


	public List<List<Integer>> subsetsResultPass(int[] input) {
		if(input==null)
			return null;

		List<List<Integer>>result=new ArrayList<>();
		List<Integer>temp=new ArrayList<>();
		subsetsResultPassHelper(input,0,temp,result);
		return result;
	}

	private void subsetsResultPassHelper(int[] input, int i, List<Integer>temp,List<List<Integer>> result) {
		if(i==input.length)
		{

			result.add(new ArrayList<>(temp));
			return ;
		}

		temp.add(input[i]);
		subsetsResultPassHelper(input,i+1,temp,result);

		temp.remove(temp.size()-1);
		subsetsResultPassHelper(input,i+1,temp,result);
	}




}