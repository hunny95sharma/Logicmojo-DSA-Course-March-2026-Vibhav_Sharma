package arrays;

import java.util.Arrays;

public class EditDistance {

	public int minDistance(String word1, String word2) {

		int dp[][]=new int[501][501];
		for(int temp[]:dp)
			Arrays.fill(temp, -1);
		return minDistanceHelper(word1,word2,0,0,dp);

	}

	private int minDistanceHelper(String word1, String word2, int w1, int w2,int[][]dp) {


		if(w1==word1.length()) {

			return word2.length()-w2;

		}



		if(w2==word2.length()) {

			return word1.length()-w1;
		}

		if(dp[w1][w2]!=-1)
			return dp[w1][w2];

		if(word1.charAt(w1)==word2.charAt(w2)) {
			return dp[w1][w2]=minDistanceHelper(word1,word2,w1+1,w2+1,dp);
		}
		else {
			int edit=1+minDistanceHelper(word1,word2,w1+1,w2+1,dp);
			int delete=1+minDistanceHelper(word1,word2,w1+1,w2,dp);
			int insert=1+minDistanceHelper(word1,word2,w1,w2+1,dp);
			return dp[w1][w2]=Math.min(edit, Math.min(delete, insert));
		}
	}


}