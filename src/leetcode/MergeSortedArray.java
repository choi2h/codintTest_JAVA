package leetcode;

// https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150

/*
    You are given two integer arrays nums1 and nums2, sorted in non-decreasing order,
    and two integers m and n, representing the number of elements in nums1 and nums2 respectively.
    Merge nums1 and nums2 into a single array sorted in non-decreasing order.
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        MergeSortedArray mereSortedArray = new MergeSortedArray();

        int[] nums1 = {1,2,3,0,0,0};
        int[] nums2 = {2,5,6};

        int m = 3;
        int n = 3;
        mereSortedArray.merge(nums1, m, nums2, n);
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        System.out.println("Start");

        int index1 = m-1;
        int index2 = n-1;

        int index = m+n-1;

        while (index1 >= 0 || index2 >= 0) {
            if(index1 < 0) {
                nums1[index--] = nums2[index2--];
                continue;
            }

            if(index2 < 0) {
                nums1[index--] = nums1[index1--];
                continue;
            }


            if(nums1[index1] < nums2[index2]) {
                nums1[index--] = nums2[index2--];
            } else {
                nums1[index--] = nums1[index1--];
            }
        }

        for(int i : nums1) {
            System.out.print(i + " ");
        }

    }
}
