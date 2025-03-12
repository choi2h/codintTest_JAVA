package Programmers.Array;

import java.util.Arrays;

public class Lesson_181879 {
    public int solution(int[] num_list) {
        return num_list.length > 10 ?
                Arrays.stream(num_list).sum() :
                Arrays.stream(num_list).reduce(1, (answer, num) -> answer*num);
    }

    public static void main(String[] args) {
        Lesson_181879 lesson = new Lesson_181879();
//        int result = lesson.solution(new int[]{3, 4, 5, 2, 5, 4, 6, 7, 3, 7, 2, 2, 1});
        int result = lesson.solution(new int[]{2, 3, 4, 5});
        System.out.println(result);
    }
}
