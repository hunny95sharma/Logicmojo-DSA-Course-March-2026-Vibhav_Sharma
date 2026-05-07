package matrix;

public class RotateImage {

	public void rotate(int[][] matrix) {


		int row=matrix.length;
		int col=matrix[0].length;

		for(int i=0;i<row;i++) {

			for(int j=i+1;j<col;j++) {


				int temp=matrix[i][j];
				matrix[i][j]=matrix[j][i];
				matrix[j][i]=temp;

			}


		}

		for(int i=0;i<matrix.length;i++) {
			int startIndex=0;
			int endIndex=matrix[i].length-1;
			while(startIndex<endIndex) {
				int temp=matrix[i][startIndex];
				matrix[i][startIndex]=matrix[i][endIndex];
				matrix[i][endIndex]=temp;
				startIndex++;
				endIndex--;
			}


		}

	}


}