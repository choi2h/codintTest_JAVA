package inflearn.graph;

import java.util.Scanner;

public class Q11 {
    static int n = 0;
    static int m = 0;
    static int answer = 0;
    static int[][] graph;
    static int[] ch;
    public void DFS(int v) {
        if(v==n) {
            answer++;
        } else {
            for(int i=0; i<=n; i++) {
                if(graph[v][i] == 1 && ch[i]==0) {
                    ch[i]=1;
                    DFS(i);
                    ch[i]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q11 q = new Q11();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new int[n+1][n+1];
        ch = new int[graph.length];
        ch[1] = 1;

        for(int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph[a][b] = 1;
        }

        q.DFS(1);
        System.out.println(answer);
    }
}
