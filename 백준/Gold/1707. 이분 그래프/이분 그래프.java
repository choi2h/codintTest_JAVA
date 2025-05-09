import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());

        StringBuilder builder = new StringBuilder();
        for(int i=0; i<n; i++) {
            String[] input = reader.readLine().split(" ");
            int nodeCount = Integer.parseInt(input[0]);
            int lineCount = Integer.parseInt(input[1]);

            List<Integer>[] nodes = new ArrayList[nodeCount+1];
            for(int j=1; j<=nodeCount; j++) {
                nodes[j] = new ArrayList<>();
            }

            for(int j=0; j<lineCount; j++) {
                String[] node = reader.readLine().split(" ");
                int s = Integer.parseInt(node[0]);
                int e = Integer.parseInt(node[1]);

                nodes[s].add(e);
                nodes[e].add(s);
            }

            builder.append(isValid(nodeCount, nodes) ? "YES" : "NO").append("\n");
        }

        System.out.println(builder);
    }

    private static boolean isValid(int nodeCount, List<Integer>[] nodes) {
        int[] check = new int[nodeCount+1];

        for (int i=1; i<nodes.length; i++) {
            if (nodes[i].isEmpty() || check[i] != 0) continue;
            if(!bfs(check, i, nodes)) return false;
        }

        return true;
    }

    private static boolean bfs(int[] check, int start, List<Integer>[] nodes) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        check[start] = 1;
        while(!queue.isEmpty()) {
            int cur = queue.poll();

            for(int i : nodes[cur]) {
                if(check[i] == 0) {
                    queue.add(i);
                    check[i] = check[cur] == 1 ? 2 : 1;
                }

                if(check[i] == check[cur]) return false;
            }
        }

        return true;
    }
}