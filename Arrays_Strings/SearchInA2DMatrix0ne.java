package matrix;

public class SearchInA2DMatrix0ne {


	public boolean searchMatrix(int[][] matrix, int target) {

		int row=matrix.length;
		int col=matrix[0].length;
		int start=0;
		int end=(row*col)-1;
		while(start<=end) {

			int mid=start+(end-start)/2;
			int value=matrix[mid/col][mid%col];
			if(value==target)
				return true;
			else if(value>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}


		}

		return false;

	}

}