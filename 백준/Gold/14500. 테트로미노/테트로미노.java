import java.io.*;
import java.util.*;

public class Main {

    private static final int[][][][] blocks = {
            // ㅣ
            {{{1}, {1}, {1}, {1}}},

            // L
            {
                {{1, 0}, {1, 0}, {1, 1}},
                {{0, 1}, {0, 1}, {1, 1}},
                {{1, 1, 1}, {1, 0, 0}},
                {{1, 1, 1}, {0, 0, 1}},
                {{1, 0, 0}, {1, 1, 1}},
                {{0, 0, 1}, {1, 1, 1}},
                {{1, 1}, {0, 1}, {0, 1}},
                {{1, 1}, {1, 0}, {1, 0}}
            },

            // _-
            {
                {{1, 0}, {1, 1}, {0, 1}},
                {{0, 1}, {1, 1}, {1, 0}},
                {{0, 1, 1}, {1, 1, 0}},
                {{1, 1, 0}, {0, 1, 1}}
            },

            // ㅜ
            {
                {{1, 1, 1}, {0, 1, 0}},
                {{0, 1, 0}, {1, 1, 1}},
                {{1, 0}, {1, 1}, {1, 0}},
                {{0, 1}, {1, 1}, {0, 1}}
            },

            // ㅁ
            {
                {{1, 1}, {1, 1}}
            }
    };

    private static int n;
    private static int m;
    private static int[][] map;

    /**
     * 정사각형은 서로 겹치면 안 된다.
     * 도형은 모두 연결되어 있어야 한다.
     * 정사각형의 변끼리 연결되어 있어야 한다. 즉, 꼭짓점과 꼭짓점만 맞닿아 있으면 안 된다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for (int x=0; x<n; x++) {
            st = new StringTokenizer(br.readLine());
            for (int y=0; y<m; y++) {
                map[x][y] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int x=0; x<n; x++) {
            for (int y=0; y<m; y++) {
                answer = Math.max(answer, find(x, y));
            }
        }

        System.out.println(answer);
    }

    private static int find(int x, int y) {
        int maxSum = findSumForLine(x, y);

        for (int i=1; i<5; i++) {
            for (int j=0; j<blocks[i].length; j++) {
                int xLen = blocks[i][j].length;
                int yLen = blocks[i][j][0].length;
                if (x+xLen-1 < n && y+yLen-1 < m) {
                    maxSum = Math.max(maxSum, findSum(x, y, i, j, xLen, yLen));
                }
            }
        }

        return maxSum;
    }

    private static int findSum(int x, int y, int i, int j, int xLen, int yLen) {
        int sum = 0;
        for (int cx=0; cx<xLen; cx++) {
            for (int cy=0; cy<yLen; cy++) {
                if (blocks[i][j][cx][cy] == 1) {
                    sum += map[x+cx][y+cy];
                }
            }
        }

        return sum;
    }

    private static int findSumForLine(int x, int y) {
        int w = 0;
        if (x+4 <= n) {
            for (int i=0; i<4; i++) {
                w += map[x+i][y];
            }
        }

        int h = 0;
        if (y+4 <= m) {
            for (int i = 0; i < 4; i++) {
                h += map[x][y + i];
            }
        }

        return Math.max(w, h);
    }
}