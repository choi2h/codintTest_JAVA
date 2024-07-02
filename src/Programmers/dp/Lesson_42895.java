package Programmers.dp;

import java.util.*;

public class Lesson_42895 {


    public int solution(int N, int number) {
        Set<Integer>[] setArr = new Set[9];

        // N의 사용 횟수만큼 N을 반복하여 나타낼 수 있는 수를 미리 set에 넣어둠
        int repeatN = N;
        for(int i=1; i<9; i++) {
            // 각 횟수마다 HashSet 미리 세팅
            setArr[i] = new HashSet<>();
            setArr[i].add(repeatN);
            repeatN = repeatN*10+N;
        }

        // 최대 8번까지 N을 사용할 수 있음 -> 경우의 수 구하는 반복문 시작
        for(int i=1; i<9; i++) {

            for(int j=1;j<i; j++) {
                // 이미 저장되어 있는 횟수별 경우의 수를 합한다.
                // 만약 i가 4일경우 1,3 2,2 조합으로 4번사용하는 경우의 수를 구할 수 있다.
                for(int a : setArr[j]) {
                    for(int b : setArr[i-j]) {
                        setArr[i].add(a*b);
                        setArr[i].add(a+b);
                        setArr[i].add(a-b);
                        if(a!=0 && b!=0) {
                            setArr[i].add(a/b);
                        }
                    }
                }
            }

        }

        for(int i=1; i<9; i++) {
            if(setArr[i].contains(number)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Lesson_42895 lesson = new Lesson_42895();
        int result = lesson.solution(1, 212);
//        int result2 = lesson.solution2(1, 212);
//        int result = lesson.solution2(1, 212);
        System.out.println(result);
//        System.out.println(result2);
    }
}
