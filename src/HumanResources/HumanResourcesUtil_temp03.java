package HumanResources;

public class HumanResourcesUtil_temp03 {
	public static int solution(int n, int[] lost, int[] reserve) {
        int answer = n-lost.length;
        boolean[] visited = new boolean[reserve.length];
        
        for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if(visited[j] != true) {
					if(lost[i] == reserve[j]-1) {
						visited[j] = true;
						answer++;
						break;
					}else if(lost[i] == reserve[j]+1) {
						visited[j] = true;
						answer++;
						break;
					}
				}
			}
		}
        return answer;
    }

	public static void main(String[] args) {
		int n = 5;
		int[] lost= {2, 4};
//		int[] reserve= {1, 3, 5};
		int[] reserve= {3};
		
		System.out.println(solution(n,lost, reserve));
	}

}
