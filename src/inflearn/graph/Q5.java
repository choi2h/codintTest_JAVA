package inflearn.graph;

import java.util.Arrays;
import java.util.Scanner;

public class Q5 {

    static int answer = Integer.MAX_VALUE; // 가장 작은 값을 구할거기 떄문에 가장 큰 값을 기본으로 설정
    static int[] coins; // 코인의 종류
    static int change; // 줘야할 거스름돈

    public void DFS(int money, int count) {
        if(money==change) { // 거스름돈만큼 돈을 모았으면
            answer = Math.min(answer, count); // 기존 결과와 비교해서 작은 값을 결과로 설정
            return;
        }

        for(int i=coins.length-1; i>=0; i--) { // 가장 큰 코인부터 하나씩 추가
            if(money+coins[i] <= change && count < answer) { // 현재 코인을 추가했을 때 거스름돈을 초과하지 않아야하며 최소 동전 개수를 구해야하기 때문에 더 많은 동전의 개수는 확인할 필요가 없다.
                DFS(money+coins[i], count+1); // 가능한 경우 동전 추가
            } else {
                break;
            }
        }


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = in.nextInt();
        }
        change = in.nextInt();

        Arrays.sort(coins);
        Q5 q = new Q5();
        q.DFS(0, 0);

        System.out.println(answer);
    }
}
