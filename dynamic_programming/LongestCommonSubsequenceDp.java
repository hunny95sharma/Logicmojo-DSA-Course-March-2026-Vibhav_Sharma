package dynamic_programming;

public class LongestCommonSubsequenceDp {


	public int longestCommonSubsequence(String text1, String text2) {

		int s1=text1.length();
		int s2=text2.length();

		int dp[][]=new int[s1+1][s2+1];

		for(int i=0;i<s2+1;i++)
			dp[s1][i]=0;

		for(int i=0;i<s1+1;i++)
			dp[i][s2]=0;


		for(int i=s1-1;i>=0;i--) {
			for(int j=s2-1;j>=0;j--) {

				if(text1.charAt(i)==text2.charAt(j))
					dp[i][j]=1+dp[i+1][j+1];
				else
					dp[i][j]=Math.max(dp[i+1][j],dp[i][j+1]);



			}
		}

		return dp[0][0];

	}


}