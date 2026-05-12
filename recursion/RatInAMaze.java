package matrix;

import java.util.ArrayList;

public class RatInAMaze {

	private static int[]dirRow=new int[] {-1,1,0,0};
	private static int[]dirCol=new int[] {0,0,-1,1};
	private static char[]dir=new char[] {'U','D','L','R'};

	public static ArrayList<String> fetchRatInMazePossibilities(int[][] maze) {
		if(maze[0][0]==0)
			return new ArrayList<String>();
		int n=maze.length;

		boolean[][]visited=new boolean[n][n];
		ArrayList<String>result=new ArrayList<>();
		fetchRatInMazePossibilitiesHelper(maze,0,0,n,"",visited,result);
		return result;
	}
	private static void fetchRatInMazePossibilitiesHelper(int[][] maze, int i, int j, int n, String temp,boolean[][]visited,
			ArrayList<String> result) {
		if(i==n-1 && j==n-1) {
			result.add(temp);
			return;
		}
		visited[i][j]=true;
		for(int k=0;k<4;k++) {

			int newRow=i+dirRow[k];
			int newCol=j+dirCol[k];
			if(newRow<0||newCol<0||newRow>=n||newCol>=n||maze[newRow][newCol]==0||visited[newRow][newCol])
				continue;
			fetchRatInMazePossibilitiesHelper(maze,newRow,newCol,n,temp+dir[k],visited,result);

		}

		visited[i][j]=false;

	}

}