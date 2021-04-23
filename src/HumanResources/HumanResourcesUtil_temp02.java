package HumanResources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HumanResourcesUtil_temp02 {
	public static int[] solution(int[] answers) {
		List<Integer> list = new ArrayList<Integer>();
        int[] answer = {0, 0, 0};
        int[] temp = {0, 0, 0};
        int[][] people = {{1, 2, 3, 4, 5},{2, 1, 2, 3, 2, 4, 2, 5},{3, 3, 1, 1, 2, 2, 4, 4, 5, 5}};
        for (int i = 0; i < answers.length; i++) {
			for (int j = 0; j < people.length; j++) {
				if(answers[i] == people[j][i%people[j].length]) {
					answer[j] = answer[j]+1;
					temp[j] = temp[j]+1;
				}
			}
		}
        Arrays.sort(temp);
        int max = temp[temp.length-1];
        for (int i = 0; i < answer.length; i++) {
			if(answer[i] == max) {
				list.add(i+1);
			}
		}
        return list.stream().mapToInt(x->x).toArray();
    }

	public static void main(String[] args) {
//		int[] answers= {1,2,3,4,5};
		int[] answers= {1,3,2,4,2};
		int[] result = solution(answers);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}

}
