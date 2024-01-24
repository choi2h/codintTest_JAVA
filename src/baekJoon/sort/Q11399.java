package baekJoon.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
ATM
https://www.acmicpc.net/problem/11399
선택정렬을 이용한 문제풀이
 */
public class Q11399 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        String[] nums = br.readLine().split(" ");
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(nums[i]);

            for(int j=0; j<=i; j++) {
                if(arr[j] > arr[i]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }

        int time = 0;
        int includeValue = 0;
        for(int i=0; i<n; i++) {
            time += includeValue+arr[i];
            includeValue += arr[i];
        }

        System.out.println(time);
    }
}
