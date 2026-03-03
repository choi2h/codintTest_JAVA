import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            int[] nums = new int[n+1];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i=1; i<=n; i++) {
                nums[i] = Integer.parseInt(st.nextToken());
            }

            int cnt = findCnt(n, nums);
            sb.append(cnt).append("\n");
        }

        System.out.println(sb);
    }


    private static int findCnt(int n, int[] nums) {
        int cnt = 0;
        boolean[] visited = new boolean[n+1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i=1; i<=n; i++) {
            if (nums[i] == i) {
                cnt++;
                continue;
            }

            if (visited[i]) continue;

            queue.add(i);
            while(!queue.isEmpty()) {
                int cur = queue.poll();

                if (visited[cur]) continue;
                visited[cur] = true;

                if (visited[nums[cur]]) {
                    cnt++;
                    break;
                }

                queue.add(nums[cur]);
            }
        }

        return cnt;
    }
}