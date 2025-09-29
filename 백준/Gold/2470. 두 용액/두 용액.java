import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputs = br.readLine().split(" ");
        long[] arr = new long[n];
        for(int i=0; i<n; i++) {
            arr[i] = Long.parseLong(inputs[i]);
        }
        Arrays.sort(arr);

        int l=0, r=n-1;
        long gap = 2_000_000_000;
        long[] answer = new long[2];
        while(l<r) {
            long sum = arr[l] + arr[r];
            if(gap > Math.abs(sum)) {
                gap = Math.abs(sum);
                answer[0] = arr[l];
                answer[1] = arr[r];
            }
            
            if (sum > 0) r--;
            else l++;
        }

        System.out.print(answer[0] + " " + answer[1]);
    }
}