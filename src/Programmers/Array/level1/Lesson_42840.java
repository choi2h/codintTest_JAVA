package Programmers.Array.level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson_42840 {
    int[][] pattern = {
            {1,2,3,4,5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    public int[] solution(int[] answers) {
        int[] counts = new int[pattern.length];
        for(int i=0; i<pattern.length; i++) {
            int n = 0;
            for (int answer : answers) {
                if (n >= pattern[i].length) n = 0;
                if (answer == pattern[i][n++]) counts[i]++;
            }
        }

        int max = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0; i<counts.length; i++) {
            if (counts[i] > max) {
                list.clear();

                max = counts[i];
                list.add(i + 1);
            } else if (counts[i] == max) list.add(i + 1);
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        Lesson_42840 obj = new Lesson_42840();
        System.out.println(Arrays.toString(obj.solution(new int[]{1,3,2,4,2})));
    }
}
