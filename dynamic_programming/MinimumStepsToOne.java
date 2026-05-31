package dynamic_programming;

import java.util.Arrays;

public class MinimumStepsToOne {


	public static int countMinStepsToOneRecursive(int n) {

		if(n==0||n==1)
			return 0;

		int option1=countMinStepsToOneRecursive(n-1);

		int minSteps=option1;
		if(n%2==0)
		{
			int option2=countMinStepsToOneRecursive(n/2);
			minSteps=Math.min(minSteps, option2);

		}
		if(n%3==0) {
			int option3=countMinStepsToOneRecursive(n/3);
			minSteps=Math.min(minSteps, option3);

		}

		return 1+minSteps;


	}

	public static int countMinStepsToOneMemoization(int n) {

		int dp[]=new int[n+1];
		Arrays.fill(dp, -1);
		return countMinStepsToOneMemoizationStorage(n,dp);


	}

	private static int countMinStepsToOneMemoizationStorage(int n, int[] dp) {

		if(n<=1) {
			return 0;

		}

		if(dp[n]!=-1)
			return dp[n];

		int option1=countMinStepsToOneMemoizationStorage(n-1,dp);

		int minSteps=option1;
		if(n%2==0)
		{
			int option2=countMinStepsToOneMemoizationStorage(n/2,dp);
			minSteps=Math.min(minSteps, option2);

		}
		if(n%3==0) {
			int option3=countMinStepsToOneMemoizationStorage(n/3,dp);
			minSteps=Math.min(minSteps, option3);

		}

		dp[n]=1+minSteps;
		return dp[n];

	}

	private static int countMinStepsToOneDp(int n) {

		if(n<=1) {
			return 0;

		}

		int dp[]=new int[n+1];
		dp[0]=0;
		dp[1]=0;
		for(int i=2;i<=n;i++) {

			int option1=dp[i-1];

			int minSteps=option1;
			if(i%2==0)
			{
				int option2=dp[i/2];
				minSteps=Math.min(minSteps, option2);

			}
			if(i%3==0) {
				int option3=dp[i/3];
				minSteps=Math.min(minSteps, option3);

			}
			dp[i]=1+minSteps;

		}
		return dp[n];
	}



}