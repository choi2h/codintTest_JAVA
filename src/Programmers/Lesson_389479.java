package Programmers;


public class Lesson_389479 {
    // m명 늘어날 때마다 서버 1대가 추가로 필요로 한다.
    // nxm명 이상 (n+1)xm명 미만이라면 최소 n대의 증설된 서버가 운영중이여야 한다.
    // 증설한 서버는 k시간 동안 운영
    // 최소 몇 번 증설해야하는지 알고싶다.
    // 같은 시간대에 서버를 x대 증설했다면 해당 시간대의 증설 횟수는 x회이다.
    //
    public int solution(int[] players, int m, int k) {
        int answer = 0;

        int current = 0;
        int[] histories = new int[players.length];
        for(int i=0; i<players.length; i++) {
            if(i>=k && histories[i-k] > 0) {
                current -= histories[i-k];
            }

            if(players[i] < m) {
                continue;
            }

            int need = players[i]/m;
            if(current < need) {
                histories[i] = need-current;
                answer += histories[i];

                current = need;
            }
        }

        return answer;
    }


    /*
    {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5}	3	5	7
    {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0}	5	1	11
    {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1}	1	1	12
     */
    public static void main(String[] args) {
        Lesson_389479 lesson = new Lesson_389479();
//        int[] players = {0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5};
//        int m = 3;
//        int k = 5;
//        int[] players = {0, 0, 0, 10, 0, 12, 0, 15, 0, 1, 0, 1, 0, 0, 0, 5, 0, 0, 11, 0, 8, 0, 0, 0};
//        int m = 5;
//        int k = 1;
        int[] players = {0, 0, 0, 0, 0, 2, 0, 0, 0, 1, 0, 5, 0, 2, 0, 1, 0, 0, 0, 0, 0, 0, 0, 1};
        int m = 1;
        int k = 1;
        int result = lesson.solution(players, m, k);
        System.out.println(result);
    }
}
