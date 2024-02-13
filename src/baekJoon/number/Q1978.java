package baekJoon.number;

import java.util.Scanner;

// 소수 찾기
// https://www.acmicpc.net/problem/1978
public class Q1978 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        int count = 0;
        String[] nums = sc.nextLine().split(" ");
        for(int i=0; i<n; i++){
            int num =Integer.parseInt(nums[i]);
            int max = (int) Math.sqrt(num);

            boolean isPrimeNumber = num != 1;
            for(int j=2; j<=max; j++) {
                if(num%j==0) {
                    isPrimeNumber = false;
                    break;
                }
            }

            count += isPrimeNumber ? 1 : 0;
        }


        System.out.println(count);
    }
}
