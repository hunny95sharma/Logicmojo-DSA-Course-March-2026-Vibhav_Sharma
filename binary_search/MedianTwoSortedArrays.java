package arrays;

public class MedianTwoSortedArrays {
	
	public static double fetchMedianTwoSortedArraysExtraMemory(int[] nums1,int[] nums2) {
		int[]nums3=new int[nums1.length+nums2.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<nums1.length&&j<nums2.length) {
			if(nums1[i]>nums2[j]) {
				nums3[k]=nums2[j];
				k++;
				j++;
			}else {
				nums3[k]=nums1[i];
				k++;
				i++;
			}
		}
		while(i<nums1.length) {
			nums3[k]=nums1[i];
			k++;
			i++;
		}
		while(j<nums2.length) {
			nums3[k]=nums2[j];
			k++;
			j++;
		}
		if(nums3.length==1)
			return nums3[0];
		double midValue;
		int n = nums3.length;
		if (n % 2 == 0) {  // even length
		    int midIndex = n / 2;
		    midValue = (nums3[midIndex - 1] + nums3[midIndex]) / 2.0;
		} else {           // odd length
		    int midIndex = n / 2;
		    midValue = nums3[midIndex];
		}

		return midValue;
	}
	
	public static double fetchMedianTwoSortedArraysWithOutExtraMemory(int[] nums1,int[] nums2) {
		int oddValue=0;
		int oddIndex=-1;
		int evenValue1=0;
		int evenValue2=0;
		int evenIndex1=-1;
		int evenIndex2=-1;
		int n=nums1.length+nums2.length;
		if(n%2==0) {
			evenIndex1=n/2-1;
			evenIndex2=n/2;
		}else {
			oddIndex=n/2;
		}
		int i=0;
		int j=0;
		int k=0;
		int limit=n%2==0?evenIndex2:oddIndex;
		while(i<nums1.length&&j<nums2.length && k<=limit) {
			if(nums1[i]>nums2[j]) {
				if(k==oddIndex)
					oddValue=nums2[j];
				if(k==evenIndex1)
					evenValue1=nums2[j];
				if(k==evenIndex2)
					evenValue2=nums2[j];
				j++;
			}else {
				if(k==oddIndex)
					oddValue=nums1[i];
				if(k==evenIndex1)
					evenValue1=nums1[i];
				if(k==evenIndex2)
					evenValue2=nums1[i];
				i++;
			}
			k++;
		}
		while(i<nums1.length && k <= limit) {
			if(k==oddIndex)
				oddValue=nums1[i];
			if(k==evenIndex1)
				evenValue1=nums1[i];
			if(k==evenIndex2)
				evenValue2=nums1[i];
			k++;
			i++;
		}
		while(j<nums2.length && k <= limit) {
			if(k==oddIndex)
				oddValue=nums2[j];
			if(k==evenIndex1)
				evenValue1=nums2[j];
			if(k==evenIndex2)
				evenValue2=nums2[j];
			k++;
			j++;
		}
		double midValue;
		if (n % 2 == 0) {  // even length
		    midValue = (evenValue1 + evenValue2) / 2.0;
		} else {           // odd length
		    midValue = oddValue;
		}

		return midValue;
	}
	
	
	public static double fetchMedianTwoSortedArraysBinarySearch(int[] nums1, int[] nums2) {
	    int n1 = nums1.length;
	    int n2 = nums2.length;

	    // Ensure nums1 is smaller
	    if (n1 > n2) return fetchMedianTwoSortedArraysBinarySearch(nums2, nums1);

	    int low = 0;
	    int high = n1;
	    int left = (n1 + n2 + 1) / 2; // total elements on left partition

	    int n = n1 + n2;

	    while (low <= high) {
	        int mid1 = (low + high) / 2; // partition in nums1
	        int mid2 = left - mid1;      // partition in nums2

	        int l1 = (mid1 == 0) ? Integer.MIN_VALUE : nums1[mid1 - 1];
	        int r1 = (mid1 == n1) ? Integer.MAX_VALUE : nums1[mid1];

	        int l2 = (mid2 == 0) ? Integer.MIN_VALUE : nums2[mid2 - 1];
	        int r2 = (mid2 == n2) ? Integer.MAX_VALUE : nums2[mid2];

	        // Check if correct partition
	        if (l1 <= r2 && l2 <= r1) {
	            if (n % 2 == 0) {
	                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;
	            } else {
	                return Math.max(l1, l2);
	            }
	        } else if (l1 > r2) {
	            // Move partition left in nums1
	            high = mid1 - 1;
	        } else {
	            // Move partition right in nums1
	            low = mid1 + 1;
	        }
	    }
             return 0.0;
	}

	public static void main(String[] args) {
		//System.out.println(fetchMedianTwoSortedArraysBruteForce(new int[] {2,4},new int[] {3,5}));
		System.out.println(fetchMedianTwoSortedArraysWithOutExtraMemory(new int[] {1,2},new int[] {3,4}));
		//System.out.println(fetchMedianTwoSortedArraysWithOutExtraMemory(new int[] {},new int[] {1}));
	}

}
