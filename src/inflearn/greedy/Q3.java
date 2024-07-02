package inflearn.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q3 {


    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();

        int[][] times = new int[n][2];
        for(int i=0; i<n; i++) {
            times[i][0] = in.nextInt();
            times[i][1] = in.nextInt();
        }

        int result = solution(times);
        System.out.println(result);
    }


    private static int solution(int[][] times) {
        Arrays.sort(times, new Comparator<>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }

                return o1[1] - o2[1];
            }
        });

        int answer = 0;
        int s = 0;
        int e = 1;
        while (e < times.length) {
            while (s<e && times[e][0] >= times[s][1]) {
                s++;
            }

            answer = Math.max(answer, e-s+1);
            e++;
        }


        return answer;
    }


}
