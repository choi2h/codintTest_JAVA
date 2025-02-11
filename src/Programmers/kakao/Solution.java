package Programmers.kakao;

import java.util.*;

class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliever = 0; // 트럭에 실려 있는 배달 상자 수
        int pickup = 0; // 트럭에 실려 있는 수거 상자 수

        for (int i = n - 1; i >= 0; i--) {
            int cnt = 0;

            if (deliveries[i] > 0 || pickups[i] > 0) {
                while (deliever < deliveries[i] || pickup < pickups[i]) { // 배달 및 수거 완료까지 하나라도 남아있으면 들린다.
                    cnt++;

                    deliever += cap;
                    pickup += cap;
                }

                deliever -= deliveries[i]; // 남는 자리
                pickup -= pickups[i]; // 남는 자리

                answer += (i + 1) * cnt * 2; // 거리 * 횟수 * 왕복
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        //4, 4, [25, 24, 51, 0], [51, 0, 0, 49]
        // 트럭에 실을 수 있는 최대 물류 개수
//        int cap = 2;
//        int cap = 1;
//        int cap = 2;
//        int cap = 3;
//        int cap = 2;
        int cap = 4;
        // 집 수
//        int n = 7;
//        int n = 5;
//        int n = 2;
//        int n = 2;
//        int n = 2;
        int n = 4;
        // 각 집의 배달 박스 개수
//        int[] deliveries = {1, 0, 3, 1, 2};
//        int[] deliveries = {1, 0, 2, 0, 1, 0, 2};
//        int[] deliveries = {0, 0, 1, 0, 0};
//        int[] deliveries = {0, 0};
//        int[] deliveries = {2, 4};
//        int[] deliveries = {0, 6};
        int[] deliveries = {25, 24, 51, 0};

        // 각 집의 수거 박스 개수
//        int[] pickups = {0, 3, 0, 4, 0};
//        int[] pickups = {0, 2, 0, 1, 0, 2, 0};
//        int[] pickups = {0, 0, 0, 0, 0};
//        int[] pickups = {0, 4};
//        int[] pickups = {4, 2};
//        int[] pickups = {0, 0};
        int[] pickups = {51, 0, 0, 49};
        long result = solution.solution(cap, n, deliveries, pickups);
        System.out.println("result = " + result);
    }
}