package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class ClearPath {

	private static int[]dirRow=new int[] {-1,1,0,0,-1,1,-1,1};
	private static int[]dirCol=new int[] {0,0,-1,1,-1,1,1,-1};


	public static int fetchShortestClearPath(int[][]matrix) {
		int n=matrix.length;
		if(matrix[0][0]==1 || matrix[n-1][n-1]==1)
			return -1;

		boolean[][]visited=new boolean[n][n];
		Queue<int[]>queue=new LinkedList<>();
		queue.offer(new int[] {0,0});
		visited[0][0]=true;
		int dis=1;
		while(!queue.isEmpty()) {
			int size=queue.size();
			for(int i=0;i<size;i++) {
				int[] element=queue.poll();
				int elementRow=element[0];
				int elementCol=element[1];
				if(elementRow==n-1 && elementCol==n-1) {
					return dis;
				}

				for(int j=0;j<8;j++) {
					int newRow=elementRow+dirRow[j];
					int newCol=elementCol+dirCol[j];
					if(newRow<0 || newRow>=n || newCol<0 || newCol>=n)
						continue;
					if(matrix[newRow][newCol]==1 || visited[newRow][newCol])
						continue;
					queue.offer(new int[] {newRow,newCol});
					visited[newRow][newCol]=true;
				}
			}
			dis++;

		}
		return -1;

	}


}