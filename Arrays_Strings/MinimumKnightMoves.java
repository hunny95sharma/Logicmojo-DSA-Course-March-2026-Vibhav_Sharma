package matrix;

import java.util.LinkedList;
import java.util.Queue;

public class MinimumKnightMoves {


	private static int[]dirRow=new int[] {-2,-2,2,2,-1,1,-1,1};
	private static int[]dirCol=new int[] {-1,1,-1,1,-2,-2,2,2};

	public static int fetchMinimumKnightMoves(int[][]matrix,int x,int y) {

		if(x==0 && y==0)
			return 0;

		Queue<int[]>queue=new LinkedList<>();
		boolean visited[][]=new boolean[301][301];
		int dis=0;
		queue.offer(new int[] {0,0});
		visited[0][0]=true;
		x=Math.abs(x);
		y=Math.abs(y);
		while(!queue.isEmpty()) {
			int size=queue.size();

			for(int i=0;i<size;i++) {

				int[]element=queue.poll();
				int elementRow=element[0];
				int elementCol=element[1];

				if(elementRow==x && elementCol==y) {

					return dis;
				}
				for(int j=0;j<8;j++) {

					int newRow=Math.abs(elementRow+dirRow[j]);
					int newCol=Math.abs(elementCol+dirCol[j]);

					if(newCol>=0 && newRow>=0&&newRow<301 && newCol<301) {

						if(!visited[newRow][newCol]) {
							queue.offer(new int[] {newRow,newCol});
							visited[newRow][newCol]=true;
						}
					}
				}

			}

			dis++;
		}
		return -1;
	}

}