package dynamic_programming;

import java.util.Arrays;

public class MinimumCountSquares {


	public static int minCountRecursion(int n) {

		if(n==1 || n==0)
			return n;
		int minCount=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int tempCount=1+minCountRecursion(n-(i*i));
			minCount=Math.min(minCount, tempCount);
		}
		return minCount;
	}

	public static int minCount(int n) {


		int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		return minCountMemoization(n,dp);

	}


	public static int minCountMemoization(int n,int[]dp) {

		if(n==1 || n==0) {
			dp[n]=n;
			return dp[n];
		}

		if(dp[n]!=-1)
			return dp[n];

		int minCount=Integer.MAX_VALUE;
		for(int i=1;i*i<=n;i++) {
			int tempCount=1+minCountMemoization(n-(i*i),dp);
			minCount=Math.min(minCount, tempCount);
		}
		dp[n]=minCount;
		return dp[n];
	}

	public static int minCountDp(int n) {

		if(n==1 || n==0) {
			return n;
		}

		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<=n;i++) {
			int minCount=Integer.MAX_VALUE;
			for(int j=1;j*j<=i;j++) {
				int tempCount=1+dp[i-(j*j)];
				minCount=Math.min(minCount, tempCount);
			}
			dp[i]=minCount;
		}
		return dp[n];
	}



}