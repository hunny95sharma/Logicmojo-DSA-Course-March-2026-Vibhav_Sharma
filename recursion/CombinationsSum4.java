package recursion;

import java.util.Arrays;

public class CombinationsSum4 {



	public int combinationSum41(int[] nums, int target) {

		return solve(nums,0,target);

	}

	private int solve(int[] nums, int index, int target) {
		if(target==0)
			return 1;

		if(index>=nums.length || target<0)
			return 0;

		int takeIdx=solve(nums,0,target-nums[index]);
		int rejectIdx=solve(nums,index+1,target);
		return takeIdx+rejectIdx;
	}

	public int combinationSum4(int[] nums, int target) {

		int dp[][]=new int [201][1001];
		for(int[] row : dp){
			Arrays.fill(row, -1);
		}
		return solveDp(nums,0,target,dp);
	}

	private int solveDp(int[] nums, int index, int target,int dp[][]) {
		if(target==0)
			return 1;

		if(index>=nums.length || target<0)
			return 0;

		if(dp[index][target]!=-1)
			return dp[index][target];

		int takeIdx=solveDp(nums,0,target-nums[index],dp);
		int rejectIdx=solveDp(nums,index+1,target,dp);
		dp[index][target]=takeIdx+rejectIdx;
		return dp[index][target];
	}


	public int combinationSum4ForLoop(int[] nums, int target) {

		int dp[][]=new int [201][1001];
		for(int[] row : dp){
			Arrays.fill(row, -1);
		}
		return solveDpForLoop(nums,0,target,dp);
	}

	private int solveDpForLoop(int[] nums, int index, int target,int dp[][]) {
		if(target==0)
			return 1;

		if(index>=nums.length || target<0)
			return 0;
		int result=0;

		if(dp[index][target]!=-1)
			return dp[index][target];

		for(int i=index;i<nums.length;i++) {
			int takeIdx=solveDpForLoop(nums,0,target-nums[i],dp);
			result=result+=takeIdx;
		}
		return dp[index][target]=result;
	}


}