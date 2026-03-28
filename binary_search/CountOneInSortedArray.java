package binary_search;

public class CountOneInSortedArray {
	
	public static int fetchTotalNumberOfOnes(int arr[]) {
		int first=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==1) {
				first=mid;
				end=mid-1;
			}else if(arr[mid]>1) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		start=0;
		end=arr.length-1;
		int last=-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==1) {
				last=mid;
				start=mid+1;
			}else if(arr[mid]>1) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return last-first +1;
	}

	
	public static void main(String[] args) {
		System.out.println(fetchTotalNumberOfOnes(new int[] {0, 0, 0, 0, 1, 1, 1}));

	}
	
}