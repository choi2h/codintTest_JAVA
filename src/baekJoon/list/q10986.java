package baekJoon.list;

import java.util.Scanner;

/*
    [백준 - 10986번 - 나머지 합]
    문제
    수 N개 A1, A2, ..., AN이 주어진다. 이때, 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 구하는 프로그램을 작성하시오.

    즉, Ai + ... + Aj (i ≤ j) 의 합이 M으로 나누어 떨어지는 (i, j) 쌍의 개수를 구해야 한다.

    입력
    첫째 줄에 N과 M이 주어진다. (1 ≤ N ≤ 106, 2 ≤ M ≤ 103)

    둘째 줄에 N개의 수 A1, A2, ..., AN이 주어진다. (0 ≤ Ai ≤ 109)

    출력
    첫째 줄에 연속된 부분 구간의 합이 M으로 나누어 떨어지는 구간의 개수를 출력한다.
 */

public class q10986 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalCount = scanner.nextInt();
        int divideNumber = scanner.nextInt();

        long[] sumList = new long[totalCount];
        sumList[0] = scanner.nextInt();
        for(int s=1; s<totalCount; s++) {
             sumList[s] = sumList[s-1] + scanner.nextInt();
        }


        long result = 0;
        long[] remainderList = new long[divideNumber];
        for (long s : sumList) {
            int reminder = (int) (s % divideNumber);

            if (reminder == 0) {
                result++;
            }

            remainderList[reminder]++;
        }

        for (long r : remainderList) {
            if (r > 1) {
                result = result + (r * (r - 1) / 2);
            }
        }

        System.out.println(result);
    }
}
