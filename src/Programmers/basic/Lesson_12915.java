package Programmers.basic;

import java.util.Arrays;

public class Lesson_12915 {

    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings, (a,b) -> a.charAt(n) == b.charAt(n) ? a.compareTo(b) : a.charAt(n) - b.charAt(n));
        return strings;
    }

}
