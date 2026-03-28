package binary_search;

public class FloorCeil {
	
	
	public static int fetchCeil(int arr[],int target) {
		int ans=-1;
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
	
	public static int fetchFloor1(int arr[],int target) {
		int ans=-1;
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
		return ans-1;
	}
	
	public static int fetchFloor2(int arr[],int target) {
		int ans=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]<=target) {
				ans=mid;
				start=mid+1;
			}else {
			end=mid-1;
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {

		System.out.println(fetchFloor1(new int[] {1, 2, 8, 10, 10, 12, 19},0));
		
	}

}