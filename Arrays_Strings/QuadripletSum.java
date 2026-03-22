package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QuadripletSum {

	
public List<List<Integer>> fourSum(int[] nums, int target) {
	List<List<Integer>>res=new ArrayList<>();
	Arrays.sort(nums);
	for(int i=0;i<nums.length;i++) {
		if(i>0&& nums[i]==nums[i-1])continue;
		for(int j=i+1;j<nums.length;j++) {
			if(j>i+1&& nums[j]==nums[j-1])continue;
			int start=j+1;
			int end=nums.length-1;
			while(start<end) {
				if(nums[start]+nums[end]+nums[i]+nums[j]==target) {
					res.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
					while(start<end && nums[start]==nums[start+1])start++;
					while(start<end && nums[end]==nums[end-1])end--;
					start++;
					end--;
					
				}else if(nums[start]+nums[end]+nums[i]+nums[j]>target) {
					end--;
				}else {
					start++;
				}
			}
		}
	}
	return res;
    }
	
	public static void main(String[] args) {
		
	}

}
