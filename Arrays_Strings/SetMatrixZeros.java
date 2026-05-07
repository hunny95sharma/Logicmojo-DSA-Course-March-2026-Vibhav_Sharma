package matrix;

public class SetMatrixZeros {


	public void setZeroesOptimal(int[][] matrix) {
		int row=matrix.length;
		int col=matrix[0].length;
		boolean firstRowImpacted=false;
		boolean firstColImpacted=false;
		for(int i=0;i<col;i++)
		{
			if(matrix[0][i]==0) {
				firstRowImpacted=true;
				break;
			}
		}
		for(int i=0;i<row;i++)
		{
			if(matrix[i][0]==0) {
				firstColImpacted=true;
				break;
			}
		}

		for(int i=1;i<row;i++) {
			for(int j=1;j<col;j++) {
				if(matrix[i][j]==0) {
					matrix[i][0]=0;
					matrix[0][j]=0;
				}
			}
		}

		for(int i=1;i<row;i++) {

			for(int j=1;j<col;j++) {

				if(matrix[i][0]==0 || matrix[0][j]==0)
					matrix[i][j]=0;


			}

		}

		if(firstRowImpacted) {
			for(int i=0;i<col;i++)
				matrix[0][i]=0;
		}
		if(firstColImpacted) {
			for(int i=0;i<row;i++)
				matrix[i][0]=0;
		}

	}


	public void setZeroesBetter(int[][] matrix) {
		int row=matrix.length;
		int col=matrix[0].length;
		boolean []rowZero=new boolean[row];
		boolean[]colZero=new boolean[col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j]==0) {
					rowZero[i]=true;
					colZero[j]=true;
				}
			}
		}

		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(rowZero[i]||colZero[j]) {
					matrix[i][j]=0;
				}
			}
		}
	}


	public void setZeroesBruteForce(int[][] matrix) {
		int row=matrix.length;
		int col=matrix[0].length;
		int[][]result=new int[row][col];
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				result[i][j]=matrix[i][j];
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				if(matrix[i][j]==0) {
					for(int k=0;k<col;k++)
						result[i][k]=0;
					for(int k=0;k<row;k++)
						result[k][j]=0;
				}
			}
		}
		for(int i=0;i<row;i++) {
			for(int j=0;j<col;j++) {
				matrix[i][j]=result[i][j];
			}
		}
	}
}