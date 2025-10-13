import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[] houses = new int[n];
        for (int i=0; i<n; i++) {
            houses[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(houses);

        int answer = 0;
        int l=0, r=houses[n-1]-houses[0], mid=0;
        while (l<=r) {
            mid = (l+r)/2;

            int idleCnt = getIdleCnt(houses, mid, m);
            if (idleCnt >= 0) {
                answer = Math.max(answer, mid);
                l = mid+1;
            } else r = mid-1;
        }
        
        System.out.print(answer);
    }

    private static int getIdleCnt(int[] houses, int dist, int maxCnt) {
        int i=0, cnt=0;
        while (i<houses.length) {
            int ni = i+1;
            while (ni < houses.length && houses[ni]-houses[i] < dist) ni++;
            i = ni;
            cnt++;
            if(cnt > maxCnt) return 1;
        }

        return cnt == maxCnt ? 0 : -1;
    }
}