import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        long k = Long.parseLong(input[1]);

        if (k < 10) {
            if (N < k) {
                System.out.println(-1);
            } else {
                System.out.println(k);
            }
            return;
        }

        long n = 9, m = 1, cur = 1;
        long cnt = 0, next = 9;
        while (k > next) {
            cnt = next;

            m++;
            cur *= 10;
            next += n * m * cur;
        }

        long gap = k-cnt;
        long sum = gap/m;
        cur += sum-1;
        cnt += m*sum;

        if (cur > N) {
            System.out.println(-1);
        } else if (cnt == k) {
            System.out.println(cur%10);
        } else if (cur+1 <= N) {
            System.out.println(getTargetNumber(cnt, cur+1, k));
        } else {
            System.out.println(-1);
        }
    }

    private static int getTargetNumber(long cnt, long cur, long target) {
        String[] numStr = String.valueOf(cur).split("");

        for (String s : numStr) {
            cnt++;

            if (cnt == target) {
                return Integer.parseInt(s);
            }
        }

        return -1;
    }
}