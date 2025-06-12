import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]>[] edges = new ArrayList[n+1];
        for (int i=0; i<=n; i++) {
            edges[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken());
            int end = Integer.parseInt(st2.nextToken());
            int count = Integer.parseInt(st2.nextToken());

            edges[start].add(new int[]{end, count});
            edges[end].add(new int[]{start, count});
        }

        solution(n, edges);
    }

    public static void solution(int n, List<int[]>[] edges) {
        int[] counts = new int[n+1];
        Arrays.fill(counts, -1);

        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        counts[1] = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            for(int[] edge : edges[cur]) {
                int next = edge[0];
                if (counts[next] > -1 && counts[next] <= counts[cur] + edge[1]) continue;

                counts[next] = counts[cur] + edge[1];
                queue.add(next);
            }
        }

        System.out.println(counts[n]);
    }
}