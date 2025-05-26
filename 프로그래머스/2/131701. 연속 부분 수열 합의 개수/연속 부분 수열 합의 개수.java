import java.util.HashSet;
import java.util.Set;

class Solution {
      public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();

        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        set.add(nums[0]);
        for(int i=1; i<nums.length; i++) {
            sum[i] = sum[i-1] + nums[i];
            set.add(sum[i]);
        }

        for(int i=1; i<nums.length; i++) {
            for(int j=i; j<nums.length; j++) {
                set.add(sum[j]-sum[i-1]);
            }

            for(int j=0; j<i-1; j++) {
                set.add((sum[sum.length-1]-sum[i-1]) + sum[j]);
            }
        }

        return set.size();
    }
}