package Programmers.greedy.level2;

import java.util.Arrays;
import java.util.Comparator;

/*
요격 시스템
URL : https://school.programmers.co.kr/learn/courses/30/lessons/181188

테스트 1 〉	통과 (0.44ms, 78.5MB)
테스트 2 〉	통과 (0.38ms, 77.1MB)
테스트 3 〉	통과 (0.71ms, 77.6MB)
테스트 4 〉	통과 (1.52ms, 83.1MB)
테스트 5 〉	통과 (12.55ms, 84.8MB)
테스트 6 〉	통과 (147.61ms, 134MB)
테스트 7 〉	통과 (435.55ms, 173MB)
테스트 8 〉	통과 (342.53ms, 175MB)
테스트 9 〉	통과 (332.71ms, 186MB)
테스트 10 〉	통과 (15.11ms, 160MB)
테스트 11 〉	통과 (0.34ms, 83.2MB)

 */
public class Lesson_181188 {

    public static int solution(int[][] targets) {
        System.out.println("Start solution.");
        int answer = 0;
        Arrays.sort(targets, (o1, o2) -> o1[1] - o2[1]);

        for(int i=0; i<targets.length; i++) {
            System.out.println(i + " : [" + targets[i][0] + "] [" + targets[i][1] + "]");
        }

        int point = 0;
        for(int i=0; i<targets.length; i++) {
            int[] target = targets[i];

            int start = target[0];
            int end = target[1];

            if(start < point) {
                continue;
            }

            point = end;
            answer++;
        }

        return answer;
    }

    //[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]
    public static void main(String[] args) {
        int[][] list = new int[7][2];

        list[0][0] = 5;
        list[0][1] = 6;
        list[1][0] = 4;
        list[1][1] = 8;
        list[2][0] = 10;
        list[2][1] = 14;
        list[3][0] = 11;
        list[3][1] = 13;
        list[4][0] = 5;
        list[4][1] = 12;
        list[5][0] = 3;
        list[5][1] = 7;
        list[6][0] = 1;
        list[6][1] = 4;

        int result = solution(list);
        System.out.println("result=" + result);

    }
}
