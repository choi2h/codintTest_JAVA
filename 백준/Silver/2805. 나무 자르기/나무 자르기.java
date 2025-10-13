import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long[] trees = new long[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            trees[i] = Long.parseLong(st.nextToken());
        }
        
        Arrays.sort(trees);

        long answer=0;
        long l=0, r=trees[n-1], mid=0;
        while(l<=r) {
            mid = (l+r)/2;

            long sum = getTotalHeight(trees, mid);
            if(sum >= m) {
                answer = Math.max(answer, mid);
                l = mid+1;
            } else r = mid-1;
        }

        System.out.print(answer);
    }

    private static long getTotalHeight(long[] trees, long cut) {
        long sum = 0;
        for(int i=trees.length-1; i>=0; i--) {
            if(trees[i] <= cut) break;

            sum += trees[i]-cut;
        }

        return sum;
    }
}