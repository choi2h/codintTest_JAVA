import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        for(int i=0; i<n; i++) {
            arr[i][0] = Integer.parseInt(br.readLine());
            arr[i][1] = i;
        }

        Arrays.sort(arr, (a,b) -> a[0]-b[0]);
        int min = 0;
        for(int i=0; i<n; i++) {
            min = min < arr[i][1] - i ? arr[i][1] - i : min;
        }
        
        System.out.print(min+1);
    }
}