import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] input = reader.readLine().split(" ");
        int n =  Integer.parseInt(input[0]);
        int m =  Integer.parseInt(input[1]);

        int[] indegree = new int[n+1];
        List<Integer>[] array = new ArrayList[n+1];
        for(int i = 1; i <= n; i++) {
            array[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            String[] input2 = reader.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            indegree[b]++;
            array[a].add(b);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=1; i<=n; i++) {
            if(indegree[i] == 0) {
                pq.add(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()) {
            int cur = pq.poll();
            sb.append(cur).append(" ");

            for(int next : array[cur]) {
                indegree[next]--;

                if(indegree[next] == 0) pq.add(next);
            }
        }

        System.out.println(sb);
    }
}