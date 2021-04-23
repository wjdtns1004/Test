package scofe2021;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class pro_dfs02 {
	public static int go(int i, int[][] computers) {
        int answer = 0;
        return answer;
    }
	
	public static int solution(int n, int[][] computers) {
        int answer = 0;
        Set<Integer> node = new HashSet<Integer>();
        LinkedList<Integer> link = new LinkedList<Integer>();
        
        for (int i = 0; i < n; i++) {
			for (int j = 0; j < i; j++) {
					if(computers[i][j] == 1)
						node.add(j);
			}
		}
        answer = n-node.size();
        return answer;
    }

	public static void main(String[] args) {
		int n = 3;
		int[][] computers = {{1, 0, 1, 0, 0, 0}, {0, 1, 0, 1, 0, 0}, {1, 0, 1, 0, 0, 0}, {0, 1, 0, 1, 0, 1}, {0, 0, 0, 0, 1, 0}, {0, 0, 0, 1, 0, 1}};
//		int[][] computers = {{1, 1, 0}, {1, 1, 1}, {0, 1, 1}};
		System.out.println(solution(n, computers));

	}

}
