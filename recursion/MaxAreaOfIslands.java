package matrix;

public class MaxAreaOfIslands {

	private static int[]dirRow=new int[] {-1,1,0,0};
	private static int[]dirCol=new int[] {0,0,-1,1};

	public int maxAreaOfIsland(int[][] grid) {

		int row=grid.length;
		int col=grid[0].length;
		boolean [][]visited=new boolean[row][col];

		int maximumArea=0;

		for(int i=0;i<row;i++) {

			for(int j=0;j<col;j++) {


				if(grid[i][j]==1 && !visited[i][j]) {
					int area=maxAreaOfIslandHelper(grid,i,j,row,col,visited);
					maximumArea=Math.max(maximumArea, area);
				}
			}
		}
		return maximumArea;
	}

	private int maxAreaOfIslandHelper(int[][] grid, int i, int j, int row, int col, boolean[][] visited) {

		if(i<0|| j<0||i>=row || j>=col || grid[i][j]==0 || visited[i][j])
			return 0;

		visited[i][j]=true;
		int area=1;
		for(int k=0;k<4;k++) {

			int newRow=i+dirRow[k];
			int newCol=j+dirCol[k];
			if(newRow<0|| newCol<0||newRow>=row || newCol>=col || grid[newRow][newCol]==0 || visited[newRow][newCol])
				continue;
			area=area+maxAreaOfIslandHelper(grid,newRow,newCol,row,col,visited);

		}
		return area;
	}


}