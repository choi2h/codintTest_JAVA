package Programmers.kakao;

/*
    2023 KAKAO BLIND RECRUITMENT
    미로 탈출 명령어
 */
public class Lesson_150365 {

    private static final String[] moveStrings = {"d", "l", "r", "u"};
    private String result;

    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int minimumMoveCount = getMoveCount(x, r) + getMoveCount(y, c);
        // 출발 위치부터 도착 위치까지 최소이동 거리가
        // 홀수이면 k도 홀수여야지만 도착할 수 있다.
        // 짝수이면 k도 짝수여야지만 도착할 수 있다.
        if((minimumMoveCount%2==0 && k%2!=0) || (minimumMoveCount%2==1 && k%2!=1)) {
            return "impossible";
        }

        dfs(n, m, r, c, x, y, k, "");

        return result==null ? "impossible" : result;
    }

    // 출발지는 필요 없음 출발지에서 시작만 하면 됨.
    // 모든 좌표는 중복 방문 가능
    // 도착지, 현재 위치, 현재까지의 이동 경로(이동경로의 length == 이동 거리), 총 이동 가능 거리
    private void dfs(int n, int m, int r, int c, int x, int y, int k, String moveRecord) {
        // 범위가 벗어나거나 이미 사전순으로 가장 빠른 경로를 찾았을 경우 종료
        if(x <1 || x > n || y < 1 || y > m || (result != null && !result.isEmpty())) {
            return;
        }

        // 도착지에 도착했고 이동 숫자를 다 채웠다면 종료
        if(moveRecord.length() == k) {
            if(r==x && c==y) {
                result  = moveRecord;
            }
            return;
        }

        // 현재 위치부터 도착지까지의 최소 이동거리
        int minimumMoveCount = getMoveCount(x, r) + getMoveCount(y, c);
        // 채워야 하는 이동거리 > 현재까지 이동한 거리+다음위치부터도착지까지의 거리 > 확인 후 이동
        if(k < moveRecord.length()+minimumMoveCount) {
            return;
        }

        // 목적지에 도착했는데 아직 총 이동 거리를 만족하지 못한 경우 -> 다른 곳을 들렸다 오려면 무조건 짝수만큼만 움직일 수 있다..
        if(r==x && c==y && minimumMoveCount%2 != 0) {
            return;
        }

        for(String moveString :moveStrings) {
            switch (moveString) {
                // 세로 - 아래로 이동 d
                case "d" :
                    dfs(n, m, r, c, x+1, y, k, moveRecord+moveString);
                    break;
                // 가로 - 왼쪽으로 이동 l
                case "l" :
                    dfs(n, m, r, c, x, y-1, k, moveRecord+moveString);
                    break;
                // 가로 - 오른쪽으로 이동 r
                case "r" :
                    dfs(n, m, r, c, x, y+1, k, moveRecord+moveString);
                    break;
                // 세로 - 위로 이동 u
                case "u" :
                    dfs(n, m, r, c, x-1, y, k, moveRecord+moveString);
                    break;
            }
        }
    }

    private int getMoveCount(int s, int e) {
        return s>e ? s-e : e-s;
    }

    /*
        n	m	x	y	r	c	k	result
        3	4	2	3	3	1	5	"dllrl"
        2	2	1	1	2	2	2	"dr"
        3	3	1	2	3	3	4	"impossible"
     */
    public static void main(String[] args) {
        Lesson_150365 lesson = new Lesson_150365();


//        String result = lesson.solution(3, 4, 2, 3, 3, 1, 5);
        String result = lesson.solution(2, 2, 1, 1, 2, 2, 2);
//        String result = lesson.solution(3, 3, 1, 2, 3, 3, 4);
        System.out.println("result = " + result);
    }
}
