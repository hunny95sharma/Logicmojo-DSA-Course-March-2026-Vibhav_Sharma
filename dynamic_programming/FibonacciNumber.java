package dynamic_programming;

import java.util.Arrays;

public class FibonacciNumber {


	public static int fibonacciNumberRecursion(int n) {

		if(n==0||n==1)
			return n;

		n=fibonacciNumberRecursion(n-1)+fibonacciNumberRecursion(n-2);
		return n;


	}

	public int fibMemization(int n) {

		int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		return fibonacciNumberMemoization(n,dp);

	}

	private int fibonacciNumberMemoization(int n, int[] dp) {

		if(n==0||n==1) {
			dp[n]=n;
			return n;
		}

		if(dp[n]!=-1)
			return dp[n];

		dp[n]=fibonacciNumberMemoization(n-1,dp)+fibonacciNumberMemoization(n-2,dp);
		return dp[n];
	}

	public int fibDp(int n) {

		if(n==0||n==1)
			return n;

		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=1;
		for(int i=2;i<dp.length;i++)
			dp[i]=dp[i-1]+dp[i-2];
		return dp[n];

	}

	public int fibDpOptimized(int n) {

		if(n==0||n==1)
			return n;

		int a=0;
		int b=1;
		int c=0;
		for(int i=1;i<=n;i++) {
			a=b;
			b=c;
			c=a+b;
		}

		return c;

	}


}