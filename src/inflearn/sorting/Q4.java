package inflearn.sorting;

import java.util.Scanner;

public class Q4 {
    public int[] solution(int n, int m, int[] arr) {
        int[] answer = new int[n];

        for(int i=0; i<m; i++) {
            int p = n-1;
            for(int j=0; j<n; j++) {
                if(answer[j] == 0 || answer[j] == arr[i]) {
                  p = j;
                  break;
                }
            }

            for(int k=p; k>0; k--) {
                answer[k] = answer[k-1];
            }

            answer[0] = arr[i];
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[m];
        for(int i=0; i<m; i++) {
            arr[i] = in.nextInt();
        }

        Q4 q = new Q4();
        int[] result = q.solution(n, m, arr);
        for(int i : result) {
            System.out.print(i + " ");
        }
    }
}
