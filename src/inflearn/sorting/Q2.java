package inflearn.sorting;

import java.util.Scanner;

public class Q2 {
    public int[] solution(int n, int[] nums) {
        for(int i=n-1; i>0; i--) {
            for(int j=0; j<i; j++){
                if(nums[j] > nums[j+1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }

        return nums;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        for(int i=0; i<n; i++) {
            nums[i] = in.nextInt();
        }

        Q2 q = new Q2();
        for(int num : q.solution(n, nums)) {
            System.out.print(num  + " ");
        }
    }
}
