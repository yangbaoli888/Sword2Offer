/**
 * 2019年7月18日
 * Administrator
 */
/**
* @author Brady
* @version 2019年7月18日 上午10:34:08
*/
//题目描述：给你一根长度为N的绳子，请把绳子剪成m段（m,n都是正整数并且均大于1），
//每段绳子的长度记为k[0],k[1],k[2]...。请问
//k[0]*k[1]*k[2]*...k[m]的最大值是多少？

public class _14剪绳子 {
	
	public static void main(String[] args) {
		int len = 15;
		System.out.println(maxCutting1(len));
		System.out.println(maxCutting2(len));
		
	}
	
	/**
	 * 使用动态规划方法
	 * @param len
	 * @return
	 */
	static int maxCutting1(int len) {
		//因为n与m均大于1
		if(len <= 1)
			return -1;
		//当绳子长度为2时只能切成1,1两段
		if(len == 2)
			return 1;
		//当绳子长度为3时有1,2与1,1,1两种切法，最大值为2
		if(len == 3)
			return 2;
		
		int maxAns[] = new int[len + 1];
		//此处四个值并不是最优解。当len<=3时切开绳子的乘积小于不切开，所以当len>=4时可以选择不切开长度小于3的绳子时就不切开
		maxAns[0] = 0;
		maxAns[1] = 1;
		maxAns[2] = 2;
		maxAns[3] = 3;
		
		for(int i = 4; i <= len; i++) {
			int max = 0;
			//除以2的目的是为了排除掉i - j的重复的一半
			for(int j = 1; j <= i/2; j++) {
				int maxresult = (maxAns[j] * maxAns[i-j]);
				max = (max > maxresult ? max : maxresult);
			}
			maxAns[i] = max;
		}
		return maxAns[maxAns.length - 1];
	}
	
	/**
	 * 使用贪心算法求解
	 * 贪心算法的思想是每一步求最优解，一步步到最后就是整个问题的最优解
	 * @param len
	 * @return
	 */
	static int maxCutting2(int len) {
		//先将特殊值计算得到
		if(len <= 1)
			return -1;
		else if(len == 2)
			return 2;
		else if(len == 3)
			return 2;
		else if(len == 4)
			return 4;
		int result = 1;
		
		//当len >= 5时通过观察可以发现截取出长度为3的段可以将乘积最大化
		//辗转乘、减操作直至len<5不用继续切割
		while(len >= 5) {
			result *= 3;
			len -= 3;
		}
		//乘积最后乘上最后一段的长度
		result *= len;
		return result;
	}

}
