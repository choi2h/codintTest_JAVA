import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        List<Integer>[] arr = new ArrayList[n+1];
        for(int i=0; i<=n; i++) {
            arr[i] = new ArrayList();
        }

        for(int i=0; i<m; i++) {
            String[] input = br.readLine().split(" ");
            int s = Integer.parseInt(input[0]);
            int e = Integer.parseInt(input[1]);

            arr[s].add(e);
            arr[e].add(s);
        }

        boolean[] visited = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        int answer = 0;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(visited[cur])  continue;
            visited[cur] = true;
            answer++;
            for(int next : arr[cur]) {
                if(visited[next]) continue;
                queue.offer(next);
            }
        }

        System.out.print(answer-1);
    }
}