package scofe2021;

import java.util.Scanner;

public class q2_2 {

    static int result = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        String arr = sc.nextLine();
        go(arr, 0, n);

        System.out.println("결과 : " + result);

    }

    public static void go(String arr, int position, int n){
        if(position == n-1){
            result++;
        }else if(position < n && arr.charAt(position) == '1'){
            go(arr, position+1, n);
            go(arr, position+2, n);
        }
    }

}
