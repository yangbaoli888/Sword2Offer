/**
* @author Brady
* @version 2019年8月12日 下午10:05:11
*/

//题目描述：请实现一个函数，把字符串中的每个空格替换成 %20 ，
//例如"We are happy."替换为"We%20are%20happy."
public class _05替换空格 {

	public static void main(String[] args) {
		String str = "We are happy.";	
		char data[] = str.toCharArray();
		char[] result = replaceBlank(data);
		for(char c : result)
			System.out.print(c);
	}

	static char[] replaceBlank(char[] input) {
		int originalLen = input.length;
		if(originalLen <= 0)
			return null;
		
		int blankNum = 0;
		for(char c : input)
			if(c == ' ')
				blankNum++;
		
		int newLen = originalLen + 2*blankNum;
		char[] result = new char[newLen];
		
		while(originalLen >= 1 && newLen >= originalLen) {
			--originalLen;
			if(input[originalLen] == ' ') {
				result[--newLen] = '0';
				result[--newLen] = '2';
				result[--newLen] = '%';
			}
			else
				result[--newLen] = input[originalLen];			
		}
		
		return result;
				
	}
}
