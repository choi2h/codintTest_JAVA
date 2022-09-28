package inflearn.graph;

import java.util.*;

public class Q13 {
    static  int n, m, answer = 0;
    static List<List<Integer>> graph;
    static int[] ch, dis;

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        ch[v] = 1;
        dis[v] = 0;
        queue.offer(v);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            List<Integer> list = graph.get(cur);
            for(int nv : list) {
                if(ch[nv] == 0) {
                    ch[nv]=1;
                    queue.offer(nv);
                    dis[nv] = dis[cur]+1;
                }
            }
        }


    }

    public static void main(String[] args) {
        Q13 q = new Q13();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }

        ch = new int[n+1];
        dis = new int[n+1];
        for(int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            graph.get(a).add(b);
        }

        q.BFS(1);
        for(int i=2; i<=n; i++) {
            System.out.println(i + " : " + dis[i]);
        }
    }
}
