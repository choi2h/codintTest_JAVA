import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        int max_cnt = 0;
        int[] record = new int[N];
        for (int i=0; i<N; i++) {
            int num = nums[i];
            int index = findIndex(record, num, max_cnt);
            record[index] = num;
            max_cnt = Math.max(max_cnt, index+1);
        }

        System.out.println(max_cnt);
    }

    private static int findIndex(int[] record, int target, int maxIndex) {
        if (maxIndex == 0) return 0;

        int l = 0, r = maxIndex-1, find = 0;
        while (l <= r) {
            int mid = (l+r)/2;

            if (record[mid] <= target) {
                l = mid + 1;
                find = Math.max(find, mid);
            } else {
                r = mid - 1;
            }
        }

        return record[find] < target ? find+1 : find;
    }

}