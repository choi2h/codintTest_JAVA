import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        List<Integer>[] arr = new ArrayList[N+1];
        for(int i=0; i<=N; i++) {
            arr[i] = new ArrayList();
        }

        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            arr[s].add(e);
            arr[e].add(s);
        }

        for(int i=1; i<=N; i++) {
            Collections.sort(arr[i]);
        }

        boolean[] visited = new boolean[N+1];
        List<Integer> visitOrder = new ArrayList<>();
        dfs(arr, visited, V, visitOrder);

        String dfsResult = joinArray(visitOrder);
        String bfsResult = bfs(V, arr);

        System.out.print(dfsResult + "\n" + bfsResult);
    }

    private static void dfs(List<Integer>[] arr, boolean[] visited, int cur, List<Integer> visitOrder) {
        visited[cur] = true;
        visitOrder.add(cur);
        
        for(int next : arr[cur]) {
            if(visited[next]) continue;
            dfs(arr, visited, next, visitOrder);
        }
    }

    private static String bfs(int V, List<Integer>[] arr) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(V);

        boolean[] visited = new boolean[arr.length];
        List<Integer> visitOrder = new ArrayList<>();
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(visited[cur]) continue;
            visited[cur] = true;
            visitOrder.add(cur);

            for(int next : arr[cur]) {
                if(visited[next]) continue;
                queue.add(next);
            }
        }

        return joinArray(visitOrder);
    }

    private static String joinArray(List<Integer> arr) {
        StringBuilder sb = new StringBuilder();
        for(int n : arr) {
            sb.append(n).append(" ");
        }

        return sb.toString();
    }
}