package scofe2021;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class scofe2021_question2 {
	public static int fact(int n) {
		if(n<=1)
			return 1;
		else
			return fact(n-1)*n;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(bf.readLine());
		String input = bf.readLine();
		input = input.replaceAll("101", "1");
		N = input.length()-1;
		int answer = 0;
		
		for (int i = 0; i <= N; i+=2) {
			int step2 = (i+1)/2;
			int step1 = N-step2*2;
			int sol = fact(step1+step2)/(fact(step1)*fact(step2));
			answer +=sol;
			System.out.println("fact("+step1+"+"+step2+")/(fact("+step1+")*fact("+step2+")) : "+sol);
		}
		System.out.println("answer : "+answer);
	}

}
