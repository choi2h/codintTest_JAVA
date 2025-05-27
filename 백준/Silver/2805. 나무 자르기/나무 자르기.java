import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input1 = br.readLine().split(" ");
        int n = Integer.parseInt(input1[0]);
        long m = Long.parseLong(input1[1]);
        String[] input2 = br.readLine().split(" ");
        long[] arr = new long[n];
        long max = 0, min = 0;
        for(int i=0; i<input2.length; i++){
            arr[i] = Long.parseLong(input2[i]);
            max = Math.max(max, arr[i]);
            min = Math.min(min, arr[i]);
        }

        Arrays.sort(arr);
        long answer = 0;
        while(max >= min) {
            long mid=(max+min)/2;
            long sum = 0;

            for(int i=arr.length-1; i>=0; i--){
                if(arr[i] <= mid) break;
                sum += arr[i]-mid;
            }

            if(sum >= m) {
                answer = mid;
                min = mid+1;
            } else max = mid-1;
        }

        System.out.println(answer);
    }
}