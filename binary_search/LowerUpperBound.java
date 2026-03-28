package binary_search;

public class LowerUpperBound {
	
	public static int fetchLowerBound(int arr[],int target) {
		int ans=arr.length;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>=target) {
				ans=mid;
				end=mid-1;
			}else {
			start=mid+1;
			}
		}
		return ans;
	}
	
	public static int fetchUpperBound(int arr[],int target) {
		int ans=arr.length;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]>target) {
				ans=mid;
				end=mid-1;
			}else {
			start=mid+1;
			}
		}
		return ans;
	}

	public static void main(String[] args) {

		System.out.println(fetchUpperBound(new int[] {2, 3, 7, 10, 11, 11, 25},9));
		
	}

}
