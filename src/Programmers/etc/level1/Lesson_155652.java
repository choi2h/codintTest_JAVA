package Programmers.etc.level1;

import java.util.ArrayList;
import java.util.List;

/*
둘만의 암호
URL : https://school.programmers.co.kr/learn/courses/30/lessons/155652
 */
public class Lesson_155652 {

    public String solution(String s, String skip, int index) {
        StringBuilder answer = new StringBuilder();

        List<Character> skipList = new ArrayList<>();
        for(char c : skip.toCharArray()) {
            skipList.add(c);
        }

        for(char c : s.toCharArray()) {
            int count = 0;
            while (count < index) {
                c++;
                if(c > 'z') {
                    c = 'a';
                }

                if(skip.contains(String.valueOf(c))) {
                    continue;
                }

                count++;
            }


            answer.append(c);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        Lesson_155652 lesson = new Lesson_155652();
//        String s = "z";
//        String skip = "abcdefghij";
//        int index = 20;

        String s = "aukks";
        String skip = "wbqd";
        int index = 5;

//        String s = "zzzzz";
//        String skip = "abcdefghijklmnopqrstuvwxy";
//        int index = 6;


        String result = lesson.solution(s, skip, index);

        System.out.println(result);
    }
}
