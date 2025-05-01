import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        long[] arr = new long[100];
        arr[0] = 1;
        arr[1] = 1;
        arr[2] = 1;
        for(int i=3; i<arr.length; i++) {
            arr[i] = arr[i-3] + arr[i-2];
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(arr[n-1]).append("\n");
        }
        System.out.println(sb);
    }
}