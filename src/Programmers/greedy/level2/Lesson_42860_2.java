package Programmers.greedy.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860
// 그리디 - 조이스틱
public class Lesson_42860_2 {


    public int solution(String name) {
       int move = name.length()-1;
       int change = 0;

       for(int i=0; i<name.length(); i++) {
            char c = name.charAt(i);
            change += changeCount(c);

            int next = i+1;
            while (next<name.length() && name.charAt(next) == 'A') {
                next++;
            }

            move = Math.min(move,Math.min(i, name.length()-next) + i + (name.length()-next));
       }

        System.out.println(change);
        System.out.println(move);
       return change + move;
    }

    private int changeCount(char c) {
        return Math.min(c-'A', 'Z'-c+1);
    }


    public static void main(String[] args) {
        Lesson_42860_2 lesson_42860 = new Lesson_42860_2();
        int n = lesson_42860.solution("JEROEN");
        System.out.println(n);
    }
}
