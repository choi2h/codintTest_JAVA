package inflearn.sorting;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 {
    public String solution(int n, int[] arr) {
        String answer="U";

        Arrays.sort(arr);
        for(int i=0; i<n-1; i++) {
            if(arr[i] == arr[i+1]) return "D";
        }

        /*
            Map<Integer, Integer> map = new HashMap<>();
            for(int i=0; i<n; i++) {
                if(map.put(arr[i], 1) != null) {
                    return "D";
                }

            }
        */

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        Q5 q = new Q5();
        System.out.println(q.solution(n, arr));
    }
}
