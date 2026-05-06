package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Nqueens {

	public List<List<String>> solveNQueensOptimized(int n) {

		char board[][]=new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}
		List<List<String>>result=new ArrayList<>();

		HashSet<Integer>cols=new HashSet<>();
		HashSet<Integer>diag=new HashSet<>();
		HashSet<Integer>antiDiag=new HashSet<>();
		solveNQueensOptimizedHelper(n,board,0,cols,diag,antiDiag,result);
		return result; 
	}





	private void solveNQueensOptimizedHelper(int n, char[][] board, int row, HashSet<Integer>cols,
			HashSet<Integer>diag, HashSet<Integer>antiDiag, List<List<String>> result) {


		if(row>=board.length) {

			result.add(construct(board));
			return;

		}
		for(int col=0;col<board[row].length;col++) {
			int diagConst=row+col;
			int antiDiagConst=row-col;
			if(cols.contains(col)||diag.contains(diagConst)||antiDiag.contains(antiDiagConst)) {

				continue;

			}
			cols.add(col);
			diag.add(diagConst);
			antiDiag.add(antiDiagConst);
			board[row][col]='Q';
			solveNQueensOptimizedHelper(n,board,row+1,cols,diag,antiDiag,result);
			cols.remove(col);
			diag.remove(diagConst);
			antiDiag.remove(antiDiagConst);
			board[row][col]='.';

		}
	}





	public List<List<String>> solveNQueens(int n) {

		char board[][]=new char[n][n];

		for (int i = 0; i < n; i++) {
			Arrays.fill(board[i], '.');
		}
		List<List<String>>result=new ArrayList<>();
		solveNQueensHelper(n,board,0,result);
		return result; 
	}

	private void solveNQueensHelper(int n, char[][] board, int row,List<List<String>> result) {


		if(row>=board.length) {

			result.add(construct(board));
			return;

		}
		for(int col=0;col<board[row].length;col++) {
			if(!isAttackByOtherQueen(board,row,col,n)) {
				board[row][col]='Q';
				solveNQueensHelper(n,board,row+1,result);
				board[row][col]='.';
			}
		}
	}

	private List<String> construct(char[][] board) {
		List<String> res = new ArrayList<>();
		for (char[] row : board) {
			res.add(new String(row));
		}
		return res;
	}

	private boolean isAttackByOtherQueen(char[][] board,int row,int col,int size) {

		for(int i=0;i<row;i++) {
			if(board[i][col]=='Q')
				return true;
		}

		for(int i=row-1,j=col+1;i>=0&&j<size;i--,j++) {
			if(board[i][j]=='Q')
				return true;
		}

		for(int i=row-1,j=col-1;i>=0&&j>=0;i--,j--) {
			if(board[i][j]=='Q')
				return true;
		}

		return false;
	}
}