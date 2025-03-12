package Programmers.search.basic.level1;

public class Lesson_12939 {

    public String solution(String s) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        for(String str : s.split(" ")) {
            int i = Integer.parseInt(str);
            if(max < i) {
                max = i;
            }

            if(min > i) {
                min = i;
            }
        }

        return min + " " + max;
    }

    public static void main(String[] args) {
        Lesson_12939 sol = new Lesson_12939();
        String result = sol.solution("-1 -2 -3 -4");
        System.out.println(result);
    }
}
