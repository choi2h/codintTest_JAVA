package inflearn.graph;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Q12 {
    static int n = 0;
    static int m = 0;
    static int answer = 0;
    static List<List<Integer>> graph;
    static int[] ch;
    public void DFS(int v) {
        if(v==n) {
            answer++;
        } else {
            for(int nv : graph.get(v)) {
                if(ch[nv] == 0) {
                    ch[nv]=1;
                    DFS(nv);
                    ch[nv]=0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Q12 q = new Q12();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n+1];
        for(int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        ch[1] = 1;
        q.DFS(1);
        System.out.println(answer);
    }
}
