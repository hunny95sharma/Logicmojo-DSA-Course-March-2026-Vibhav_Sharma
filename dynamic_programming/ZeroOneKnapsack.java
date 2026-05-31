package dynamic_programming;

import java.util.Arrays;

public class ZeroOneKnapsack {

	public static int knapsackDp(int[] weights, int[] values, int n, int maxWeight) {
		int dp[][]=new int[n+1][maxWeight+1];

		for(int i=0;i<=maxWeight;i++)
			dp[n][i]=0;

		for(int i=n-1;i>=0;i--)
		{
			for(int j=maxWeight;j>=0;j--) {

				int skip=dp[i+1][j];
				int steal=0;
				if(weights[i]<=j)

					steal=values[i]+dp[i+1][j-weights[i]];

				dp[i][j]=Math.max(skip, steal);
			}
		}
		return dp[0][maxWeight];

	}

	public static int knapsackMemoization2(int[] weights, int[] values, int n, int maxWeight) {

		int dp[][]=new int[weights.length][maxWeight+1];
		for(int []arr:dp)
			Arrays.fill(arr, -1);

		return knapsackMemoizationHelper2(weights,values,n,maxWeight,n-1,dp);

	}

	private static int knapsackMemoizationHelper2(int[] weights, int[] values, int n, int maxWeight, int i,int dp[][]) {

		if(i<0||maxWeight==0)
			return 0;

		if(dp[i][maxWeight]!=-1)
			return dp[i][maxWeight];

		int skip=knapsackMemoizationHelper2(weights,values,n,maxWeight,i-1,dp);
		int steal=0;
		if(weights[i]<=maxWeight)

			steal=values[i]+knapsackMemoizationHelper2(weights,values,n,maxWeight-weights[i],i-1,dp);

		return dp[i][maxWeight]=Math.max(skip, steal);

	}


	public static int knapsackMemoization1(int[] weights, int[] values, int n, int maxWeight) {
		int dp[][]=new int[weights.length][maxWeight+1];

		for(int []arr:dp)
			Arrays.fill(arr, -1);

		return knapsackMemoizationHelper1(weights,values,n,maxWeight,0,dp);

	}

	private static int knapsackMemoizationHelper1(int[] weights, int[] values, int n, int maxWeight, int i,int[][]dp) {

		if(i>=n||maxWeight==0)
			return 0;

		if(dp[i][maxWeight]!=-1)
			return dp[i][maxWeight];

		int skip=knapsackMemoizationHelper1(weights,values,n,maxWeight,i+1,dp);
		int steal=0;
		if(weights[i]<=maxWeight)

			steal=values[i]+knapsackMemoizationHelper1(weights,values,n,maxWeight-weights[i],i+1,dp);

		return dp[i][maxWeight]=Math.max(skip, steal);

	}

	public static int knapsack2(int[] weights, int[] values, int n, int maxWeight) {

		return knapsackHelper2(weights,values,n,maxWeight,n-1);

	}

	private static int knapsackHelper2(int[] weights, int[] values, int n, int maxWeight, int i) {

		if(i<0||maxWeight==0)
			return 0;

		int skip=knapsackHelper2(weights,values,n,maxWeight,i-1);
		int steal=0;
		if(weights[i]<=maxWeight)

			steal=values[i]+knapsackHelper2(weights,values,n,maxWeight-weights[i],i-1);

		return Math.max(skip, steal);

	}

	public static int knapsack1(int[] weights, int[] values, int n, int maxWeight) {
		return knapsackHelper1(weights,values,n,maxWeight,0);

	}

	private static int knapsackHelper1(int[] weights, int[] values, int n, int maxWeight, int i) {

		if(i>=n||maxWeight==0)
			return 0;

		int skip=knapsackHelper1(weights,values,n,maxWeight,i+1);
		int steal=0;
		if(weights[i]<=maxWeight)

			steal=values[i]+knapsackHelper1(weights,values,n,maxWeight-weights[i],i+1);

		return Math.max(skip, steal);

	}

}