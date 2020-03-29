package ESTFamily2020;

public class Solution_3 {

	public static int solution(int[] A) {
		int answer = 0;
        int len = A.length;
        int check = 0;
        boolean isAlready = true;
        
        for (int i = 0; i < len-1; ++i) {
            if (A[i] < A[i+1]) {
                if (check == 1) {
                    isAlready = false;
                    break;
                }
                check = 1;
            }
            else if (A[i] > A[i+1]) {
                if (check == -1) {
                    isAlready = false;
                    break;
                }
                check = -1;
            }
            else {
                isAlready = false;
                break;
            }
        }
        
        if (isAlready) return 0;
        
        loop:for (int cut = 0; cut < len; ++cut) {
            check = 0;
            
            for (int i = 0; i < len-1; ++i) {
                if (i == cut) continue;
                
                if (i+1 == cut) {
                    if (i+1 != len-1) {
                        if (A[i] < A[i+2]) {
                            if (check == 1) continue loop;
                            check = 1;
                        }
                        else if (A[i] > A[i+2]) {
                            if (check == -1) continue loop;
                            check = -1;
                        }
                        else continue loop;
                    }
                }
                else {
                    if (A[i] < A[i+1]) {
                        if (check == 1) continue loop;
                        check = 1;
                    }
                    else if (A[i] > A[i+1]) {
                        if (check == -1) continue loop;
                        check = -1;
                    }
                    else continue loop;
                }
            }
            
            ++answer;
        }
        
        return answer > 0 ? answer : -1;
	}
	
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 4, 5, 3, 7}));	// 3
		System.out.println(solution(new int[] {1, 2, 3, 4}));		// -1
		System.out.println(solution(new int[] {1, 3, 1, 2}));		// 0
	}

}
