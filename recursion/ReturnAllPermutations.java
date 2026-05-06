package recursion;

import java.util.ArrayList;
import java.util.List;

public class ReturnAllPermutations {


	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>>result=new ArrayList<>();
		permuteHelper(nums,0,result);
		return result;
	}


	private void permuteHelper(int[] nums, int idx, List<List<Integer>> result) {

		if (idx == nums.length) {
			List<Integer> temp = new ArrayList<>();
			for (int num : nums) {
				temp.add(num);
			}
			result.add(temp);
			return;
		}

		for(int i=idx;i<nums.length;i++) {


			swap(nums,idx,i);
			permuteHelper(nums,idx+1,result);
			swap(nums,idx,i);

		}


	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>>result=new ArrayList<>();
		boolean []visited=new boolean[nums.length];
		permuteHelper1(nums,new ArrayList<Integer>(),visited,result);
		return result;
	}

	private void permuteHelper1(int[] nums, List<Integer>temp,boolean[]visited,List<List<Integer>> result) {

		if(temp.size()==nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for(int i=0;i<nums.length;i++) {

			if(!visited[i]) {
				temp.add(nums[i]);
				visited[i]=true;
				permuteHelper1(nums,temp,visited,result);
				temp.remove(temp.size()-1);
				visited[i]=false;
			}

		}

	}


}