package Programmers.hash.level2;

import java.util.HashSet;
import java.util.Set;

public class Lesson_1845 {

    public int solution(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<nums.length; i++) {
            set.add(nums[i]);
        }

        return Math.min(set.size(), nums.length/2);
    }

    public static void main(String[] args) {
        Lesson_1845 obj = new Lesson_1845();
        System.out.println(obj.solution(new int[]{3,1,2,3}));
        System.out.println(obj.solution(new int[]{3,3,3,2,2,4}));
        System.out.println(obj.solution(new int[]{3,3,3,2,2,2}));
    }
}
