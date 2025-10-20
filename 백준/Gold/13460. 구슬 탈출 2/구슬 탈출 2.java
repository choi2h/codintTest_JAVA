import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    private static final int MAX_CNT = 10;
    private static int[][] MOVE_POINTS = new int[][]{{-1, 0}, {1,0}, {0,-1}, {0,1}};
    private static char[][] board;
    private static int[] goal;
    private static int n;
    private static int m;
    private static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        n = Integer.parseInt(input[0]);
        m = Integer.parseInt(input[1]);

        char[] input2;
        board = new char[n][m];
        int rx = 0, ry = 0, bx = 0, by = 0;
        goal = new int[2];
        for (int i=0; i<n; i++) {
            input2 = br.readLine().toCharArray();
            for (int j=0; j<m; j++) {
                board[i][j] = input2[j];
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                } else if(board[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if(board[i][j] == 'O') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }

        answer = 11;
        dfs(rx, ry, bx, by, 1, 4);
        System.out.print(answer > 10 ? -1 : answer);
    }

    private static void dfs(int rx, int ry, int bx, int by, int cnt, int before) {
        if(cnt > MAX_CNT) return;
        

        for(int i=0; i<MOVE_POINTS.length; i++) {
            if (before == i) continue;
            int[] move = MOVE_POINTS[i];
            int mx = move[0], my = move[1];
            int nrx = rx, nry = ry;
            int nbx = bx, nby = by;

            boolean isRedGoal = false, isBlueGoal = false;
            if((i==0 && rx<bx) || (i==1 && rx>bx) || (i==2&&ry<by) || (i==3&&ry>by)) {
                while(!isRedGoal && board[nrx+mx][nry+my] != '#') {
                    nrx += move[0];
                    nry += move[1];

                    if(isGoal(nrx, nry)) {
                        isRedGoal = true;
                        nrx = 0;
                        nry = 0;
                    }
                }
                
                while(!isBlueGoal && board[nbx+mx][nby+my] != '#' && !(nbx+mx == nrx && nby+my == nry)) {
                    nbx += move[0];
                    nby += move[1];

                    if(isGoal(nbx, nby)) isBlueGoal = true;
                }
            } else {
                while(!isBlueGoal && board[nbx+mx][nby+my] != '#') {
                    nbx += move[0];
                    nby += move[1];

                    if(isGoal(nbx, nby)) isBlueGoal = true;
                }

                while(!isBlueGoal && !isRedGoal && board[nrx+mx][nry+my] != '#' && !(nrx+mx == nbx && nry+my == nby)) {
                    nrx += move[0];
                    nry += move[1];

                    if(isGoal(nrx, nry)) isRedGoal = true;
                }
            }

            if (isBlueGoal) continue;
            else if (isRedGoal) {
                answer = Math.min(answer, cnt);
                return;
            } else if (nrx == rx && nry == ry && nbx == bx && nby == by) continue;

            dfs(nrx, nry, nbx, nby, cnt+1, i);
        }
    }

    private static boolean isGoal(int x, int y) {
        return x == goal[0] && y == goal[1];
    }
}