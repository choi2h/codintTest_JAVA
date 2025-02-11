package Programmers.dfsbfs;

// https://school.programmers.co.kr/learn/courses/30/lessons/169199
public class Lesson_169199 {

    private static final String HURDLE = "D";
    private static final String START = "R";
    private static final String GOAL = "G";

    private int[][] checkCount;

    // 도착지 상하좌우로 방해물 혹은 보드의 끝부분이 없으면 도달시킬 수 없다.
    public int solution(String[] board) {
        int[] startIndex = new int[2];
        int[] goalIndex = new int[2];
        String[][] arr = new String[board.length][board[0].length()];
        checkCount = new int[board.length][board[0].length()];
        for(int i=0; i<board.length; i++) {
            arr[i] = board[i].split("");

            if(board[i].contains(START)) {
                startIndex[0] = i;
                startIndex[1] = board[i].indexOf(START);
            }

            if(board[i].contains(GOAL)) {
                goalIndex[0] = i;
                goalIndex[1] = board[i].indexOf(GOAL);
            }
        }

        move(arr, startIndex[0], startIndex[1], 0);
        int answer = checkCount[goalIndex[0]][goalIndex[1]];
        return answer < 1 ? -1 : answer;
    }

    private void move(String[][] arr, int x, int y, int count) {
        if(!checkCanMove(arr, x, y)) {
            return;
        }

        if(checkCount[x][y] != 0 && checkCount[x][y] <= count) {
            return;
        }

        checkCount[x][y] = count;

        if(arr[x][y].equals(GOAL) || (count > 0 && arr[x][y].equals(START))) {
            return;
        }


        int upperX = findNextPoint(arr, x, y, "U")+1;
        if(upperX < x) {
            move(arr, upperX, y, count+1);
        }

        int lowerX = findNextPoint(arr, x, y, "D")-1;
        if(lowerX > x) {
            move(arr, lowerX, y, count + 1);
        }

        int leftY = findNextPoint(arr, x, y, "L")+1;
        if(leftY < y) {
            move(arr, x, leftY, count+1);
        }

        int rightY = findNextPoint(arr, x, y, "R")-1;
        if(rightY > y) {
            move(arr, x, rightY, count+1);
        }
    }

    private int findNextPoint(String[][] arr, int x, int y, String move) {
        while(checkCanMove(arr, x, y)) {
            if(move.equals("U")) x--;
            else if(move.equals("D")) x++;
            else if(move.equals("L")) y--;
            else if(move.equals("R")) y++;
        }

        return move.equals("U") || move.equals("D") ? x : y;
    }

    private boolean checkCanMove(String[][] arr, int x, int y) {
        return (x >= 0 && x <arr.length) &&
                (y >= 0 && y < arr[x].length) &&
                !arr[x][y].equals(HURDLE);
    }

    //["...D..R", ".D.G...", "....D.D", "D....D.", "..D...."]	7
    //[".D.R", "....", ".G..", "...D"]	-1
    public static void main(String[] args) {
        Lesson_169199 lesson = new Lesson_169199();
//        String[] arr = {"...D..R", ".D.G...", "....D.D", "D....D.", "..D...."};
//        String[] arr = {"...D..R", ".D.....", "G...D.D", "D....D.", "..D...."};
        String[] arr = {".D.R", "....", ".G..", "...D"};
        System.out.println(lesson.solution(arr));
    }
}
