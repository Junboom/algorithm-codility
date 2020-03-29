package ESTFamily2020;

public class Solution_1 {

	public static int solution(int[] A) {
		int answer = 0;
		int len = A.length;
		int[] num = new int[100001];
		
		for (int i = 0; i < len; ++i)
			++num[A[i]];
		
		for (int i = 100000; i > 0; --i) {
			if (num[i] == i) {
				answer = i;
				break;
			}
		}
		
		return answer;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 8, 2, 3, 3, 2}));	// 3
		System.out.println(solution(new int[] {7, 1, 2, 8, 2}));	// 2
		System.out.println(solution(new int[] {3, 1, 4, 1, 5}));	// 0
		System.out.println(solution(new int[] {5, 5, 5, 5, 5}));	// 5
	}

}
