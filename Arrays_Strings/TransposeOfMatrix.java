package matrix;

public class TransposeOfMatrix {

	public int[][] transposeInplace(int[][] matrix) {

		int row=matrix.length;
		int col=matrix[0].length;

		for(int i=0;i<row;i++) {

			for(int j=i+1;j<col;j++) {


				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;

			}


		}
		return matrix;
	}

	public int[][] transposeExtraSpace(int[][] matrix) {

		int row=matrix.length;
		int col=matrix[0].length;

		int[][]transpose=new int[col][row];

		for(int i=0;i<row;i++) {

			for(int j=0;j<col;j++) {


				transpose[j][i]=matrix[i][j];

			}


		}
		return transpose;
	}

}