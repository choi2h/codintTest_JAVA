import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<int[]>[] arr = new ArrayList[n+1];
        for(int i=0; i<n; i++) {
            arr[i+1] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            arr[a].add(new int[]{b,c});
            arr[b].add(new int[]{a,c});
        }

        int sum = 0;
        boolean[] visited = new boolean[n+1];
        PriorityQueue<int[]> queue = new PriorityQueue<>((a,b) -> a[1]-b[1]);
        queue.offer(new int[]{1, 0});
        while(!queue.isEmpty()) {
            int[] cur = queue.poll();

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            sum += cur[1];
            for(int[] next : arr[cur[0]]) {
                if(visited[next[0]]) continue;
                queue.add(next);
            }
        }

        System.out.print(sum);
    }
   
}