import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++) {
            String[] input = br.readLine().split(" ");
            int n = Integer.parseInt(input[0]);
            int k = Integer.parseInt(input[1]);

            int[] node = new int[n+1];
            String[] times = br.readLine().split(" ");
            for(int j=1; j<=n; j++) {
                node[j] = Integer.parseInt(times[j-1]);
            }

            List<Integer>[] preArray = new ArrayList[n+1];
            for(int j=1; j<preArray.length; j++) {
                preArray[j] = new ArrayList<>();
            }

            for(int j=0; j<k; j++) {
                String[] connect = br.readLine().split(" ");
                int a = Integer.parseInt(connect[0]);
                int b = Integer.parseInt(connect[1]);
                preArray[b].add(a);
            }

            int[] visitRecord = new int[n+1];
            Arrays.fill(visitRecord, -1);
            int target = Integer.parseInt(br.readLine());
            int answer = dfs(node, preArray, visitRecord, target);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    private static int dfs(int[] node, List<Integer>[] preArray, int[] visitRecord, int target) {
        if(visitRecord[target] > -1) {
            return visitRecord[target];
        }

        if(preArray[target].isEmpty()) {
            return visitRecord[target] = node[target];
        }

        int time = 0;
        for(int pre : preArray[target]) {
            time = Math.max(dfs(node, preArray, visitRecord, pre), time);
        }

        visitRecord[target] = time + node[target];
        return time + node[target];
    }
}