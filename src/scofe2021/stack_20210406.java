package scofe2021;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class stack_20210406 {
    public static int[] solution(int[] progresses, int[] speeds) {
        List<Integer> list = new ArrayList<Integer>();
        int temp_days = new BigDecimal(100-progresses[0]).divide(new BigDecimal(speeds[0]),0 , BigDecimal.ROUND_CEILING).intValue();
        int count = 1;
        for (int i = 1; i < progresses.length; i++) {
        	int days = new BigDecimal(100-progresses[i]).divide(new BigDecimal(speeds[i]),0 , BigDecimal.ROUND_CEILING).intValue();
        	if(temp_days < days) {
        		list.add(count);
        		temp_days = days;
        		count = 0;
        	}
        	count++;
		}
        list.add(count);
        
        int[] answer = new int [list.size()];
        for (int i = 0; i < list.size(); i++) {
        	answer[i] = list.get(i);
        	System.out.println(answer[i]);
		}
        
        return answer;
    }

	public static void main(String[] args) {
		int[] progresses = {93, 30, 55}; 
		int[] speeds = {1, 30, 5};
		solution(progresses, speeds);
//		[2, 1]
		System.out.println("---------------");
		int[] progresses2 = {95, 90, 99, 99, 80, 99}; 
		int[] speeds2 = {1, 1, 1, 1, 1, 1};
		solution(progresses2, speeds2);
//		[1, 3, 2]

	}

}
