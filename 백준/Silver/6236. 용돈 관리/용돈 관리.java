import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int n=Integer.parseInt(input[0]), m=Integer.parseInt(input[1]);

        int[] amounts = new int[n];
        int min=0, max=0;
        for(int i=0; i<n; i++) {
            amounts[i] = Integer.parseInt(br.readLine());
            min = Math.max(amounts[i], min);
            max += amounts[i];
        }

        int mid = 0, answer = 1_000_000_001;
        while(min <= max) {
            mid = (min+max)/2;

            int idleCnt = idleWithdrawCnt(amounts, mid, m);

            if (idleCnt >= 0) {
                max = mid-1;
                answer = Math.min(answer, mid);
            } else min = mid+1;
        }

        System.out.print(answer);
    }

    private static int idleWithdrawCnt(int[] amounts, int amount, int maxCnt) {
        int i=0, sum=0, cnt=0;
        while(i<amounts.length) {
            sum=0;
            while (i < amounts.length && sum+amounts[i] <= amount) sum += amounts[i++];
            cnt++;
            if (maxCnt<cnt) return -1;
        }

        return maxCnt == cnt ? 0 : 1;
    }
    
}