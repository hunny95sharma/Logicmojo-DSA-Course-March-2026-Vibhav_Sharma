package binary_search;

public class FindSquareRoot {
	
	public static int fetchFindSquareRootBruteForce(int x) {
		if(x==0)
			return 0;
		int i=1;
		long sq=1;
		while(sq<=x) {
			i++;
			sq=(long)i*i;
		}
		return i-1;
	}
	
	
	public static int fetchFindSquareRootBinarySerach(int x) {
		if(x==0 || x==1)
			return x;
		int low=1;
		int high=x/2;
		int ans=0;
		while(low<=high) {
			int mid=low+(high-low)/2;
			if(mid==(x/mid))
				return mid;
			else if(mid>(x/mid)) {
				high=mid-1;
			}else {
				ans=mid;
				low=mid+1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		
		System.out.println(fetchFindSquareRootBinarySerach(25));

	}

}
