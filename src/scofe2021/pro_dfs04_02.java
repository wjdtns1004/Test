package scofe2021;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class pro_dfs04_02 { 
    public static void route(String[][] tickets, String[] output, boolean[] visited, int depth, int n) {
    	int index = -1;
	    if (depth == n) {
	    	return;
	    }else if(depth == 0) {
	    	output[depth] = "ICN";
	    	depth = 1;
	    }
	 
	    for (int i=0; i<tickets.length; i++) {
	        if (visited[i] != true) {
	        	if(output[depth-1].equals(tickets[i][0])) {
	        		for (int j=0; j<tickets.length; j++) {
		    	        if (visited[j] == true) {
		    	        	if(tickets[i][0].equals(tickets[j][0]) && tickets[i][1].equals(tickets[j][1])) {
		    	        		visited[i] = true;
			    	        	n--;
		    	        	}
		    	        }
		    	    }
	        		if (visited[i] != true) {
		        		if(index == -1) {
		        			index = i;
		        		}
		        		if(index != -1 && tickets[i][1].compareTo(tickets[index][1])<0) {
		        			index = i;
		        		}
	        		}
	        	}
	        }
	        if(index!= -1 && i == tickets.length-1) {
    			visited[index] = true;
	            output[depth] = tickets[index][1];
	            route(tickets, output, visited, depth+1, n);
	            visited[index] = false;
    		}
	    }
	}
    
    public static String[] solution(String[][] tickets) {
        String[] output = new String[tickets.length+1];
        boolean[] visited = new boolean[tickets.length];
        route(tickets, output, visited, 0, tickets.length+1);
        List<String>list = Arrays.asList(output);
        List<String> result = list.stream().filter(x->x!=null).collect(Collectors.toList());
        output = result.toArray(new String[result.size()]);
        return output;
    }

	public static void main(String[] args) {
//		String[][] tickets = {{"ICN", "JFK"}, {"HND", "IAD"}, {"JFK", "HND"}}; // ["ICN", "JFK", "HND", "IAD"]
//		String[][] tickets = {{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL","SFO"}};// ["ICN", "ATL", "ICN", "SFO", "ATL", "SFO"] 
//		String[][] tickets = {{"ICN","AAA"},{"ICN","AAA"},{"ICN","AAA"},{"AAA","ICN"},{"AAA","ICN"}};
		String[][] tickets = {{"ICN","B"},{"B","ICN"},{"ICN","A"},{"A","D"},{"D","A"}}; //['ICN', 'B', 'ICN', 'A', 'D', 'A']
//		String[][] tickets = { { "ICN", "BOO" }, { "ICN", "COO" }, { "COO", "DOO" }, { "DOO", "COO" }, { "BOO", "DOO" },{ "DOO", "BOO" }, { "BOO", "ICN" }, { "COO", "BOO" } };
		String[] answer = solution(tickets);
		
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}

}