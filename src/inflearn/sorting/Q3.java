package inflearn.sorting;

import java.util.Scanner;

public class Q3 {
    public int[] solution(int n, int[] nums) {
        for(int i=1; i<nums.length; i++) {
            for(int j=i; j>0; j--){
                if(nums[j] < nums[j-1]) {
                    int tmp = nums[j];
                    nums[j] = nums[j-1];
                    nums[j-1] = tmp;
                } else {
                    break;
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

        Q3 q = new Q3();
        for(int num : q.solution(n, nums)) {
            System.out.print(num  + " ");
        }
    }
}