import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws IOException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int sum = 0;
        int[] nums = new int[N];
        for (int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(br.readLine());
            sum += nums[i];
        }

        StringBuilder sb = new StringBuilder();
        double div = (double)sum / N;
        sb.append(Math.round(div)).append('\n');

        Arrays.sort(nums);
        int mid = N%2 == 0 ? (N/2)-1 : N/2;
        sb.append(nums[mid]).append('\n');


        int num = 0, max_cnt= 0, duplicate_max_cnt = 0;
        int l = 0, r = 0;
        while (l < N) {
            while (r < N && nums[r] == nums[l]) {
                r++;
            }

            int cnt = r-l;
            if (cnt > max_cnt) {
                num = nums[l];
                max_cnt = cnt;
                duplicate_max_cnt = 1;
            } else if (cnt == max_cnt && duplicate_max_cnt < 2) {
                num = nums[l];
                duplicate_max_cnt += 1;
            }

            l = r;
        }

        sb.append(num).append('\n');

        sb.append(nums[N-1]-nums[0]);
        System.out.print(sb);
    }

}
