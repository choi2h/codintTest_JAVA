import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] map = new int[n+2][3];

            String[] startInput = br.readLine().split(" ");
            int[] start = new int[]{0, Integer.parseInt(startInput[0]), Integer.parseInt(startInput[1])};
            for(int j=1; j<n+2; j++) {
                String[] input = br.readLine().split(" ");
                map[j][0] = j;
                map[j][1] = Integer.parseInt(input[0]);
                map[j][2] = Integer.parseInt(input[1]);
            }


            String result = isArriveHappy(map, start) ? "happy" : "sad";
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static boolean isArriveHappy(int[][] map, int[] start) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        boolean[] visited = new boolean[map.length];
        while(!queue.isEmpty()) {
            int[] cur =  queue.poll();
            if(cur[0] == map.length-1) return true;

            if(visited[cur[0]]) continue;
            visited[cur[0]] = true;
            for(int[] next : map) {
                if(visited[next[0]]) continue;
                int diffDist = Math.abs(cur[1] - next[1]) + Math.abs(cur[2] - next[2]);
                if(diffDist <= 20*50) queue.add(next);
            }

        }

        return false;
    }
}