package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationsSum2 {


	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>>result=new ArrayList<>();
		Arrays.sort(candidates);
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
			if (i > index && candidates[i] == candidates[i - 1]) {
				continue;
			}

			temp.add(candidates[i]);
			combinationSumHelperWithForLoop(candidates,i+1,temp,target-candidates[i],result);
			temp.remove(temp.size()-1);
		}
	}


}