package dynamic_programming;

public class EditDistanceDp {

	public int minDistance(String word1, String word2) {

		int s1=word1.length();
		int s2=word2.length();

		int dp[][]=new int[s1+1][s2+1];

		for(int i=0;i<s1+1;i++)
			dp[i][s2]=s1-i;

		for(int i=0;i<s2+1;i++)
			dp[s1][i]=s2-i;

		for(int i=s1-1;i>=0;i--) {

			for(int j=s2-1;j>=0;j--) {
				if(word1.charAt(i)==word2.charAt(j)) {
					dp[i][j]=dp[i+1][j+1];
				}
				else {
					int edit=1+dp[i+1][j+1];
					int delete=1+dp[i+1][j];
					int insert=1+dp[i][j+1];
					dp[i][j]=Math.min(edit, Math.min(delete, insert));
				}
			}

		}
		return dp[0][0];


	}


}