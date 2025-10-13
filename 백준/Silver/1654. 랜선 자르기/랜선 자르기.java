import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int k = Integer.parseInt(input[0]);
        long n = Long.parseLong(input[1]);

        long[] cables = new long[k];
        for(int i=0; i<k; i++) {
            cables[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(cables);

        long answer = 0;
        long l=1, r=cables[k-1], mid=0;
        while(l<=r) {
            mid = (l+r)/2;
            
            int cnt=0;
            for(long cable: cables) {
                cnt += cable/mid;
            }

            if(cnt >= n) {
                answer = Math.max(mid, answer);
                l = mid+1;
            } else r = mid-1;
        }
        
        System.out.println(answer);
    }
}