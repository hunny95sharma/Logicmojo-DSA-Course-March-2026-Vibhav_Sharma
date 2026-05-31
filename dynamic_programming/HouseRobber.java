package dynamic_programming;

import java.util.Arrays;

public class HouseRobber {

	public int robRecursionDpOptimized(int[] nums) {

		if(nums.length==1)
			return nums[0];

		int prevPrev=0;
		int prev=nums[0];
		for(int i=2;i<=nums.length;i++) {

			int steal=nums[i-1]+prevPrev;
			int skip=prev;
			prevPrev=prev;
			prev=Math.max(steal,skip);
		}
		return prev;

	}


	public int robRecursionDp(int[] nums) {

		if(nums.length==1)
			return nums[0];

		int dp[]=new int[nums.length+1];
		dp[0]=0;
		dp[1]=nums[0];
		for(int i=2;i<=nums.length;i++) {

			int steal=nums[i-1]+dp[i-2];
			int skip=dp[i-1];
			dp[i]=Math.max(steal,skip);
		}
		return dp[dp.length-1];

	}

	public int robRecursion(int[] nums) {
		return robRecursionHelper(nums,0);

	}

	private int robRecursionHelper(int[] nums, int idx) {

		if(idx>=nums.length)
			return 0;

		int steal=nums[idx]+robRecursionHelper(nums,idx+2);
		int skip=robRecursionHelper(nums,idx+1);
		return Math.max(steal, skip);
	}

	public int robRecursionMemoization(int[] nums) {
		int dp[]=new int[nums.length+1];
		Arrays.fill(dp, -1);
		return robRecursionMemoizationHelper(nums,0,dp);

	}

	private int robRecursionMemoizationHelper(int[] nums, int idx,int[]dp) {

		if(idx>=nums.length)
			return 0;

		if(dp[idx]!=-1)

			return dp[idx];

		int steal=nums[idx]+robRecursionMemoizationHelper(nums,idx+2,dp);
		int skip=robRecursionMemoizationHelper(nums,idx+1,dp);
		return dp[idx]=Math.max(steal, skip);
	}


}