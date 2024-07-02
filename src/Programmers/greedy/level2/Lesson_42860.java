package Programmers.greedy.level2;

// https://school.programmers.co.kr/learn/courses/30/lessons/42860
// 그리디 - 조이스틱
public class Lesson_42860 {


    public int solution(String name) {
        int move = name.length()-1;
        int change = 0;
        // 이름의 자리수만큼 처음에는 다 A로 이루어져 있다.
        for(int i=0; i<name.length(); i++) {
            change += Math.min(name.charAt(i)-'A', 'Z'-name.charAt(i) + 1);

            int next = i+1;
            while(next < name.length() && name.charAt(next) == 'A') {
                next++;
            }

            // 총 이동 횟수,
            // (지금 위치까지의 이동 횟수 or 뒤에서 nex까지의 길이) + 현재까지
            // i를 도착점이라 생각하고 전체를 다 순회한 이동 횟수를 계산하여 비교하는 것
            move = Math.min(move, i + name.length()-next + Math.min(i, name.length()-next));
        }

        return move + change;
    }


    public static void main(String[] args) {
        Lesson_42860 lesson_42860 = new Lesson_42860();
        int n = lesson_42860.solution("BABBAABB");
        System.out.println(n);

    }
}
