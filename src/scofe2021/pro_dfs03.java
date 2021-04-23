package scofe2021;

public class pro_dfs03 {
	static int result_count = 1;
	public static int match(String begin, String next) {
		int result = 0;
		int count = 0;
		for (int i = 0; i < begin.length(); i++) {
			if(begin.charAt(i) == next.charAt(i)) {
				count++;
			}
		}
		if(begin.length() == count)
			result = -1;// 일치
		else if(begin.length()-1 == count)
			result = 1;// 한 글자 빼고 일치
		else
			result = 0;// 불일치
		
        return result;
    }
	
	public static int match_re(String begin, String target, String[] words, boolean[] visited) {
        for (int i = 0; i < words.length; i++) {
			if(visited[i] == false) {
				if(match(begin, target) == 1) {
					System.out.println(target);
					return result_count;
				}
				if(match(begin, words[i]) == 1) {
					visited[i] = true;
					if(match(words[i], target) == 1) {
						System.out.println(target);
						System.out.println(words[i]);
						
						return ++result_count;
					}else {
						match_re(words[i], target, words, visited);
						System.out.println(words[i]);
						return ++result_count;
					}
				}else {
					visited[i] = true;
					match_re(begin, target, words, visited);
					return result_count;
				}
				
			}
		}
        return result_count;
    }
	
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
        boolean[] visited = new boolean[words.length];
        boolean flag = false;
        for (int i = 0; i < words.length; i++) {
			if(match(target, words[i]) == -1)
				flag = true;
		}
        
        if(flag) {
        	answer = match_re(begin, target, words, visited);
        }else {
        	answer = 0;
        }
        System.out.println(answer);
        return answer;
    }

	public static void main(String[] args) {
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "nog","cog"};
		solution(begin, target, words);

	}

}
