package inflearn.graph;

import java.util.Scanner;

/*
    트럭에 바둑이들을 최대한 많이 실을 수 있는 무게를 구하시오
 */
public class Q2 {
    static int maxWeight = 0; // 최대 무게
    static int answer=0; // 가장 많이 실을 수 있는 무게
    static int[] dogsWeight; // 바둑이들의 무게
    static int[] ch; // 바둑이를 태울건지 안태울건지 체크

    public void DFS(int L, int sum) {
        if(L==dogsWeight.length) { // 모든 인덱스를 다 체크한 뒤
            if(sum<maxWeight) { //최대 무게보다 현재 실은 바둑이의 무게가 적으면
                answer = Math.max(answer, sum); // 그 중에 가장 큰 값을 결과에 담는다.
            }
            return;
        }


        ch[L]=1; // 현재 인덱스의 바둑이를 데리고 간다.
        DFS(L+1, sum + dogsWeight[L]); // 다음 바둑이 체크 + 무게에 현재 바둑이 무게를 더한다.

        ch[L]=0; // 현재 인덱스의 바둑이를 데리고 가지 않는다.
        DFS(L+1, sum); // 다음 바둑이 체크
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        maxWeight = in.nextInt();
        int n = in.nextInt();
        dogsWeight = new int[n];
        for(int i=0; i<n; i++) {
            dogsWeight[i] = in.nextInt();
        }

        ch = new int[n];
        Q2 q = new Q2();
        q.DFS(0, 0);
        System.out.println(answer);
    }
}
