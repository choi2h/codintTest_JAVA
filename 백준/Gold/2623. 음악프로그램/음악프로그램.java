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

        List<Integer>[] singers = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            singers[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            StringTokenizer input = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(input.nextToken());
            int pre = 0;
            for(int j=0; j<x; j++) {
                int next = Integer.parseInt(input.nextToken());

                if(j > 0) singers[next].add(pre);
                pre = next;
            }
        }

        String answer = solution(singers);
        System.out.println(answer);
    }

    private static String solution(List<Integer>[] singers) {
        int[] orders = new int[singers.length];
        for(int i=1; i<singers.length; i++) {
            if(singers[i].isEmpty()) continue;

            Queue<Integer> queue = new LinkedList<>();
            queue.add(i);
            boolean[] visited = new boolean[singers.length];
            int count = 0;
            while(!queue.isEmpty()) {
                int cur = queue.poll();

                if(visited[cur]) continue;
                visited[cur] = true;
                count++;
                for (int next : singers[cur]) {
                    if(next == i) return "0";
                    if(!visited[next]) queue.add(next);
                }
            }

            orders[i] = count;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<orders.length; i++) {
            for(int j=1; j<orders.length; j++) {
                if(orders[j] == i) sb.append(j).append("\n");
            }
        }

        return sb.toString();
    }
}