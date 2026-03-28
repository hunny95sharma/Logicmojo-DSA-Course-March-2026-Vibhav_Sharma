package binary_search;

public class MinRotatedSortedArray {
	
	public int fetchMinRotatedSortedArray(int arr[]) {
		int start=0;
		int end=arr.length-1;
		int ans=Integer.MAX_VALUE;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[start]<=arr[mid]) {
				if(arr[start]<ans)
				ans=arr[start];
				start=mid+1;
				
			}else {
				if(arr[mid]<ans)
				ans=arr[mid];
				end=mid-1;
			}
		}
		return ans;
	}
	
	public int fetchMinRotatedSortedArrayDuplicate(int arr[]) {
		 int start=0;
			int end=arr.length-1;
			int ans=Integer.MAX_VALUE;
			while(start<=end) {
				int mid=start+(end-start)/2;
				if(arr[mid]==arr[start]&&arr[mid]==arr[end])
				{
					if(arr[mid]<ans)
						ans=arr[mid];
					start++;
					end--;
					continue;
				}
				if(arr[start]<=arr[mid]) {
					if(arr[start]<ans)
					ans=arr[start];
					start=mid+1;
					
				}else {
					if(arr[mid]<ans)
					ans=arr[mid];
					end=mid-1;
				}
			}
			return ans;
	}

	public static void main(String[] args) {

	}

}
