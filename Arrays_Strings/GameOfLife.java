
public class GameOfLife {

	private int[]dirX=new int[] {-1,1,0,0,-1,1,-1,1};
	private int[]dirY=new int[] {0,0,-1,1,-1,1,1,-1};


	/*We encode transitional states:

		2 means alive → dead
		3 means dead → alive

		During neighbor counting, cells 1 and 2 are treated as originally alive.
		This preserves old state information while updating in place.*/
	public void gameOfLifeApproach2(int[][] board) {
		int row=board.length;
		int col=board[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				int count=0;
				for(int k=0;k<8;k++) {
					int newX=i+dirX[k];
					int newY=j+dirY[k];
					if(newX>=0&&newX<row&&newY>=0&&newY<col&&(board[newX][newY]==1 || board[newX][newY]==2))
						count++;
				}
				if(board[i][j]==1) {
					if(count<2)
						board[i][j]=2;
					if(count>3)
						board[i][j]=2;	
				}else {
					if(count==3)
						board[i][j]=3;
				}
			}
		}

		for(int i=0;i<row;i++) {

			for(int j=0;j<col;j++)
			{

				if(board[i][j]==2)
					board[i][j]=0;

				if(board[i][j]==3)
					board[i][j]=1;

			}

		}
	}

	public void gameOfLifeApproach1(int[][] board) {
		int row=board.length;
		int col=board[0].length;
		int temp[][]=new int[row][col];
		for(int i=0;i<row;i++)
		{
			for(int j=0;j<col;j++) {
				temp[i][j]=board[i][j];
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				int count=0;
				for(int k=0;k<8;k++) {
					int newX=i+dirX[k];
					int newY=j+dirY[k];
					if(newX>=0&&newX<row&&newY>=0&&newY<col&&temp[newX][newY]==1)
						count++;
				}
				if(temp[i][j]==1) {
					if(count<2)
						board[i][j]=0;
					if(count>3)
						board[i][j]=0;	
				}else {
					if(count==3)
						board[i][j]=1;
				}
			}
		}
	}
}