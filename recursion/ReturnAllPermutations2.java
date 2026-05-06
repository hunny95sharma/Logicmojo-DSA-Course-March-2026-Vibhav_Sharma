package recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class ReturnAllPermutations2 {


	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>>result=new ArrayList<>();
		permuteUniqueHelper2(nums,0,result);
		return result;
	}


	private void permuteUniqueHelper2(int[] nums, int idx, List<List<Integer>> result) {

		if (idx == nums.length) {
			List<Integer> temp = new ArrayList<>();
			for (int num : nums) {
				temp.add(num);
			}
			result.add(temp);
			return;
		}

		HashSet<Integer>set=new HashSet<>();

		for(int i=idx;i<nums.length;i++) {

			if(!set.contains(nums[i])) {
				set.add(nums[i]);
				swap(nums,idx,i);
				permuteUniqueHelper2(nums,idx+1,result);
				swap(nums,idx,i);
			}

		}


	}

	private void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}


	public List<List<Integer>> permuteUnique1(int[] nums) {

		HashMap<Integer,Integer>map=new HashMap<>();

		for(int i=0;i<nums.length;i++)
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);

		List<List<Integer>>result=new ArrayList<>();
		permuteUniqueHelper1(nums,new ArrayList<Integer>(),map,result);
		return result;
	}

	private void permuteUniqueHelper1(int[] nums, List<Integer>temp,HashMap<Integer,Integer>map,List<List<Integer>> result) {

		if(temp.size()==nums.length) {
			result.add(new ArrayList<>(temp));
			return;
		}
		for (int key : map.keySet()) {

			if (map.get(key) > 0) {
				temp.add(key);
				map.put(key, map.get(key) - 1);

				permuteUniqueHelper1(nums, temp, map, result);

				temp.remove(temp.size() - 1);
				map.put(key, map.get(key) + 1);
			}
		}

	}


}