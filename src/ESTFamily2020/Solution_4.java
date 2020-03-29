package ESTFamily2020;

import java.util.*;

public class Solution_4 {

	public static String solution(String S, String C) {
		StringBuilder answer = new StringBuilder();
		Set<String> nameMap = new HashSet<>();
		String[] name = S.split("; ");
		
		for (int i = 0; i < name.length; ++i) {
			answer.append(name[i]).append(" <");
			
			String[] nameSplit = name[i].split(" ");
			StringBuilder sb = new StringBuilder();
			sb.append(nameSplit[nameSplit.length-1].toLowerCase().replace("-", ""))
			  .append("_")
			  .append(nameSplit[0].toLowerCase());
			
			String realName = sb.toString();
			String subName = sb.toString();
			int cnt = 2;
			
			while (nameMap.contains(subName))
				subName = realName + cnt++;
			
			nameMap.add(subName);
			answer.append(subName).append("@").append(C.toLowerCase()).append(".com>");
			if (i != name.length-1) answer.append("; ");
		}
		
		return answer.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(solution("John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; John Evan Doe; Jane Doe; Peter Brian Parker", "Example"));
	}

}
