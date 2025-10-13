import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int max = 0;
        int[] lectures = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++) {
            lectures[i] = Integer.parseInt(st.nextToken());
            max += lectures[i];
        }

        long answer = 1_000_000_001;
        long l=0, r=max, mid=0;
        while(l<=r) {
            mid = (l+r)/2;
            int cnt = getIdleCnt(lectures, m, mid);

            if (cnt <= 0) { 
                answer = Math.min(answer, mid);
                r = mid-1;
            } else l = mid+1;
        }

        System.out.print(answer);
    }

    private static int getIdleCnt(int[] lectures, long m, long size) {
        int cnt = 0, i = lectures.length-1;
        while (i>=0) {
            int sum=0;
            while(i>=0 && sum+lectures[i]<=size) sum += lectures[i--];
            cnt++;

            if(cnt>m) return 1;
        }

        return cnt==m ? 0 : -1;
    }  
}