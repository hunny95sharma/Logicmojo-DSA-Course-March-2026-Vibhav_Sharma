package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationsSum3 {

	public List<List<Integer>> combinationSum3(int k, int target) {


		List<List<Integer>>result=new ArrayList<>();
		combinationSum3(1,9,k,target,new ArrayList<Integer>(),result);
		return result;

	}

	private void combinationSum3(int start, int end, int k, int target, ArrayList<Integer> temp,
			List<List<Integer>> result) {

		if(target==0&&temp.size()==k) {
			result.add(new ArrayList<Integer>(temp));
			return ;
		}

		if(target<0||start>end)
			return;

		for(int i=start;i<=end;i++) {

			temp.add(i);
			combinationSum3(i+1,end,k,target-i,temp,result);
			temp.remove(temp.size()-1);
		}


	}


}