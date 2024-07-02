package inflearn.greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Q2 {

    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int n = in.nextInt();
        int[][] meetings = new int[n][2];
        for(int i=0; i<n; i++) {
            meetings[i][0] = in.nextInt();
            meetings[i][1] = in.nextInt();
        }

        int result = solution(meetings);
        System.out.println(result);
    }

    private static int solution(int[][] meetings) {

        Arrays.sort(meetings, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1]) {
                    return o1[0]-o2[0];
                }

                return o1[1]-o2[1];
            }
        });

        int count = 0;
        int time = 0;
        for(int[] meeting : meetings) {
            if(meeting[0] >= time) {
                count++;
                time = meeting[1];
            }
        }

        return count;
    }
}
