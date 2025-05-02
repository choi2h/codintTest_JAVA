import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    static class Node {
        int x, y;
        Node(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = br.readLine().split(" ");
        int n = Integer.parseInt(str[0]);
        int m = Integer.parseInt(str[1]);

        int[][] map = new int[n][m];
        for(int i = 0; i < n; i++) {
            String[] input = br.readLine().split("");
            for(int j=0; j<input.length; j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        int[] movePoint = new int[]{-1, 1, 0, 0};
        int[][] records = new int[n][m];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0));
        records[0][0] = 1;
        while(!queue.isEmpty()) {
            Node cur = queue.poll();

            if(cur.x == n-1 && cur.y == m-1) {
                System.out.println(records[cur.x][cur.y]);
                break;
            }

            if(map[cur.x][cur.y] == -1) continue;
            map[cur.x][cur.y] = -1;
            for(int i = 0; i < movePoint.length; i++) {
                int moveX = cur.x + movePoint[i];
                int moveY = cur.y + movePoint[movePoint.length-1-i];
                if(moveX >= 0 && moveX < map.length && moveY >= 0 && moveY < map[moveX].length
                    && map[moveX][moveY] == 1 && records[moveX][moveY] == 0) {
                    records[moveX][moveY] = records[cur.x][cur.y] + 1;
                    queue.add(new Node(moveX, moveY));
                }
            }
        }


    }
}