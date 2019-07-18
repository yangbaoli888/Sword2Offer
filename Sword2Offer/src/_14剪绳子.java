/**
 * 2019��7��18��
 * Administrator
 */
/**
* @author Brady
* @version 2019��7��18�� ����10:34:08
*/
//��Ŀ����������һ������ΪN�����ӣ�������Ӽ���m�Σ�m,n�������������Ҿ�����1����
//ÿ�����ӵĳ��ȼ�Ϊk[0],k[1],k[2]...������
//k[0]*k[1]*k[2]*...k[m]�����ֵ�Ƕ��٣�

public class _14������ {
	
	public static void main(String[] args) {
		int len = 15;
		System.out.println(maxCutting1(len));
		System.out.println(maxCutting2(len));
		
	}
	
	/**
	 * ʹ�ö�̬�滮����
	 * @param len
	 * @return
	 */
	static int maxCutting1(int len) {
		//��Ϊn��m������1
		if(len <= 1)
			return -1;
		//�����ӳ���Ϊ2ʱֻ���г�1,1����
		if(len == 2)
			return 1;
		//�����ӳ���Ϊ3ʱ��1,2��1,1,1�����з������ֵΪ2
		if(len == 3)
			return 2;
		
		int maxAns[] = new int[len + 1];
		//�˴��ĸ�ֵ���������Ž⡣��len<=3ʱ�п����ӵĳ˻�С�ڲ��п������Ե�len>=4ʱ����ѡ���п�����С��3������ʱ�Ͳ��п�
		maxAns[0] = 0;
		maxAns[1] = 1;
		maxAns[2] = 2;
		maxAns[3] = 3;
		
		for(int i = 4; i <= len; i++) {
			int max = 0;
			//����2��Ŀ����Ϊ���ų���i - j���ظ���һ��
			for(int j = 1; j <= i/2; j++) {
				int maxresult = (maxAns[j] * maxAns[i-j]);
				max = (max > maxresult ? max : maxresult);
			}
			maxAns[i] = max;
		}
		return maxAns[maxAns.length - 1];
	}
	
	/**
	 * ʹ��̰���㷨���
	 * ̰���㷨��˼����ÿһ�������Ž⣬һ������������������������Ž�
	 * @param len
	 * @return
	 */
	static int maxCutting2(int len) {
		//�Ƚ�����ֵ����õ�
		if(len <= 1)
			return -1;
		else if(len == 2)
			return 2;
		else if(len == 3)
			return 2;
		else if(len == 4)
			return 4;
		int result = 1;
		
		//��len >= 5ʱͨ���۲���Է��ֽ�ȡ������Ϊ3�Ķο��Խ��˻����
		//շת�ˡ�������ֱ��len<5���ü����и�
		while(len >= 5) {
			result *= 3;
			len -= 3;
		}
		//�˻����������һ�εĳ���
		result *= len;
		return result;
	}

}
