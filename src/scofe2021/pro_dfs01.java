package scofe2021;

import java.util.ArrayList;
import java.util.List;

public class pro_dfs01 {
	public static int solution(int[] numbers, int target) {
		int count = 0;
		int N = numbers.length-1;
		List<Integer> list = new ArrayList<Integer>();
		list.add(numbers[0]);
		list.add(-numbers[0]);
		
		for (int i = 1; i <= N; i++) {
			List<Integer> list_temp = new ArrayList<Integer>(list);
			list = new ArrayList<Integer>();
			for (Integer node : list_temp) {
				list.add(node+numbers[i]);
				list.add(node-numbers[i]);
				if(i == N) {
					if(node+numbers[i] == target) {
						count++;
					}
					if(node-numbers[i] == target) {
						count++;
					}
				}
			}
		}
        
        return count;
    }

	public static void main(String[] args) {
		int arr[] = {1,1,1,1,1};
		int target = 3;
		System.out.println(solution(arr, target));
	}

}
