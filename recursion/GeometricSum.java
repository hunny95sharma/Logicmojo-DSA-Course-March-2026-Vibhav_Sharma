package recursion;

public class GeometricSum {

	public static double geometricSum(int k) {
		
		if(k==0)
			return 1;
		
		double res=(double)1/Math.pow(2, k);
		return res+geometricSum(k-1);
		
		
	}


}