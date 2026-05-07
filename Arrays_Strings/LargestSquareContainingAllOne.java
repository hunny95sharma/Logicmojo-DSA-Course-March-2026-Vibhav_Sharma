package matrix;

public class LargestSquareContainingAllOne {

	public int maximalSquare(char[][] matrix) {
		if(matrix.length==0)
			return 0;
		int row=matrix.length;
		int col=matrix[0].length;
		int result=0;
		int auxMat[][]=new int[row+1][col+1];
		for(int i=1;i<=row;i++) {
			for(int j=1;j<=col;j++) {
				if(matrix[i-1][j-1]=='1') {
					auxMat[i][j]=Math.min(Math.min(auxMat[i][j-1],auxMat[i-1][j-1]), auxMat[i-1][j])+1;
					result=Math.max(auxMat[i][j], result);
				}


			}
		}
		return result*result;
	}
}