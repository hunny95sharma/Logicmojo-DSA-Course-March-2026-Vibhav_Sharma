package matrix;

public class NumberOfIslands {

	private static int[]dirRow=new int[] {-1,1,0,0};
	private static int[]dirCol=new int[] {0,0,-1,1};

	public int numIslands(char[][] grid) {

		int m=grid.length;
		int n=grid[0].length;
		int ans=0;
		boolean[][]visited=new boolean[m][n];

		for(int i=0;i<m;i++) {

			for(int j=0;j<n;j++) {

				if(grid[i][j]=='1' &&!visited[i][j]) {

					numIslandsHelper(grid,i,j,m,n,visited);
					ans++;

				}

			}


		}

		return ans;


	}

	private void numIslandsHelper(char[][] grid, int row, int col,int m,int n,boolean[][]visited) {

		if(row<0 || col<0 || row>=m || col>=n || visited[row][col]||grid[row][col]=='0')
			return;

		visited[row][col]=true;
		for(int k=0;k<4;k++) {

			int newRow=row+dirRow[k];
			int newCol=col+dirCol[k];
			if(newRow<0 || newCol<0 || newRow>=m || newCol>=n || visited[newRow][newCol]||grid[newRow][newCol]=='0')
				continue;
			numIslandsHelper(grid,newRow,newCol,m,n,visited);

		}
	}

}