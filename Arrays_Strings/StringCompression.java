package arrays;

public class StringCompression {
	public int compress(char[] chars) {

		int i=0;
		int j=0;
		while(i<chars.length) {
			char curr=chars[i];
			int count=0;
			while(i<chars.length&&chars[i]==curr)
			{
				count++;
				i++;
			}

			chars[j++]=curr;

			if(count>1){
				String countStr=Integer.toString(count);
				for(char ch:countStr.toCharArray())
					chars[j++]=ch;
			}
		}
		return j;
	}
}