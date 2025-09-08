import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for(int s=1; s<=t; s++) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+1];
            for(int i=0; i<n; i++) {
                arr[i] = i;
            }

            int k = Integer.parseInt(br.readLine());
            while(k-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                union(arr, a, b);
            }
            
            sb.append("Scenario ").append(s).append(":\n");
            int m = Integer.parseInt(br.readLine());
            while(m-- > 0) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                
                sb.append(find(arr, a) == find(arr, b) ? 1 : 0).append("\n");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }


    private static void union(int[] arr, int a, int b) {
        int fa = find(arr, a);
        int fb = find(arr, b);

        arr[fa] = fb;
    }

    private static int find(int[] arr, int a) {
        if(arr[a] == a) return a;

        return arr[a] = find(arr, arr[a]);
    }
}