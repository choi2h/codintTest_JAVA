package inflearn.graph;

import java.util.Scanner;

public class Q3 {

    static Question[] questions;
    static int maxTime=0;
    static int answer=0;

    public void DFS(int L, int time, int score) {
        if(L==questions.length) { // 모든 인덱스를 다 돌았으면 종료
            answer = Math.max(answer, score); // 여태까지의 점수 합 중 큰 값을 결과에 담음
            return;
        }

        if(time+questions[L].time <= maxTime){ // 지금까지의 시간과 현재 시간이 최대시간 이하이면 시간과 점수를 더하여 다음 검사
            DFS(L+1, time+questions[L].time, score+questions[L].score);
        }

        DFS(L+1, time, score); // 현재 문제를 무시하고 다음 문제 검사
    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        maxTime = in.nextInt();
        questions = new Question[n];
        for(int i=0; i<n; i++) {
            int score = in.nextInt();
            int time = in.nextInt();
            questions[i] = new Question(score, time); // 문제당 점수와 시간을 가진 객체 생성
        }

        Q3 q = new Q3();
        q.DFS(0, 0, 0);

        System.out.println(answer);
    }

    static class Question {
        int score;
        int time;

        public Question(int score, int time) {
            this.score = score;
            this.time = time;
        }
    }
}
