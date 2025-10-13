import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        long k = Long.parseLong(br.readLine());

        long l=1, r=k, mid=0;
        while (l<=r) {
            mid = (l+r)/2;

            long sum = 0;
            for (int i=1; i<=n; i++) sum += Math.min(n, mid/i);

            if (sum >= k) r = mid-1; 
            else l = mid+1;
        }

        System.out.print(l);
    }   
}