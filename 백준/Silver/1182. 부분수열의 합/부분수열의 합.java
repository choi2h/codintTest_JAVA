import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        int s = Integer.parseInt(input1[1]);

        int[] arr = new int[n];
        String[] input2 = br.readLine().split(" ");
        for(int i=0; i<input2.length; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }


        dfs(arr, new boolean[n], s, 0, 0);
        System.out.println(s == 0 ?count-1 : count);
    }

    private static void dfs(int[] arr, boolean[] visited, int find, long sum, int idx) {
        if(sum == find) count++;
        if(idx > arr.length) return;

        for(int i=idx; i<arr.length; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            dfs(arr, visited, find, sum+arr[i], i+1);
            visited[i] = false;
        }
    }
}