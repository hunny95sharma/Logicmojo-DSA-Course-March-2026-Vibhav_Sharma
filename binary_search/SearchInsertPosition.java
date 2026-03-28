package binary_search;

public class SearchInsertPosition {
	
	public static int findSearchInsertPosition(int arr[],int target) {
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

	
	public static void main(String[] args) {

		System.out.println(findSearchInsertPosition(new int[] {1, 2, 8, 10, 10, 12, 19},0));
		
	}
	
}