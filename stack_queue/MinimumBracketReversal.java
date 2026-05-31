package stack_queue;

public class MinimumBracketReversal {


	//Hume 2 cheeze track karni hotai hain:

	//	1. open → unmatched {
	//2. close → unmatched }
	//Why we use (size+1)/2 for both open and close?not in one like swap problem leetcode 1963

	//Because:

	//{ { { { → only open imbalance
	//} } { { → mixed imbalance
	//} } } } → only close imbalance

	public static int countBracketReversals(String s) {

		int n = s.length();
		if (n % 2 != 0) return -1;

		int open = 0;
		int close = 0;

		for (int i = 0; i < n; i++) {
			char ch = s.charAt(i);

			if (ch == '{') {
				open++;
			} else {
				if (open > 0) {
					open--;
				} else {
					close++;
				}
			}
		}

		return (open + 1) / 2 + (close + 1) / 2;
	}


}