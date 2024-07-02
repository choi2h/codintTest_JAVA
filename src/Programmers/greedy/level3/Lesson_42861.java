package Programmers.greedy.level3;

import java.util.Arrays;
import java.util.Comparator;

public class Lesson_42861 {

    int[] arr;

    public int solution(int n, int[][] costs) {
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = i;
        }

        // 가중치 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int answer = 0;
        for(int i=0; i<costs.length; i++) {
            int a = costs[i][0];
            int b = costs[i][1];
            int cost = costs[i][2];

            // 각각 다리의 최종 도착지 조회
            int fa = find(a);
            int fb = find(b);
            // 두 다리가 한 곳에서 만나지 않으면
            if(fa != fb) {
                // 비용을 추가한 후
                answer += cost;
                // 다리 설치 & 연결지점 재설정
                union(a, b);
            }
        }

        return answer;
    }

    private void union(int a, int b) {
        int fa = find(a);
        int fb = find(b);

        if(fa != fb) {
            arr[fa] = fb;
        }
    }

    private int find(int v) {
        if(arr[v] == v) {
            return v;
        }

        return arr[v] = find(arr[v]);
    }

    // 4	[[0,1,1],[0,2,2],[1,2,5],[1,3,1],[2,3,8]]	4
    public static void main(String[] args) {
        int n = 4;
//        int[][] costs = {{0,1,1}, {0,2,2}, {1,2,5}, {1,3,1}, {2,3,8}};
        int[][] costs = {{0,1,1}, {0,2,1}, {0,3,1}};

//        int n = 5;
//        int[][] costs = {{0, 1, 1}, {2, 3, 1}, {3, 1, 3}, {4, 0, 5}, {4, 2, 4}};

        Lesson_42861 lesson = new Lesson_42861();
        int result = lesson.solution(n, costs);
        System.out.println(result);
    }
}
