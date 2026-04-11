package arrays;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
	
	public static boolean fetchHappyNumberUsingExtraMemory(int n) {
		Set<Integer>set=new HashSet<>();
		while(true) {
			int remainder=0;
			int sum=0;
			while(n!=0) {
				remainder=n%10;
				sum=sum+(remainder*remainder);
				n=n/10;
			}
			if(sum==1)
				return true;
			else if(set.contains(sum)) {
				return false;
			}
			else
				n=sum;
			set.add(sum);
		}
	}
	
	
	public static boolean fetchHappyNumberUsingFastAndSlowPointer(int n) {
		int slow=n;
		int fast=n;
		while(true) {
			slow=getNext(slow);
			fast=getNext(getNext(fast));
			if(slow==1)
				return true;
			if(slow==fast)
				return false;
		}
	}
	
	private static int getNext(int n) {
	    int sum = 0;
	    while (n != 0) {
	        int digit = n % 10;
	        sum += digit * digit;
	        n /= 10;
	    }
	    return sum;
	}

	public static void main(String[] args) {
		
		System.out.println(fetchHappyNumberUsingFastAndSlowPointer(3));

	}

}
