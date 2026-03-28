package binary_search;

public class NumberTimesArrayRotated {

	
	public int fetchNumberTimesArrayRotated(int arr[]) {
		int start=0;
		int end=arr.length-1;
		int ans=Integer.MAX_VALUE;
		int index=0;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[start]<=arr[mid]) {
				if(arr[start]<ans) {
				ans=arr[start];
				index=start;
				}
				start=mid+1;
				
			}else {
				if(arr[mid]<ans) {
				ans=arr[mid];
				index=mid;
				}
				end=mid-1;
			}
		}
		return index;
	}
	
	public int fetchMinRotatedSortedArrayDuplicate(int arr[]) {
		 int start=0;
			int end=arr.length-1;
			int ans=Integer.MAX_VALUE;
			int index=0;
			while(start<=end) {
				int mid=start+(end-start)/2;
				if(arr[mid]==arr[start]&&arr[mid]==arr[end])
				{
					if(arr[mid]<ans) {
						ans=arr[mid];
						index=mid;
					}
					start++;
					end--;
					continue;
				}
				if(arr[start]<=arr[mid]) {
					if(arr[start]<ans) {
					ans=arr[start];
					index=start;
					}
					start=mid+1;
					
				}else {
					if(arr[mid]<ans) {
					ans=arr[mid];
					index=mid;
					}
					end=mid-1;
				}
			}
			return index;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
