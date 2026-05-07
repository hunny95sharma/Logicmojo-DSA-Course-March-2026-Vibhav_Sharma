package matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {



	public List<Integer>spiralOrder(int[][]matrix){

		int row=matrix.length;
		int col=matrix[0].length;

		List<Integer>result=new ArrayList<>();
		int top=0;
		int dir=0;
		int right=col-1;
		int left=0;
		int bottom=row-1;
		while(top<=bottom && left<=right) {

			if(dir==0) {

				for(int i=left;i<=right;i++)
					result.add(matrix[top][i]);

				top++;
			}
			if(dir==1) {
				for(int i=top;i<=bottom;i++)
					result.add(matrix[i][right]);
				right--;
			}
			if(dir==2) {
				for(int i=right;i>=left;i--)
					result.add(matrix[bottom][i]);
				bottom--;

			}
			if(dir==3) {
				for(int i=bottom;i>=top;i--)
					result.add(matrix[i][left]);
				left++;
			}
			dir++;
			if(dir==4) {
				dir=0;
			}




		}

		return result;
	}



}