import java.io.BufferedReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        for(int i=0; i<n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);
        int answer = 0, i=n;
        while(i-- >= 0) {
            int cnt = 2;
            while(cnt-- > 0 && i >= 0) {
                answer += arr[i--];
            }
        }

        System.out.print(answer);
    }
}