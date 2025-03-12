package Programmers.search.basic.level1;

public class Lesson_12939_1 {
    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(String str : s.split(" ")) {
            int i = Integer.parseInt(str);

            min = Math.min(min, i);
            max = Math.max(max, i);
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        Lesson_12939_1 lesson = new Lesson_12939_1();
        System.out.println(lesson.solution("1 2 3 4"));
        System.out.println(lesson.solution("-1 -2 -3 -4"));
    }


}
