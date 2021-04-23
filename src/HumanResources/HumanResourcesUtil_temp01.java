package HumanResources;

import java.util.HashSet;

public class HumanResourcesUtil_temp01 {
//	완전탐색-소수 찾기
	// 배열 출력
	static HashSet<Integer> answerSet = new HashSet<Integer>();
    
	public static boolean prime(int[] arr, int r) {
		boolean answer = true;
		int numbers =0;
		String str = "";
		for (int i = 0; i < r; i++) {
			str +=arr[i];
		}
		numbers = Integer.parseInt(str);
		if(numbers == 1 || numbers == 0)
    		return false;
        for (int i = 2; i < numbers; i++) {
			if(numbers%i == 0) {
				answer = false;
				return answer;
			}
		}
        if(answer) {
        	answerSet.add(numbers);
        	System.out.println(numbers);
        }
        return answer;
    }
	
	public static void perm(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
	    if (depth == r) {
	    	if(prime(output, r)) {
	    		return;
	    	}
	    }
	 
	    for (int i=0; i<n; i++) {
	        if (visited[i] != true) {
	            visited[i] = true;
	            output[depth] = arr[i];
	            perm(arr, output, visited, depth + 1, n, r);       
	            visited[i] = false;;
	        }
	    }
	}
	
	public static int solution(String numbers) {
        int n = numbers.length();
        int[] output = new int[n];
        boolean[] visited = new boolean[n];
        int arr[] = new int[n];
        String str_arr[] = numbers.split("");
        for (int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(str_arr[i]);
		}
        
        for (int i = 1; i <= numbers.length(); i++) {
        	perm(arr, output, visited, 0, n, i);
		}
        return answerSet.size();
    }

	public static void main(String[] args) {
		System.out.println(solution("011"));

	}

}
