package inflearn.graph;

import java.util.Scanner;

/*
    중복 순열
 */
public class Q4 {
    static int[] pm; // 채우는 배열
    static int n,m; // n : 숫자의 개수           m : 채울 개수

    public void DFS(int L) {
        if(L==m) { // 채울 개수가 다 채웠다면
            for(int x: pm) { // 채워논 값 출력
                System.out.print(x + " ");
            }
            System.out.println();
        } else {
            for(int i=1; i<=n; i++) { // 1~n까지 돌면서
                pm[L] = i; // pm에 값 주입
                DFS(L+1); // pm의 다음 값 채우러 돌림
            }
        }

    }

    public static void main(String[] args) {
        Q4 q = new Q4();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        pm = new int[m];
        q.DFS(0);
    }
}
