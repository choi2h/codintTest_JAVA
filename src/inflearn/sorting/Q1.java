package inflearn.sorting;

import java.util.Scanner;

public class Q1 {
    public int[] solution(int n, int[] nums) {

        for(int i=0; i<nums.length-1; i++) {
            int minIndex = i;

            for(int j=i+1; j<nums.length; j++){
                if(nums[minIndex] > nums[j]) {
                    minIndex = j;
                }
            }

            int tmp = nums[i];
            nums[i] = nums[minIndex];
            nums[minIndex] = tmp;
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

        Q1 q = new Q1();
        for(int num : q.solution(n, nums)) {
            System.out.print(num  + " ");
        }
    }
}