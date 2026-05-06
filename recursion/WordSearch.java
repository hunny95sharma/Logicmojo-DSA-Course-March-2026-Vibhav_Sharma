package recursion;

public class WordSearch {

	int[][] directions = {
			{0, -1},
			{0, 1},
			{1, 0},
			{-1, 0}
	};

	public boolean exist(char[][] board, String word) {
		int row=board.length;
		int col=board[0].length;
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {

				if(board[i][j]==word.charAt(0) && find(board,i,j,0,word))
					return true;		
			}
		}
		return false;
	}

	private boolean find(char[][] board, int i, int j, int index, String word) {

		if(index==word.length())
			return true;

		if(i<0||j<0||i>=board.length||j>=board[0].length||board[i][j]=='$')
			return false;

		if(board[i][j]!=word.charAt(index))
			return false;

		char temp=board[i][j];
		board[i][j]='$';

		for(int []direction:directions) {

			int row=i+direction[0];
			int col=j+direction[1];
			if(find(board,row,col,index+1,word))
				return true;

		}

		board[i][j]=temp;
		return false;
	}


}