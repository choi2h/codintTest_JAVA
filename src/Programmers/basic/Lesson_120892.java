package Programmers.basic;

import java.util.Arrays;

public class Lesson_120892 {

    public String solution(String cipher, int code) {
        StringBuilder answer = new StringBuilder();

        int n = 2;
        for(int i=code; i<=cipher.length(); i = code*n++) {
            answer.append(cipher.charAt(i-1));
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Lesson_120892 obj = new Lesson_120892();
        System.out.println(obj.solution("dfjardstddetckdaccccdegk", 4));
    }
}
