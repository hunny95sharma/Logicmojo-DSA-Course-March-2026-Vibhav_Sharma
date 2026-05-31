package dynamic_programming;

import java.util.Arrays;

public class NumberOfBalancedBinaryTrees {

	public static long balancedBTsDp(long n){

		if(n==1||n==0)
			return 1;

		int mod=(int)Math.pow(10, 9)+7;
		int dp[]=new int[(int)n+1];

		dp[0]=1;
		dp[1]=1;
		for(int i=2;i<=n;i++) {

			long x=dp[i-1];
			long y=dp[i-2];

			long first=(x*x)%mod;
			long second=(2*x*y)%mod;

			dp[i]=(int)((first+second)%mod);

		}
		return dp[(int)n];

	}


	public static long balancedBTsMemoization(long n){


		int mod=(int)Math.pow(10, 9)+7;
		int dp[]=new int[(int)n+1];
		Arrays.fill(dp, -1);
		return balancedBTsMemoizationHelper(n,mod,dp);

	}


	private static long balancedBTsMemoizationHelper(long n, int mod,int dp[]) {

		if(n==1||n==0)
			return 1;

		if(dp[(int)n]!=-1)
			return dp[(int)n];

		long x=balancedBTsMemoizationHelper(n-1,mod,dp);
		long y=balancedBTsMemoizationHelper(n-2,mod,dp);

		long first=(x*x)%mod;

		long second=(2*x*y)%mod;

		dp[(int)n]=(int)((first+second)%mod);

		return dp[(int)n];

	}


	public static long balancedBTsRecursion(long n){


		int mod=(int)Math.pow(10, 9)+7;
		return balancedBTsRecursionHelper(n,mod);

	}


	public static long balancedBTsRecursionHelper(long n,int mod){


		if(n==1||n==0)
			return 1;

		long x=balancedBTsRecursionHelper(n-1,mod);
		long y=balancedBTsRecursionHelper(n-2,mod);

		long first=(x*x)%mod;

		long second=(2*x*y)%mod;

		return (first+second)%mod;


	}

	public static void main(String args[]) {

		System.out.println(balancedBTsRecursion(7));


	}

}