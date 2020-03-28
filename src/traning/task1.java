package traning;

/**
 * 
 * @author JBoom
 *
 * @date 2020.03.28 Clear
 *
 */
public class task1 {
	
	public static int solution(int N) {
		int ans = 0;
		String bi = Integer.toBinaryString(N);
		int len = bi.length();
		int cnt = 1;
		char fir = bi.charAt(0);
		int[] idx = new int[2];
		int firIdx = 0;
		
		for (int i = 1; i < len; ++i) {
			char cur = bi.charAt(i);
			
			if (fir == cur) {
				++cnt;
				firIdx = i - 2;
			}
			else {
				if (ans <= cnt) {
					ans = cnt;
					idx[0] = firIdx;
					idx[1] = i + 1;
				}
				cnt = 1;
				firIdx = i;
			}
			
			fir = cur;
		}
		
		if (idx[0] == 0 || idx[1] == len)
			ans = 0;
		
		return ans;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(1041));
		System.out.println(solution(9));
		System.out.println(solution(529));
		System.out.println(solution(20));
		System.out.println(solution(15));
		System.out.println(solution(32));
	}

}
