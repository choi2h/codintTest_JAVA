package Programmers.basic;

public class Lesson_389479 {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        int[] times = new int[players.length];
        int currentCount = 0;
        for(int i = 0; i < players.length; i++) {
            if(i-k >= 0) currentCount = currentCount-times[i-k];
            if(players[i] / m <= currentCount) continue;

            int addSize = players[i]/m-currentCount;
            currentCount += addSize;
            times[i] = addSize;
            answer += addSize;
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
        Lesson_389479 solution = new Lesson_389479();
        System.out.println(solution.solution(players, 3, 5));
    }
}
