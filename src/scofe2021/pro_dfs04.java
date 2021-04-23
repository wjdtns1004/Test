package scofe2021;

import java.util.ArrayList;
import java.util.List;

public class pro_dfs04 {
	static int count = 2;
	static int index = 0;
	static String answer_str ="";
	public static String[] route(String[][] tickets, String[] answer, String pos, boolean[] visited) {
        for (int i = 0; i < tickets.length; i++) {
        	if(visited[i] == false && !answer_str.matches("(.*)"+tickets[i][0]+"-"+tickets[i][1]+"(.*)")) {
        		if(answer[0] == null) {
        			if(tickets[i][0].equals(pos)) {
        				if(answer[1] == null) {
        					index = i;
            				answer[1] = tickets[i][1];
        				}else {
        					if(answer[1].compareTo(tickets[i][1])>0) {
        						index = i;
                				answer[1] = tickets[i][1];
        					}
        				}
        			}
        			if(i == tickets.length-1) {
        				answer_str = pos+"-"+answer[1];
    					visited[index] = true;
    					answer[0] = pos;
    					route(tickets, answer, answer[1], visited);
    				}
        		}else {
        			if(pos.equals(tickets[i][0])) {
        				if(answer[count] == null) {
        					index = i;
        					answer[count] = tickets[i][1];
        				}else {
        					if(answer[count].compareTo(tickets[i][1])>0) {
        						index = i;
        						answer[count] = tickets[i][1];
        					}
        				}
        			}
        			if(i == tickets.length-1 && answer[count] != null) {
        				answer_str += "-"+answer[count];
        				visited[index] = true;
        				++count;
        				route(tickets, answer, answer[count-1], visited);
    				}
        		}
        	}
		}
        return answer;
    }
	
	public static String[] solution(String[][] tickets) {
        String[] answer = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        route(tickets, answer, "ICN", visited);
        List<String> list = new ArrayList<String>();
        for (int i = 0; i < answer.length; i++) {
        	if(answer[i] != null) {
        		System.out.println(answer[i]);
    			list.add(answer[i]);
        	}
		}
        
        return list.toArray(new String[list.size()]);
    }

	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; // ["ICN", "JFK", "HND", "IAD"]
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};// ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 
		String[][] tickets = {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};
		solution(tickets);
	}

}
