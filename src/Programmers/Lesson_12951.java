package Programmers;

import java.util.Objects;

public class Lesson_12951 {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        boolean flag = true;
        String[] str = s.toLowerCase().split("");

        for(String w : str) {
            answer.append(flag ? w.toUpperCase() : w);
            flag = Objects.equals(w, " ");
        }

        return answer.toString();
    }

    /*
    "3people unFollowed me"	"3people Unfollowed Me"
    "for the last week"	"For The Last Week"
     */
    public static void main(String[] args) {
        Lesson_12951 lesson = new Lesson_12951();
//        String result = lesson.solution("3people unFollowed me");
        String result = lesson.solution("3people unFollowed m");
//        String result = lesson.solution("s");
        System.out.println(result);
    }
}
