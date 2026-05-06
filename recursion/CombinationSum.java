package recursion;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {

	public List<List<Integer>> combinationSum(int[] candidates, int target) {

		List<List<Integer>>result=new ArrayList<>();

		combinationSumHelperWithForLoop(candidates,0,new ArrayList<Integer>(),target,result);

		return result;


	}

	private void combinationSumHelperWithForLoop(int[] candidates, int index, ArrayList<Integer> temp, int target,
			List<List<Integer>> result) {

		if(target==0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		if(target<0)
			return;

		for(int i=index;i<candidates.length;i++) {
			temp.add(candidates[i]);
			combinationSumHelperWithForLoop(candidates,i,temp,target-candidates[i],result);
			temp.remove(temp.size()-1);
		}
	}

	private void combinationSumHelperWithOutForLoop(int[] candidates, int index, ArrayList<Integer> temp, int target,
			List<List<Integer>> result) {

		if(target==0) {
			result.add(new ArrayList<Integer>(temp));
			return;
		}
		if(index==candidates.length || target<0)
			return;

		temp.add(candidates[index]);
		combinationSumHelperWithOutForLoop(candidates,index,temp,target-candidates[index],result);
		temp.remove(temp.size()-1);
		combinationSumHelperWithOutForLoop(candidates,index+1,temp,target,result);
	}
}