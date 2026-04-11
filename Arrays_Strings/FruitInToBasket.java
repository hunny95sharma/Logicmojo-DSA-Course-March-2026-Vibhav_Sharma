package arrays;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitInToBasket {
	
	public static int fetchFruitInToBasketBruteForce(int[]fruits) {
		int maximumLength=Integer.MIN_VALUE;
		for(int i=0;i<fruits.length;i++) {
			Set<Integer>set=new HashSet<>();
			for(int j=i;j<fruits.length;j++) {
				set.add(fruits[j]);
				if(set.size()<=2) {
					if((j-i+1)>maximumLength)
						maximumLength=j-i+1;
				}else
					break;
			}
		}
		return maximumLength;
	}
	
	public static int fetchFruitInToBasketSlidingWindowOptimal(int[]fruits) {
		int maximumLength=Integer.MIN_VALUE;
		int start=0;
		int end=0;
		Map<Integer,Integer>map=new HashMap<>();
		while(end<fruits.length) {
			map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
			while(map.size()>2) {
				map.put(fruits[start], map.getOrDefault(fruits[start], 0) -1 );
				if(map.get(fruits[start])==0)
					map.remove(fruits[start]);
				start++;
			}
			if(map.size()<=2) {
				if((end-start+1)>maximumLength) {
					maximumLength=end-start+1;
				}
			}
			end++;
		}
		return maximumLength;	
	}
	
	public static int fetchFruitInToBasketSlidingWindowBest(int[]fruits) {
		int maximumLength=Integer.MIN_VALUE;
		int start=0;
		int end=0;
		Map<Integer,Integer>map=new HashMap<>();
		while(end<fruits.length) {
			map.put(fruits[end], map.getOrDefault(fruits[end], 0) + 1);
			if(map.size()>2) {
				map.put(fruits[start], map.getOrDefault(fruits[start], 0) -1 );
				if(map.get(fruits[start])==0)
					map.remove(fruits[start]);
				start++;
			}
			if(map.size()<=2) {
				if((end-start+1)>maximumLength) {
					maximumLength=end-start+1;
				}
			}
			end++;
		}
		return maximumLength;
	}
}
