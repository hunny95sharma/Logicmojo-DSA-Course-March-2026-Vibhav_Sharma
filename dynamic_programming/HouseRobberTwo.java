package dynamic_programming;

import java.util.Arrays;

public class HouseRobberTwo {


	public int robRecursionDpOptimized(int[] nums) {

		if(nums.length==1)
			return nums[0];

		int result1=0;
		int result2=0;
		int prevPrev=0;
		int prev=nums[0];
		for(int i=2;i<nums.length;i++) {

			int steal=nums[i-1]+prevPrev;
			int skip=prev;
			prevPrev=prev;
			prev=Math.max(steal,skip);
		}
		result1= prev;
		prevPrev=0;
		prev=0;
		for(int i=2;i<=nums.length;i++) {

			int steal=nums[i-1]+prevPrev;
			int skip=prev;
			prevPrev=prev;
			prev=Math.max(steal,skip);
		}
		result2= prev;
		return Math.max(result1, result2);

	}

	public int robRecursionDp(int[] nums) {

		if(nums.length==1)
			return nums[0];

		int dp[]=new int[nums.length+1];
		int result1=0;
		int result2=0;
		dp[0]=0;
		dp[1]=nums[0];
		for(int i=2;i<nums.length;i++) {

			int steal=nums[i-1]+dp[i-2];
			int skip=dp[i-1];
			dp[i]=Math.max(steal,skip);
		}
		result1= dp[dp.length-2];
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<=nums.length;i++) {

			int steal=nums[i-1]+dp[i-2];
			int skip=dp[i-1];
			dp[i]=Math.max(steal,skip);
		}
		result2= dp[dp.length-1];
		return Math.max(result1, result2);

	}


	public int robMemoization(int[] nums) {
		if(nums.length==1)
			return nums[0];
		int dp[]=new int[nums.length+1];
		Arrays.fill(dp, -1);
		int steal=robMemoizationHelper(nums,0,nums.length-2,dp);
		Arrays.fill(dp, -1);
		int skip=robMemoizationHelper(nums,1,nums.length-1,dp);
		return Math.max(steal, skip);


	}

	private int robMemoizationHelper(int[] nums, int idx,int end,int[]dp) {

		if(idx>end)
			return 0;

		if(dp[idx]!=-1)
			return dp[idx];

		int steal=nums[idx]+robMemoizationHelper(nums,idx+2,end,dp);
		int skip=robMemoizationHelper(nums,idx+1,end,dp);
		return dp[idx]=Math.max(steal, skip);
	}

	public int robRecursion(int[] nums) {
		if(nums.length==1)
			return nums[0];
		return Math.max(robRecursionHelper(nums,0,nums.length-2),robRecursionHelper(nums,1,nums.length-1));


	}

	private int robRecursionHelper(int[] nums, int idx,int end) {

		if(idx>end)
			return 0;

		int steal=nums[idx]+robRecursionHelper(nums,idx+2,end);
		int skip=robRecursionHelper(nums,idx+1,end);
		return Math.max(steal, skip);
	}

}