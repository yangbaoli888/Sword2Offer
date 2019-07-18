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
		System.out.println(maxCutting(8));
		
	}
	
	static int maxCutting(int len) {
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

}
