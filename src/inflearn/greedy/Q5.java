package inflearn.greedy;

import java.util.*;

class Edge1 implements Comparable<Edge1> {
    public int vex;
    public int cost;

    Edge1(int vex, int cost) {
        this.vex = vex;
        this.cost = cost;
    }


    @Override
    public int compareTo(Edge1 ob) {
        return this.cost-ob.cost;
    }
}

public class Q5 {

    static int n,m;
    static List<List<Edge1>> graph;
    static int[] dis;

    public void solution(int v) {
        PriorityQueue<Edge1> pQ = new PriorityQueue<>();
        pQ.offer(new Edge1(v, 0));
        dis[v]=0;
        while(!pQ.isEmpty()) {
            Edge1 tmp = pQ.poll();
            int now = tmp.vex;
            int nowCost = tmp.cost;
            if(nowCost>dis[now]) {
                continue;
            }

            for(Edge1 ob : graph.get(now)) {
                if(dis[ob.vex] > nowCost+ob.cost) {
                    dis[ob.vex] = nowCost+ob.cost;
                    pQ.offer(new Edge1(ob.vex, nowCost+ob.cost));
                }
            }
        }

    }

    public static void main(String[] args) {
        Q5 q = new Q5();
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        m = in.nextInt();
        graph = new ArrayList<>();
        for(int i=0; i<=n; i++) {
            graph.add(new ArrayList<>());
        }
        dis = new int[n+1];
        Arrays.fill(dis, Integer.MAX_VALUE);
        for(int i=0; i<m; i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            graph.get(a).add(new Edge1(b, c));
        }
        q.solution(1);
        for(int i=2; i<=n; i++) {
            if(dis[i]!=Integer.MAX_VALUE) {
                System.out.println(i + " : " + dis[i]);
            } else {
                System.out.println(i + " : impossible");
            }
        }
    }
}
