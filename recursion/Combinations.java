package recursion;

import java.util.ArrayList;
import java.util.List;

public class Combinations {

	public List<List<Integer>> combine(int n, int k) {


		List<List<Integer>>result=new ArrayList<>();

		combineHelperWithForLoop(1,n,k,new ArrayList<Integer>(),result);
		return result;
	}

	private void combineHelperWithForLoop(int start,int end, int k, ArrayList<Integer> temp, List<List<Integer>> result) {

		if(k==0)
		{
			result.add(new ArrayList<Integer>(temp));
			return;

		}

		for(int i=start;i<=end;i++) {
			temp.add(i);
			combineHelperWithForLoop(i+1,end,k-1,temp,result);
			temp.remove(temp.size()-1);
		}
	}

	private void combineHelperWithOutForLoop(int start,int end, int k, ArrayList<Integer> temp, List<List<Integer>> result) {

		if(k==0)
		{
			result.add(new ArrayList<Integer>(temp));
			return;

		}
		if(start>end)
			return ;

		temp.add(start);
		combineHelperWithOutForLoop(start+1,end,k-1,temp,result);
		temp.remove(temp.size()-1);
		combineHelperWithOutForLoop(start+1,end,k,temp,result);
	}


}