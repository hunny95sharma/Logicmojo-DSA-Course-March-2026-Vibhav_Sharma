package dynamic_programming;

import java.util.Arrays;

public class StairCase {


	public static long staircaseRecursion(int n) {

		if(n<0)
			return 0;

		if(n==0)
			return 1;

		return staircaseRecursion(n-1)+staircaseRecursion(n-2)+staircaseRecursion(n-3);

	}
	public static long staircase(int n) {
		long dp[]=new long[n+1];
		Arrays.fill(dp, -1);

		return staircaseMemoization(n,dp);

	}

	private static long staircaseMemoization(int n, long[] dp) {

		if(n<0)
			return 0;

		if(n==0)
			return 1;

		if(dp[n]!=-1)
			return dp[n];

		return dp[n]=staircaseMemoization(n-1,dp)+staircaseMemoization(n-2,dp)+staircaseMemoization(n-3,dp);
	}

	public static long staircaseDp(int n) {

		if(n==0 ||n==1)
			return 1;

		if(n==2)
			return 2;

		long dp[]=new long[n+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		for(int i=3;i<=n;i++) {

			dp[i]=dp[i-1]+dp[i-2]+dp[i-3];

		}
		return dp[n];

	}

	public static long staircaseDpConstant(int n) {

		if(n==0 ||n==1)
			return 1;

		if(n==2)
			return 2;

		int a=1;
		int b=1;
		int c=2;
		for(int i=3;i<=n;i++) {
			int temp=a+b+c;
			a=b;
			b=c;
			c=temp;

		}
		return c;

	}


}