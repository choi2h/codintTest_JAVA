package baekJoon.search;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
    숫자 야구
    https://www.acmicpc.net/problem/2503
 */
public class Q1090 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Checker> checkers = new ArrayList<>();
        int[] xList = new int[n];
        int[] yList = new int[n];

        for(int i=0; i<n; i++) {
            String[] coordinate = br.readLine().split(" ");
            int x = Integer.parseInt(coordinate[0]);
            int y = Integer.parseInt(coordinate[1]);

            xList[i] = x;
            yList[i] = y;
            Checker checker = new Checker(x, y);
            checkers.add(checker);
        }

        int[] answers = getMinimumMoveCounts(checkers, xList, yList, n);

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<n-1; i++) {
            sb.append(answers[i]).append(" ");
        }

        sb.append(answers[n-1]);
        System.out.println(sb);
    }

    private static int[] getMinimumMoveCounts(List<Checker> checkers, int[] xList, int[] yList, int n) {
        // 좌표들을 정렬한다.
        checkers.sort((o1, o2) -> {
            if (o1.x < o2.x) {
                return 1;
            } else if (o1.x > o2.x) {
                return -1;
            }

            return Integer.compare(o2.y, o1.y);
        });

        // x, y 를 배열로 따로 뽑아 정렬한다. xList yList

        // 정답을 저장할 배열
        // 가장 작은 값을 구해낼 것이기 Integer의 MAX값을 배열에 저장해 놓고 추후에 비교
        int[] answers = new int[n];
        for(int i=0; i<n; i++) {
            answers[i] = Integer.MAX_VALUE;
        }

        // x, y를 하나하나 돌며 좌표들의 거리를 비교한다. => 완전 탐색
        //x좌표들을 순회
        for(int i=0; i<n; i++) {
            int x = xList[i];
            //y좌표들을 순회
            for(int j=0; j<n; j++) {
                // 이동 횟수를 저장할 배열
                int[] counts = new int[n];
                int y = yList[j];

                // 모든 좌표들을 순회하며 이동 횟수 구함
                for(int k=0; k<n; k++) {
                    Checker checker = checkers.get(k);
                    int moveCount = checker.x > x ? checker.x-x : x-checker.x;
                    moveCount += checker.y > y ? checker.y-y : y-checker.y;

                    counts[k] = moveCount;
                }

                // 이동 횟수를 오름차순하여 낮은 것부터 하나하나 더함
                Arrays.sort(counts);
                int sum = 0;
                for(int c=0; c<n; c++) {
                    sum += counts[c];
                    // 개수당 합친 것과 기존 배열에 저장해놓은 값 중 작은 값을 배열에 저장
                    answers[c] = Math.min(sum, answers[c]);
                }
            }
        }

        return answers;
    }
}

class Checker {
    int x;
    int y;

    protected Checker(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

