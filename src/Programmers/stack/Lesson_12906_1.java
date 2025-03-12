package Programmers.stack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lesson_12906_1 {
    public int[] solution(int []arr) {
        List<Integer> answer = new ArrayList<>();

        for(int i : arr) {
            if(answer.isEmpty()) answer.add(i);
            else if(answer.get(answer.size()-1) != i) answer.add(i);
        }

        int[] result = new int[answer.size()];
        for(int i=0; i<answer.size(); i++) {
            result[i] = answer.get(i);
        }
        return result;
    }

    /*
    [1,1,3,3,0,1,1]	[1,3,0,1]
    [4,4,4,3,3]	[4,3]
     */
    public static void main(String[] args) {
        Lesson_12906_1 lesson = new Lesson_12906_1();
        int[] result = lesson.solution(new int[]{1,1,3,3,0,1,1});
//        int[] result = lesson.solution(new int[]{4,4,4,3,3});

        System.out.println(Arrays.toString(result));
    }
}
