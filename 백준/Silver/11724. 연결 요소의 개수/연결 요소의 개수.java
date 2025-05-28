import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        List<Integer>[] arr = new ArrayList[n+1];
        for(int i=0; i<n+1; i++) {
            arr[i] = new ArrayList<>();
        }

        for(int i=0; i<m; i++) {
            String[] input2 = br.readLine().split(" ");
            int a = Integer.parseInt(input2[0]);
            int b = Integer.parseInt(input2[1]);
            arr[a].add(b);
            arr[b].add(a);
        }


        int answer = 0;
        int[] dp = new int[n+1];
        for(int i=1; i<n+1; i++) {
            if(dp[i] > 0) continue;
            dfs(arr, dp, i, ++answer);
        }

        System.out.println(answer);
    }

    private static void dfs(List<Integer>[] arr, int[] dp, int cur, int checkNum) {
        for(int i : arr[cur]) {
            if(dp[i] > 0) continue;
            dp[i] = checkNum;
            dfs(arr, dp, i, checkNum);
        }
    }
}