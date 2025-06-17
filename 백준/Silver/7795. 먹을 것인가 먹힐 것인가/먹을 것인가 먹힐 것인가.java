import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());

        while(k-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            StringTokenizer nNumbers = new StringTokenizer(br.readLine());
            int[] A = new int[n];
            for (int i = 0; i < n; i++) {
                A[i] = Integer.parseInt(nNumbers.nextToken());
            }

            StringTokenizer mNumbers = new StringTokenizer(br.readLine());
            int[] B = new int[m];
            for (int i = 0; i < m; i++) {
                B[i] = Integer.parseInt(mNumbers.nextToken());
            }

            Arrays.sort(A);
            Arrays.sort(B);

            int count = 0;
            for(int aNum : A) {
                count += getSmallCount(aNum, B);
            }

            System.out.println(count);
        }
    }

    private static int getSmallCount(int num, int[] B) {
        int l = 0, r = B.length-1;
        int count = -1;
        while(l <= r) {
            int m = (l+r)/2;

            if(num > B[m]) {
                count = m;
                l = m+1;
            } else r = m-1;
        }

        return count >= 0 ? count+1 : 0;
    }
}