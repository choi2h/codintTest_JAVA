import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][3];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
            arr[i][2] = Integer.parseInt(st.nextToken());
        }

        StringBuilder sb = new StringBuilder();
        boolean[][] visited = new boolean[n+1][n+1];
        for(int i=1; i<=q; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            if(!visited[start][start] || visited[end][start]) {
                find(arr, visited, start);
            }

            int result = visited[start][end] || visited[end][start]? 1: 0;
            sb.append(result).append("\n");
        }

        System.out.println(sb);
    }

    private static void find(int[][] arr, boolean[][] visited, int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);

        while(!queue.isEmpty()) {
            int cur = queue.poll();

            if(visited[start][cur]) continue;
            visited[start][cur] = true;

            for(int i=0; i< arr.length; i++) {
                if(visited[start][i]) continue;
                if(canMove(arr[cur], arr[i])) {
                    queue.add(i);
                }
            }
        }
    }

    private static boolean canMove(int[] a, int[] b) {
        return (a[0] >= b[0] && a[0] <= b[1])
                || (a[1] >= b[0] && a[1] <= b[1])
                || (b[0] >= a[0] && b[0] <= a[1])
                || (b[1] >= a[0] && b[1] <= a[1]);
    }
}