package ESTFamily2020;

import java.util.*;

public class Solution_2 {

	@SuppressWarnings("unchecked")
	public static int solution(int[] A) {
		int answer = 0;
		List<Integer> bucket[] = new ArrayList[9*9+1];
		
		for (int i = 0; i <= 9*9; ++i)
			bucket[i] = new ArrayList<>();
		
		for (int x : A) {
			int digitSum = 0;
			int xx = x;
			
			while (xx > 0) {
				digitSum += xx % 10;
				xx /= 10;
			}
			bucket[digitSum].add(x);
		}
		
		for (List<Integer> b : bucket) {
			if (b.size() < 2) continue;
			
			int len = b.size();
			for (int i = 0; i < len-1; ++i) {
				for (int j = i+1; j < len; ++j)
					answer = Math.max(answer, b.get(i)+b.get(j));
			}
		}
		
		return answer > 0 ? answer : -1;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {51, 71, 17, 42}));	// 93
		System.out.println(solution(new int[] {42, 33, 60}));		// 102
		System.out.println(solution(new int[] {51, 32, 43}));		// -1
	}

}
