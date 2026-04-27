package binary_search_tree;

public class NumberOfBinarySearchTree {


	public int numTrees1(int n) {

		if(n<=1)
			return 1;
		int result=0;

		for(int i=1;i<=n;i++) {
			result=result+numTrees1(i-1)*numTrees1(n-i);
		}

		return result;
	}

	public int numTrees2(int n) {

		if(n<=1)
			return 1;
		int dp[]=new int[n+1];
		return solve(n,dp);
	}

	private int solve(int n, int[] dp) {

		if(n<=1)
			return 1;
		int result=0;

		if(dp[n]!=0)
			return dp[n];

		for(int i=1;i<=n;i++) {
			result=result+solve(i-1,dp)*solve(n-i,dp);
		}

		dp[n]=result;

		return result;

	}

}