package inflearn.array;

import java.util.Scanner;

/*
    등수구하기
    설명
    N명의 학생의 국어점수가 입력되면 각 학생의 등수를 입력된 순서대로 출력하는 프로그램을 작성하세요.
    같은 점수가 입력될 경우 높은 등수로 동일 처리한다.
    즉 가장 높은 점수가 92점인데 92점이 3명 존재하면 1등이 3명이고 그 다음 학생은 4등이 된다.

    입력
    첫 줄에 N(3<=N<=100)이 입력되고, 두 번째 줄에 국어점수를 의미하는 N개의 정수가 입력된다.
    출력
    입력된 순서대로 등수를 출력한다.

    예시 입력 1
    5
    87 89 92 100 76
    예시 출력 1
    4 3 2 1 5
 */
public class Q8 {
    public int[] solution(int[] scores) {
        int[] answer=new int[scores.length];

//        for(int i=0; i<scores.length; i++) {
//            for(int j=i+1; j<scores.length; j++) {
//                if(scores[i]>scores[j]) {
//                    answer[j]++;
//                } else if(scores[i]<scores[j]){
//                    answer[i]++;
//                }
//            }
//
//            answer[i]++;
//        }

        for(int i=0; i<scores.length; i++) {
            int cnt=1;
            for(int j=0; j<scores.length; j++) {
                if(scores[j]>scores[i]) cnt++;
            }
            answer[i]=cnt;
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] scores = new int[count];
        for(int i=0; i<count; i++) {
            scores[i] = in.nextInt();
        }

        Q8 q = new Q8();
        for(int i : q.solution(scores)) {
            System.out.print(i + " ");
        }
    }
}
