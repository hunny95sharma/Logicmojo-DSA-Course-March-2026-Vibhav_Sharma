package dynamic_programming;

import java.util.Arrays;

public class MinCostPath {


	public int minPathSumDp(int[][] grid) {

		int row=grid.length;
		int col=grid[0].length;

		int dp[][] = new int[row][col];
		dp[row-1][col-1]=grid[row-1][col-1];
		for(int i=col-2;i>=0;i--) {
			dp[row-1][i]=grid[row-1][i]+dp[row-1][i+1];
		}

		for(int i=row-2;i>=0;i--) {
			dp[i][col-1]=grid[i][col-1]+dp[i+1][col-1];
		}

		for(int i=row-2;i>=0;i--)
		{
			for(int j=col-2;j>=0;j--) {

				int down=dp[i+1][j];
				int right=dp[i][j+1];
				int diag=dp[i+1][j+1];

				dp[i][j]=grid[i][j]+Math.min(diag, Math.min(down, right));

			}
		}
		return dp[0][0];

	}

	public int minPathSumMemoization(int[][] grid) {

		int row=grid.length;
		int col=grid[0].length;

		int dp[][] = new int[row][col];

		for (int[] arr : dp) {
			Arrays.fill(arr, -1);
		}

		return minPathSumMemoizationHelper(grid,0,0,row,col,dp);

	}

	private int minPathSumMemoizationHelper(int[][] grid, int i, int j, int row, int col,int dp[][]) {

		if(i>=row || j>=col)
			return Integer.MAX_VALUE;

		if(i==row-1 && j==col-1) {
			return dp[i][j]=grid[i][j];
		}

		if(dp[i][j]!=-1)
			return dp[i][j];

		int down=minPathSumMemoizationHelper(grid,i+1,j,row,col,dp);

		int right=minPathSumMemoizationHelper(grid,i,j+1,row,col,dp);

		int diag=minPathSumMemoizationHelper(grid,i+1,j+1,row,col,dp);

		return dp[i][j]=grid[i][j]+Math.min(down, Math.min(diag, right));

	}

	public int minPathSumRecursion(int[][] grid) {

		int row=grid.length;
		int col=grid[0].length;

		return minPathSumRecursionHelper(grid,0,0,row,col);

	}

	private int minPathSumRecursionHelper(int[][] grid, int i, int j, int row, int col) {

		if(i>=row || j>=col)
			return Integer.MAX_VALUE;

		if(i==row-1 && j==col-1)
			return grid[i][j];


		int down=minPathSumRecursionHelper(grid,i+1,j,row,col);

		int right=minPathSumRecursionHelper(grid,i,j+1,row,col);

		int diag=minPathSumRecursionHelper(grid,i+1,j+1,row,col);

		return grid[i][j]+Math.min(down, Math.min(diag, right));
	}


}