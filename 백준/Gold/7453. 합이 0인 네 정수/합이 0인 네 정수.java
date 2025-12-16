import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        int[] B = new int[N];
        int[] C = new int[N];
        int[] D = new int[N];
        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        long cnt = 0;
        int[] a_b_sum_nums = getSumNums(A, B);
        int[] c_d_sum_nums = getSumNums(C, D);
        Arrays.sort(a_b_sum_nums);
        Arrays.sort(c_d_sum_nums);
        for (int i=0; i<c_d_sum_nums.length; i++) {
            int find_num = c_d_sum_nums[i] * -1;
            int index = search_num(a_b_sum_nums, find_num);
            if (index == -1) continue;

            long find_ab_cnt = get_cnt(a_b_sum_nums, find_num, index);
            int upper_bound = search_upper_bound(c_d_sum_nums, c_d_sum_nums[i], i);
            long find_cd_cnt = upper_bound - i;
            cnt += find_ab_cnt * find_cd_cnt;
            i = upper_bound-1;
        }

        System.out.println(cnt);
    }

    private static int[] getSumNums(int[] a, int[] b) {
        int[] sum_nums = new int[a.length * b.length];
        int idx = 0;
        for (int i : a) {
            for (int j : b) {
                sum_nums[idx++] = i+j;
            }
        }

        return sum_nums;
    }

    private static int search_num(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l <= r) {
            int mid = (l+r)/2;

            if (nums[mid] == target) return mid;

            if (nums[mid] > target) {
                r = mid-1;
            } else {
                l = mid+1;
            }
        }

        return -1;
    }

    private static long get_cnt(int[] nums, int target, int n) {
        int upper_bound = search_upper_bound(nums, target, n);
        int lower_bound = search_lower_bound(nums, target, n);
        return upper_bound - (lower_bound+1);
    }

    private static int search_upper_bound(int[] nums, int target, int n) {
        while (n < nums.length && nums[n] == target) {
            n++;
        }

        return n;
    }

    private static int search_lower_bound(int[] nums, int target, int n) {
        while (n >= 0 && nums[n] == target) {
            n--;
        }

        return n;
    }
}