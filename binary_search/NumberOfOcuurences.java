package binary_search;

public class NumberOfOcuurences {
	
	public static int[] fetchFirstLastPositionCombined(int arr[],int target) {
		int first=-1;
		int start=0;
		int end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) {
				first=mid;
				end=mid-1;
			}else if(arr[mid]>target) {
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
			if(arr[mid]==target) {
				last=mid;
				start=mid+1;
			}else if(arr[mid]>target) {
				end=mid-1;
			}else {
				start=mid+1;
			}
		}
		return new int[] {first,last};
	}
	
	public static int searchRange(int[] nums, int target) {
		 int res[]=fetchFirstLastPositionCombined(nums,target);
			if(res[0]==-1)
				return 0;
			return res[1]-res[0]+1;
    }
	

	public static void main(String[] args) {
		
   
		System.out.println(searchRange(new int[] {1,1,1,2,2,3,3,3,3,3,3},3));
		
	}

}
