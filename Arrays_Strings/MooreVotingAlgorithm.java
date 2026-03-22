package arrays;

public class MooreVotingAlgorithm {
	
	public static int mooreVotingMajorityAlgorithm(int arr[]) {
		int majorityElement=arr[0];
		int count=1;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]==majorityElement)
				count++;
			else
				count--;
			if(count==0) {
				majorityElement=arr[i];
				count=1;
			}
		}
		count=0;
		for(int i=0;i<arr.length;i++) {
			if(majorityElement==arr[i])
				count++;
		}
		if(count>arr.length/2)
		return majorityElement;
		else
			return -1;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println(mooreVotingMajorityAlgorithm(new int[] {3, 3, 4, 2, 4, 4, 2, 4, 4}));
	}

}
