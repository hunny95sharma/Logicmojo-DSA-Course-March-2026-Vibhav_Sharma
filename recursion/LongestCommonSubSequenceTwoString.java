package arrays;

import java.util.Arrays;

public class LongestCommonSubSequenceTwoString {

	public int longestCommonSubsequence(String text1, String text2) {

		int dp[][]=new int[text1.length()][text2.length()];
		for(int[]temp:dp)
			Arrays.fill(temp, -1);

		return longestCommonSubsequenceHelper(text1,0,text2,0,dp);

	}

	private int longestCommonSubsequenceHelper(String text1, int i, String text2, int j,int dp[][]) {


		if(text1.length()==i || text2.length()==j)
			return 0;

		if(dp[i][j]!=-1)
			return dp[i][j];

		if(text1.charAt(i)==text2.charAt(j))
			return dp[i][j]=1+longestCommonSubsequenceHelper(text1,i+1,text2,j+1,dp);
		else {

			return dp[i][j]=Math.max(longestCommonSubsequenceHelper(text1,i+1,text2,j,dp), longestCommonSubsequenceHelper(text1,i,text2,j+1,dp));

		}

	}


}