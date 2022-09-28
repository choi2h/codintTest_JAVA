package inflearn.graph;

import java.util.Scanner;

/*
    순열구하기
 */
public class Q6 {
    static int[] pm, ch, arr;
    static int n, m;

    public void DFS(int L) {
        if(L==m) { // 개수를 다 채웠다면
            for(int x : pm) { // 쌓아놓은 값 출력
                System.out.print(x+" ");
            }
            System.out.println();
        } else {
            for(int i=0; i<n; i++) { // 모든 수를 돌면서
                if(ch[i]==0) { // 현재 값을 사용하지 않았다면
                    ch[i]=1; // 현재 값을 사용한다고 표시
                    pm[L] = arr[i]; // pm에 현재 값 추가
                    DFS(L+1); // 다음 값을 채우러 넣음
                    ch[i]=0; // 현재 값을 다 사용했으므로 표시 해제
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = in.nextInt();
        }

        ch = new int[n];
        pm = new int[m];

        Q6 q = new Q6();
        q.DFS(0);
    }
}
