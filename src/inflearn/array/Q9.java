package inflearn.array;

import java.util.Scanner;

/*
    격자판 최대합
    설명
    5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.
    N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.

    입력
    첫 줄에 자연수 N이 주어진다.(2<=N<=50)
    두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.
    출력
    최대합을 출력합니다.

    예시 입력 1
    5
    10 13 10 12 15
    12 39 30 23 11
    11 25 50 53 15
    19 27 29 37 27
    19 13 30 13 19
    예시 출력 1
    155
 */
public class Q9 {
    public int solution(int count, int[][] tables) {
        int answer = Integer.MIN_VALUE;
        int sum1, sum2;
        int sum3=0;
        int sum4=0;
        for(int i=0; i<count; i++) {
            sum1=sum2=0;
            for(int j=0; j<count; j++) {
                sum1+=tables[i][j];
                sum2+=tables[j][i];
            }

            sum3+=tables[i][i];
            sum4+=tables[i][count-i-1];

            answer=Math.max(answer, sum1);
            answer=Math.max(answer, sum2);
        }

        answer=Math.max(answer, sum3);
        answer=Math.max(answer, sum4);


        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[][] tables = new int[count][count];
        for(int i=0; i<count; i++) {
            for(int j=0; j<count; j++) {
                tables[i][j] = in.nextInt();
            }
        }

        Q9 q = new Q9();
        int result = q.solution(count, tables);
        System.out.println(result);
    }
}
