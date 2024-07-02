package baekJoon.dynamic;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q2565 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }

        int result = solution(arr);
        System.out.println(result);
    }

    private static int solution(int[][] arr) {
        Arrays.sort(arr, Comparator.comparingInt((int[] a) -> a[1]));

        int answer = 0;
        for(int i=0; i<arr.length; i++) {
            int index = i;
            int pre = arr[index++][0];
            int count = 1;
            while (index < arr.length) {
                    if(pre < arr[index][0]) {
                        pre = arr[index][0];
                        count++;
                    }
                    index++;
            }

            answer = Math.max(answer, count);
        }


        return arr.length-answer;
    }
}
