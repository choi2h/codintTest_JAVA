package Programmers.basic;

public class Lesson_12916 {
    boolean solution(String s) {
        s = s.toUpperCase();
        return s.replaceAll("P", "").length() == s.replaceAll("Y", "").length();
    }
}
